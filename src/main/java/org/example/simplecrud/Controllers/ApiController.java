package org.example.simplecrud.Controllers;

import org.example.simplecrud.Models.Users;
import org.example.simplecrud.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public  String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<Users> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody Users user){
        userRepo.save(user);
        return "Saved ...";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Users user){
        Users updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated ...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id){
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with the id: "+id;
    }
}
