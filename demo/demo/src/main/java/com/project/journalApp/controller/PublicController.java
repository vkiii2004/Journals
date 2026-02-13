package com.project.journalApp.controller;

import com.project.journalApp.entity.User;
import com.project.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserEntryService userEntryService;
    @PostMapping
    public void createUser(@RequestBody User user){
        userEntryService.saveNewEntry(user);
    }
}
