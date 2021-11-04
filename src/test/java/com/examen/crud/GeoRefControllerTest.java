package com.examen.crud;

import com.examen.crud.dto.ProvinceGeoRefDto;
import com.examen.crud.service.ProvinceGGeoRefServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

public class GeoRefControllerTest extends SpringBootTests {

    @Mock
    private ProvinceGGeoRefServiceImpl service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetGeoRefByProvince_ok() throws Exception {

        ProvinceGeoRefDto datosDto = new ProvinceGeoRefDto(
                "Salta",
                Double.valueOf("-2.0002998"), Double.valueOf("-1.99992"), "");

        when(service.getGeoRefByProvince(Mockito.anyString())).thenReturn(datosDto);

        ProvinceGeoRefDto datos = service.getGeoRefByProvince("Salta");
        verify(service).getGeoRefByProvince("Salta");

        assertThat(datos, samePropertyValuesAs(datosDto));
    }


}
