package com.example.oxxo.service;

import com.example.oxxo.entity.User;
import com.example.oxxo.model.request.ChangePasswordRequest;
import com.example.oxxo.model.request.CreateUserRequest;
import com.example.oxxo.model.request.UpdateOrderRequest;
import com.example.oxxo.model.request.UpdateProfileRequest;

public interface UserService {
    
    void register(CreateUserRequest request);


    User getUserByUsername(String username);


    void updateUser(Long userId, UpdateProfileRequest request);

    void changePassword(ChangePasswordRequest request);

}
