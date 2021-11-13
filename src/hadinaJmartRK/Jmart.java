package hadinaJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

public class Jmart
{
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int count = 0; count < list.size(); count++){
            if(minPrice <= 0.0){
                if(list.get(count).price <= maxPrice){
                    products.add(list.get(count));
                }
            }
            else if(maxPrice <= 0.0){
                if(list.get(count).price >= minPrice){
                    products.add(list.get(count));
                }
            }
            else{
                if(list.get(count).price >= minPrice && list.get(count).price <= maxPrice){
                    products.add(list.get(count));
                }
            }
        }
        return products;
    }
    public static void main(String[] args)
    {
        try{
            List<Product> list = read("C:/Users/asus/Documents/prakoop/jmart/src/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 98000.0, 0.0);
            filtered.forEach(product -> System.out.println(product.price));

            List<Product> filteredName = filterByName(list, "nme", 1, 5);
            filteredName.forEach(product -> System.out.println(product.name));

            List<Product> filteredAccount = filterByAccountId(list, 1, 0, 5);
            filteredAccount.forEach(product -> System.out.println(product.name));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
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

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(a -> pred.predicate(a)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> read(String filepath) {
        List <Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext())


        }
    }
}
