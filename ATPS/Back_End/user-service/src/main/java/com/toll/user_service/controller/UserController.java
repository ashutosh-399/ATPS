package com.toll.user_service.controller;

import com.toll.user_service.entity.User;
import com.toll.user_service.service.UserService;
import com.toll.user_service.userdto.LoginDTO;
import com.toll.user_service.userdto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "fluffy-selkie-7f14d3.netlify.app")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(userService.registerUser(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(userService.loginUser(loginDTO));
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/updateWallet/{userId}")
    public ResponseEntity<String> updateWallet(@PathVariable Long userId, @RequestParam Double amount){
        return ResponseEntity.ok(userService.updateWallet(userId, amount));
    }

}
