package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.infrastructure.mapper.CategoryEntityMapper;
import br.com.jpcchaves.infrastructure.mapper.config.TodoRequestDTOConfigMapper;
import br.com.jpcchaves.infrastructure.mapper.config.TodoResponseDTOConfigMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "application.config.libraries.mapper", havingValue = "modelmapper")
public class MapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.addMappings(new TodoRequestDTOConfigMapper());
    modelMapper.addMappings(new TodoResponseDTOConfigMapper());
    modelMapper.addMappings(new CategoryEntityMapper());

    return modelMapper;
  }
}
