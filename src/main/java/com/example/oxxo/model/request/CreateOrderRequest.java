package com.example.oxxo.model.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    
    @NotNull(message="El apellido del cliente está vacío.")
    @NotEmpty(message="El apellido del cliente está vacío.")
    @Size(min=3,max=50,message="Apellido del cliente de 3 a 50 caracteres")
    private String firstname;
    
    @NotNull(message="El nombre del cliente está vacío")
    @NotEmpty(message="El nombre del cliente está vacío")
    @Size(min=3,max=50,message="Nombre del cliente de 3 a 50 caracteres")
    private String lastname;

    @NotNull(message="El nombre del país está vacío")
    @NotEmpty(message="El nombre del país está vacío")
    private String country;

    @NotNull(message="El nombre de la dirección está vacío.")
    @NotEmpty(message="El nombre de la dirección está vacío.")
    private String address;

    @NotNull(message="El nombre del país está vacío")
    @NotEmpty(message="TEl nombre del país está vacío")
    private String town;

    @NotNull(message="El nombre del área está vacío.")
    @NotEmpty(message="El nombre del área está vacío.")
    private String state;

    @NotNull(message ="Código postal vacío")
    @NotEmpty(message ="Código postal vacío")
    private long postCode;

    @NotNull(message = "El correo electrónico está vacío")
    @NotEmpty(message = "El correo electrónico está vacío")
    @Email(message = "Correo electrónico invalidado")
    private String email;
     
    @NotNull(message="El número de teléfono está vacío")
    @NotEmpty(message="SEl número de teléfono está vacío")
    private String phone;

    private String note;

    private long totalPrice;

    private String status;
    private String diaentrega;
    private String diapedido;
    private String diapago;
    private String diaenvio;
    private String seguimiento;
    
    private String username;

    private List<CreateOrderDetailRequest> orderDetails;

}
