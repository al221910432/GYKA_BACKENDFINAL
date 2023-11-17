package com.example.oxxo.model.request;

import java.util.Set;

import javax.validation.constraints.Email;
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
public class CreateUserRequest {


    @NotNull(message="El nombre de usuario está vacío")
    @NotEmpty(message="El nombre de usuario está vacío")
    @Size(min=5,max=30,message="Nombre de usuario de 5 a 30 caracteres")
    @Schema(description="Username",example="admin",required=true)
    private String username;

    @NotNull(message="El correo electrónico está vacío")
    @NotEmpty(message="El correo electrónico está vacío")
    @Size(min =5,max=30, message="Correo electrónico de 5 a 30 caracteres")
    @Email(message="Debe ser un email")
    @Schema(description = "Email",example="al222011269@gmail.com",required=true)
    private String email;

    @NotNull(message="La contraseña está vacía")
    @NotEmpty(message="La contraseña está vacía")
    @Size(min=6,max=30,message="Contraseñas de 6 a 30 caracteres")
    @Schema(description="Contraseña",example="123456")
    private String password;

    private Set<String> role;
}
