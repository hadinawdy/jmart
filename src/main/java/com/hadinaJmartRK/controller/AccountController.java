package com.hadinaJmartRK.controller;

import com.hadinaJmartRK.Account;
import com.hadinaJmartRK.Algorithm;
import com.hadinaJmartRK.dbjson.JsonTable;
import com.hadinaJmartRK.Store;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Collections;
import java.util.regex.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    )
    {
        if(name.isBlank())
            return null;
        Matcher matcher1 = REGEX_PATTERN_EMAIL.matcher(email);
        if(!matcher1.find())
            return null;
        Matcher matcher2 = REGEX_PATTERN_PASSWORD.matcher(password);
        if(!matcher2.find())
            return null;
        if(Algorithm.<Account>find((Iterable<Account>) accountTable, obj -> obj.email.equals(email)) != null)
            return null;

        MessageDigest msgd = null;
        try {
            msgd = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = msgd.digest(password.getBytes());
        BigInteger no = new BigInteger(1, digest);
        String hash = no.toString(16);
        while (hash.length() < 32) hash = "0" + hash;
        Account i = new Account(name, email, hash, 0);
        accountTable.add(i);
        return i;
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        MessageDigest msgd = null;
        try {
            msgd = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = msgd.digest(password.getBytes());
        BigInteger no = new BigInteger(1, digest);
        String hash = no.toString(16);
        while (hash.length() < 32) hash = "0" + hash;
        String finalHash = hash;
        return Algorithm.<Account>find((Iterable<Account>) accountTable, obj -> obj.email.equals(email) && obj.password.equals(finalHash));
    }

    @PostMapping("/{id}/registerStore")
    public Store registerStore(int id, String name, String address, String phoneNumber) {
        for (Account account : accountTable) {
            if (account.id == id && account.store != null) {
                account.store = new Store(name, address, phoneNumber, 0.0);
                return account.store;
            }
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    public boolean topUp(int id, double balance) {
        for (Account account : accountTable) {
            if (account.id == id) {
                account.balance += balance;
                return true;
            }
        }
        return false;
    }
}