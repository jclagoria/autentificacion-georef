package com.examen.crud.service;

/**
 * Interface en la cual se vana definir las funciones/metodos, parametros y tipo de datos que retorna
 * al momento de querer recuperar datos de un servicio externo
 */
public interface IProvinceGeoRef<T> {

    /**
     * Firma metodo por el cual se realizara la consulta de los datos geograficos de una
     * provincia, partiendo de su nombre.
     *
     *
     *
     * @param searchPatameter
     * @return T
     */
    public T getGeoRefByProvince(String searchPatameter);

}
