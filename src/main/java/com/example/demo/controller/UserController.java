package com.example.demo.controller;

import com.nimbusds.oauth2.sdk.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hi, you are an authenticated user";
    }

    // Update Profile
@PostMapping("/update-profile")
    public String updateProfile(){
    System.out.println("hello");
        return "updated completed";
}
//    public String updateUserProfile(@RequestBody String username, String email, String phoneNumber, String address, String password){
//        return "Updated seccssfully " + username + phoneNumber + email + address + password;
//
//}

}
