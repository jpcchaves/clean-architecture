package br.com.jpcchaves.infrastructure.mapper;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import org.modelmapper.PropertyMap;

public class TodoDTOMapper extends PropertyMap<TodoRequestDTO, Todo> {
  protected void configure() {
    skip().setId(null);
  }
}
