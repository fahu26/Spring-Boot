package com.fahim;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Index {

    @GetMapping()
    Map<String,String> index(){
        Map map = new HashMap<String, String>();
        map.put("title", "Home Page Orders Management System.");
        map.put("waktu", new Date());
        return  map;
    }
}