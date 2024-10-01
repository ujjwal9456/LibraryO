package com.LibraryO.LibraryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class BaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(path = "/Ping")
    public String GetAliveStatus(){

        String sql = "INSERT INTO public.\"Library\" (libraryname) VALUES ('AnotherLibrary')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }



        return "Yes I am up";
    }

    @RequestMapping("/home")
    public String index(){
        return "com/LibraryO/LibraryManagement/Views/Home.jsp";
    }


}