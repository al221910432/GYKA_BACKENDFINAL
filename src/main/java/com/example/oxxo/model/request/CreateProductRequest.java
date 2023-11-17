package com.example.oxxo.model.request;

import java.util.Set;

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
public class CreateProductRequest {
    
    @NotNull(message = "El nombre del producto está vacío")
    @NotEmpty(message="El nombre del producto está vacío")
    @Schema(description = "Nombre del producto",example="Product1",required=true)
    @Size(min=5,max=50,message="Nombre del producto de 3 a 50 caracteres")
    private String name;

    @NotNull(message = "La descripción está vacía")
    @NotEmpty(message="La descripción está vacía")
    @Schema(description = "Descripción del Producto",example="Este producto..")
    @Size(min=5,max=1000,message="Descripción del producto de 5 a 1000 caracteres")
    private String description;

    @NotNull(message = "Precio vacío")
    @NotEmpty(message = "Precio vacío")
    @Schema(description = "Precio del producto",example = "12")
    @Size(min=0,message="El precio del producto debe ser mayor que 0")
    private long price;

    @NotNull(message = "El numero de productos esta vacio")
    @NotEmpty(message="El numero de productos esta vacio")
    @Schema(description = "El numero de productos",example="12")
    @Size(min=0,message="Número de productos de 0")
    private int quantity;

    @NotNull(message = "Categoria vacía")
    @NotEmpty(message = "Categoria vacía")
    @Schema(description = "Categoria id",example="1")
    private long categoryId;

    //@NotNull(message="La foto del producto está vacía.")
    @Schema(description="Se necesita una matriz",example="[1,2,3]")
    private Set<Long> imageIds;
}
