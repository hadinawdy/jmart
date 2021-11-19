package com.hadinaJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.List;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

@SpringBootApplication
public class Jmart
{
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> pred = p -> (p.accountId == accountId);
        return paginate(list, page, pageSize, pred);
    }
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product: list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> pred = p -> (p.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, pred);
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        if(minPrice <= 0){
            list.removeIf(product -> product.price > maxPrice);
        }
        else if(maxPrice <= 0){
            list.removeIf(product -> product.price < minPrice);
        }
        else{
            list.removeIf(product -> (product.price < minPrice) || (product.price > maxPrice));
        }
        return list;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Jmart.class, args);
        try{
            String filepath = "C:\\Users\\asus\\Documents\\prakoop\\jmart\\src\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password", 0));
            tableAccount.writeJson();
            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString() + "nme"));
        }
        catch (Throwable a)
        {
            a.printStackTrace();
        }
    }
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred)
    {
        try{
            List<Product> filteredList = list.stream().filter(p -> pred.predicate(p)).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if (endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }
        catch (Exception e){
            return list.subList(0,0);
        }
    }
    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}