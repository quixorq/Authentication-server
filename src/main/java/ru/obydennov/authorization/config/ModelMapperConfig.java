package ru.obydennov.authorization.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Настройка мэппера для конвертации
 * Entity в DTO
 *
 * @author obydennov
 * @since 13.05.2022
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
