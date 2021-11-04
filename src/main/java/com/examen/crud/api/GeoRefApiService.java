package com.examen.crud.api;

import com.examen.crud.configuration.GeoRefProperties;
import com.examen.crud.entity.georef.ResponseGeoRef;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class GeoRefApiService {

    GeoRefProperties geoRefProperties;
    RestTemplate restTemplate;

    public ResponseGeoRef getGeoRefByProvinceName(String provinceName) {

        StringBuilder urlService = new StringBuilder();
        urlService.append(geoRefProperties.getUrlService())
                .append(geoRefProperties.getUrlProvincias())
                .append("?").append("nombre=").append(provinceName);

        ResponseGeoRef response = restTemplate
                .getForObject(
                        urlService.toString(),
                        ResponseGeoRef.class);

        return  response;
    }
}