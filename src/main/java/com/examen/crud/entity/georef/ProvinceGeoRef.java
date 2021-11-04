package com.examen.crud.entity.georef;

public class ProvinceGeoRef {

    private Long id;
    private String nombre;
    private CentroideGeoRef centroide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CentroideGeoRef getCentroide() {
        return centroide;
    }

    public void setCentroide(CentroideGeoRef centroide) {
        this.centroide = centroide;
    }
}
