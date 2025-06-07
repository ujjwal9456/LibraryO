package com.LibraryO.LibraryManagement.Controller;

import com.LibraryO.LibraryManagement.model.Library;
import com.LibraryO.LibraryManagement.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class BaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LibraryRepository libraryRepository;

    @GetMapping(path = "/Ping")
    public String GetAliveStatus(){

        String sql = "INSERT INTO public.\"library\" (libraryname) VALUES ('AnotherLibrary')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
        return "Yes I am up";
    }

    @PostMapping(path="/AddALibrary")
    public Library AddALibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

    @GetMapping(path = "/GetLibraries")
    public List<Library> GetLibraryNames(){
        return libraryRepository.findAll();
    }

    @GetMapping(path="/test")
    public String GetTest(){
        return "smf";
    }

    @GetMapping(path="/tabContent")
    @ResponseBody
    public String GetTabContent(@RequestParam int id){
        Library uj = libraryRepository.findById(id).orElse(null);

        return uj != null ? uj.getDescription() : "Not found";
    }


}