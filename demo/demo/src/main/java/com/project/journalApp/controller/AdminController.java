package com.project.journalApp.controller;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import com.project.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserEntryService userEntryService;

    @GetMapping
    public ResponseEntity<?>getAllUsers(){
        List<User> all = userEntryService.getAll();
        if(all!=null&&!all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create_admin-user")
    public void createUser(@RequestBody User user){
        userEntryService.saveAdmin(user);
    }
}
