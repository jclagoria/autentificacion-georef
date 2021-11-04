package com.examen.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class LoginUsuarioDto {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

}
