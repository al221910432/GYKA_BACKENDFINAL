package com.example.oxxo.controller;

import com.example.oxxo.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.oxxo.repository.UserRepository;
import com.example.oxxo.entity.User;
import com.example.oxxo.model.request.ChangePasswordRequest;
import com.example.oxxo.model.request.UpdateProfileRequest;
import com.example.oxxo.model.response.MessageResponse;
import com.example.oxxo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    @Operation(summary="Obtener usuario por nombre de usuario")
    public ResponseEntity<User> getuser(@RequestParam("username") String username){
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar un usuario por ID")
    public ResponseEntity<?> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UpdateProfileRequest request) {

        userService.updateUser(id, request);

        return ResponseEntity.ok(new MessageResponse("¡Usuario actualizado!"));
    }

     @PutMapping("/password")
     public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request){
         userService.changePassword(request);
         return ResponseEntity.ok(new MessageResponse("¡Contaseña Actualizada!"));
     }

    @GetMapping("/check-email-exists/{email}")
    public boolean checkEmailExists(@PathVariable String email) {
        return userRepository.existsByEmail(email);
    }

    @GetMapping("/check-username-exists/{username}")
    public boolean checkUsernameExists(@PathVariable String username) {
        return userRepository.existsByUsername(username);
    }

}
