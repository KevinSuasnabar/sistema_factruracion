package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.models.dbseeders.DatabaseSeedersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v0")
public class AdminController {

    public static final String ADMINS = "/admins";
    public static final String DB = "/db";

    @Autowired
    private DatabaseSeedersService databaseSeedersService;

    @PostMapping(value= AdminController.ADMINS)
    public void seedDatabase(){
        this.databaseSeedersService.generateAllData();
    }

    @DeleteMapping(value = AdminController.DB)
    public void deleteDatabase(){
    this.databaseSeedersService.deleteAll();
    }
}
