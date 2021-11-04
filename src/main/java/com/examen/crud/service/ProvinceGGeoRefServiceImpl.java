package com.examen.crud.service;

import com.examen.crud.entity.georef.ProvinceGeoRef;
import com.examen.crud.dto.ProvinceGeoRefDto;
import com.examen.crud.entity.georef.ResponseGeoRef;
import com.examen.crud.api.GeoRefApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProvinceGGeoRefServiceImpl implements IProvinceGeoRef<ProvinceGeoRefDto>{

    GeoRefApiService geoRefApiService;

    @Override
    public ProvinceGeoRefDto getGeoRefByProvince(String searchPatameter) {

        ResponseGeoRef responseApi = geoRefApiService.getGeoRefByProvinceName(searchPatameter);
        Optional<List<ProvinceGeoRef>> oProvinceGeoRef = Optional.ofNullable(responseApi.getProvincias());

        Optional<ProvinceGeoRefDto> provinceGeoRefDto = Optional.of(new ProvinceGeoRefDto());

        if(oProvinceGeoRef.isPresent()){
            provinceGeoRefDto = oProvinceGeoRef.get().stream().map(temp -> {
                ProvinceGeoRefDto obj = new ProvinceGeoRefDto();

                obj.setProvince(temp.getNombre());
                obj.setLon(temp.getCentroide().getLon());
                obj.setLat(temp.getCentroide().getLat());

                return obj;
            }).findFirst();
        } else {
            provinceGeoRefDto.get().setMessage("Nombre provincia no encontrado.");
        }

        return provinceGeoRefDto.get();
    }
}
