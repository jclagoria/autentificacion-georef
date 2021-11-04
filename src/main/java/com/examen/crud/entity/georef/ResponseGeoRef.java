package com.examen.crud.entity.georef;

import java.util.List;

public class ResponseGeoRef {

    private Integer cantidad;
    private Integer inicio;
    private ParameterGeoRef parametros;

    public List<ProvinceGeoRef> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<ProvinceGeoRef> provincias) {
        this.provincias = provincias;
    }

    private List<ProvinceGeoRef> provincias;
    private Integer total;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public ParameterGeoRef getParametros() {
        return parametros;
    }

    public void setParametros(ParameterGeoRef parametros) {
        this.parametros = parametros;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
