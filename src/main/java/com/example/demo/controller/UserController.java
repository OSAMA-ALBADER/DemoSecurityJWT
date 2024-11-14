package com.example.demo.controller;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UpdateUser;
import com.example.demo.service.UserService;
import com.nimbusds.oauth2.sdk.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hi, you are an authenticated user";
    }


    // Update Profile as a loged in user
@PostMapping("/update-profile")
    public ResponseEntity<UpdateUser> updateProfile(@RequestBody UpdateUser updateUserDetails){
        UpdateUser response = userService.updateUserService(updateUserDetails);
        if (response != null){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
}

}
