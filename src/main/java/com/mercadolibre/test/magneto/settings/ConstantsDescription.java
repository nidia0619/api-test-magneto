package com.mercadolibre.test.magneto.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api.constants")
@Data
public class ConstantsDescription {

    private String dnaLetters;
    private String isHuman;
    private String validate;
    private String errorExceptionService;

}
