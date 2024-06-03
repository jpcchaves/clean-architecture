package br.com.jpcchaves.infrastructure.mapper.config;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import org.modelmapper.PropertyMap;

public class TodoRequestDTOConfigMapper extends PropertyMap<TodoRequestDTO, Todo> {

  protected void configure() {
    skip().setId(null);
  }
}
