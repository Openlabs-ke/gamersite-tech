package org.xgamerstechnologies.com.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class SpringConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
