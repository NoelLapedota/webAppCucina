package com.xantrix.webapp.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //ignora se ci sono valori null
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.addConverter(articoliConverter);
        return modelMapper;
    }



    Converter<String, String> articoliConverter = new Converter<String, String>() {
        @Override
        public String convert(MappingContext<String, String> context) {
            return context.getSource() == null ? "" : context.getSource().trim();
        }
    };
}

