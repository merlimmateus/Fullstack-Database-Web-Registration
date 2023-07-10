package com.dataBaseWebProject.demo.controller;

import com.dataBaseWebProject.demo.model.User;
import com.dataBaseWebProject.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    List<User> findALL(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    User findOne(@PathVariable int id){
        return repository.findById(id).orElse(null);
    }
    @PostMapping("/")
    User create(@RequestBody User user){
        return repository.save(user);
    }
    @PutMapping("/{id}")
    User update(@PathVariable int id, @RequestBody User user){
        User oldUser = repository.findById(id).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return repository.save(oldUser);
    }

    @DeleteMapping(value = "/{id}")
    Integer destroy(@PathVariable int id){
        repository.deleteById(id);
        return id;
    }


}
