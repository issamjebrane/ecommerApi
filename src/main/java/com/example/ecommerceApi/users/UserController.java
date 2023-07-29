package com.example.ecommerceApi.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    public final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userServices.getUsers();
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable Integer id){
        return userServices.getUser(id);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userServices.login(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Integer id){
       return  userServices.updateUser(user,id);
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestBody Integer id){
        userServices.deleteUser(id);
        return "deleted";
    }
    @GetMapping("/page/{pageNum}")
    public ResponseEntity<Page<User>> getUsersByPage(@PathVariable int pageNum,
                                                     @RequestParam(defaultValue = "6") int pageSize) {
        Page<User> usersPage = userServices.getUsersByPage(pageNum, pageSize);
        return ResponseEntity.ok(usersPage);
    }
}
