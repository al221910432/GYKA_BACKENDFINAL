package com.example.oxxo.model.request;

import lombok.Data;

@Data
public class UpdateOrderRequest {
    private long id;
    private String firstname;

    private String lastname;

    private String country;

    private String address;

    private String town;

    private String state;

    private Long postCode;

    private String email;

    private String phone;



    private String note;

    private long totalPrice;

    private String status;
    private String diaentrega;
    private String diapedido;
    private String diapago;
    private String diaenvio;
    private String seguimiento;
}

