package com.toll.user_service.service;

import com.toll.user_service.entity.User;
import com.toll.user_service.repository.UserRepo;
import com.toll.user_service.userdto.LoginDTO;
import com.toll.user_service.userdto.RegisterDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerUser(RegisterDTO registerDTO) {
        if(userRepo.findByEmail(registerDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email already present");
        }

        User user = User.builder()
                .name(registerDTO.getName())
                .email(registerDTO.getEmail())
                .password(registerDTO.getPassword())
                .mobileNumber(registerDTO.getMobileNumber())
                .walletBalance(0.0)
                .build();
        return userRepo.save(user);
    }

    public User loginUser(LoginDTO loginDTO) {
        User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if(!user.getPassword().equals(loginDTO.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return user;
    }

    public User getUser(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public @Nullable String updateWallet(Long userId, Double amount) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getWalletBalance()+amount<0){
            return "Insufficient Balance";
        }
        user.setWalletBalance(user.getWalletBalance()+amount);
        userRepo.save(user);

        return "SUCCESS";
    }
}
