package net.azurewebsites.mypet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Bean created for ModelMapper
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();}

}
