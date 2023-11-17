package com.example.oxxo.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
    
    @NotNull(message = "El nombre de la categoría está vacío.")
    @NotEmpty(message = "El nombre de la categoría está vacío.")
    @Size(min=2,max=50,message="Longitud de la categoría de 2 a 50 caracteres")
    private String name;


}

