package com.hadinaJmartRK.controller;

import com.hadinaJmartRK.dbjson.JsonTable;
import com.hadinaJmartRK.dbjson.Serializable;
import com.hadinaJmartRK.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {

    @GetMapping("/id")
    default T getById(int id){
        return Algorithm. <T>find((Iterator<T>) getJsonTable(), (e) -> e.id==id);
    }

    JsonTable<T> getJsonTable();

    @GetMapping("/page")
    default List<T> getPage(int page, int pageSize){
        return Algorithm. <T>paginate(getJsonTable(), page, pageSize, e->true);
    }
}