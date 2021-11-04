package com.examen.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceGeoRefDto {

    private String province;
    private Double lon;
    private Double lat;
    private String message;

}
