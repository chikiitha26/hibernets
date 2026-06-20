package com.cvr.userdemo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins="http://127.0.0.1:550")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.find(id).orElse(null);
    }

   
    @GetMapping("/name/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findByName(name).orElse(null);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}