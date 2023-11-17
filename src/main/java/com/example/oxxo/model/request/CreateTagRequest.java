package com.example.oxxo.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTagRequest {
    

    @NotNull(message = "Nombre de tag vacío")
    @NotEmpty(message = "Nombre de tag vacío")
    @Schema(description = "Descripcion vacia",example="Descripcion..",required=true)
    private String name;
}
