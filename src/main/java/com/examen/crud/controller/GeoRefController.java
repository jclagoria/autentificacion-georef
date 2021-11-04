package com.examen.crud.controller;

import com.examen.crud.dto.ProvinceGeoRefDto;
import com.examen.crud.service.ProvinceGGeoRefServiceImpl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/georef", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@CrossOrigin
public class GeoRefController {

    private static final Logger logger = LoggerFactory.getLogger(GeoRefController.class);

    ProvinceGGeoRefServiceImpl provinceGeoRef;

    @GetMapping("/trailer")
    public ResponseEntity<ProvinceGeoRefDto> getGeoRefByProvince(@RequestParam String provinceName) {

        logger.info("GeoRefController -> getGeoRefByProvince");

        ProvinceGeoRefDto provinceGeoRefDto = provinceGeoRef.getGeoRefByProvince(provinceName);

        return new ResponseEntity(provinceGeoRefDto, HttpStatus.OK);
    }

}
