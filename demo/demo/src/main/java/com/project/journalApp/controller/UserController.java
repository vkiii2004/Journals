package com.project.journalApp.controller;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import com.project.journalApp.service.UserEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserEntryService userEntryService;

    @Autowired
    private UserRepository userRepository;




    @PutMapping
    public ResponseEntity<?>updateUser(@RequestBody User user){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User userIndb = userEntryService.findByUserName(userName);
        if(userIndb!=null){
            userIndb.setUserName(user.getUserName());
            userIndb.setPassword(user.getPassword());
            userEntryService.saveNewEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?>deleteUserById(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
