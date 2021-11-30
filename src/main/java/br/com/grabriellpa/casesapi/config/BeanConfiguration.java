package br.com.grabriellpa.casesapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
