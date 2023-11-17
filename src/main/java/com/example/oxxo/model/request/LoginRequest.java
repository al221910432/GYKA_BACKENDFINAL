package com.example.oxxo.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    @NotNull(message="El nombre de usuario está vacío")
    @NotEmpty(message="El nombre de usuario está vacío")
    @Size(min=5,max=30,message="El nombre de usuario tiene entre 5 y 30 caracteres")
    @Schema(description = "Username",example="admin",required=true)
    private String username;

    @NotNull(message = "La contraseña está vacía")
    @NotEmpty(message = "La contraseña está vacía")
    @Size(min=6,max=30,message="Contraseña con 6-30 caracteres")
    @Schema(description = "Contraseña",example = "123456")
    private String password;
}
