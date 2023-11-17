package com.example.oxxo.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {

    @NotNull(message="El nombre del producto está vacío")
    @NotEmpty(message = "El nombre del producto está vacío")
    @Size(min=5,max=50,message="Nombre del producto de 5 a 50 caracteres")
    private String name;

    @NotNull(message="El precio del producto está vacío.")
    @NotEmpty(message="El precio del producto está vacío.")
    @Size(min=0,message ="Precio del producto desde 0 en adelante")
    private long price;

    @NotNull(message = "Número de productos vacíos")
    @NotEmpty(message = "Número de productos vacíos")
    @Size(min = 1,message="Cantidad de productos de 1 o más")
    private int quantity;

    private long subTotal;
}
