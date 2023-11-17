package com.example.oxxo.model.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogRequest {
    
    @NotNull(message="Título vacío")
    @NotEmpty(message = "Título vacío")
    @Size(min=5,max=300,message="Longitud del título de 1 a 300 caracteres")
    private String title;


    @NotNull(message = "La descripción está vacía")
    @NotEmpty(message = "La descripción está vacía")
    @Size(min=5,max=300,message= "Longitud de la descripción de 1 a 300 caracteres")
    private String description;

    @NotNull(message="Contenido vacío")
    @NotEmpty(message="Contenido vacío")
    @Size(min=5,message="Longitud mínima del contenido a partir de 5 caracteres")
    private String content;

    @NotNull(message="la imagen esta vacia")
    @NotEmpty(message="la imagen esta vacia")
    private Long imageId;

    private String username;

    private Set<Long> tags = new HashSet<>();

}
