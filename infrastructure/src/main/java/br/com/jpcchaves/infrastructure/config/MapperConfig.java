package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.infrastructure.mapper.TodoRequestDTOMapper;
import br.com.jpcchaves.infrastructure.mapper.TodoResponseDTOMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.addMappings(new TodoRequestDTOMapper());
    modelMapper.addMappings(new TodoResponseDTOMapper());

    return modelMapper;
  }
}
