package com.examen.crud.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;

@Configuration
@ConfigurationProperties(prefix = "api.georef")
@EnableConfigurationProperties
@ApiIgnore
public class GeoRefProperties {

    private String urlService;
    private String urlProvincias;

    public String getUrlService() {
        return urlService;
    }

    public void setUrlService(String urlService) {
        this.urlService = urlService;
    }

    public String getUrlProvincias() {
        return urlProvincias;
    }

    public void setUrlProvincias(String urlProvincias) {
        this.urlProvincias = urlProvincias;
    }
}
