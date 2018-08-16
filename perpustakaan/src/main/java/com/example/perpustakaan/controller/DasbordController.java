package com.example.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasbordController {
    @RequestMapping("/halamnan")
    public String testtest(){
        return "HalamanAdmin";
    }
}
