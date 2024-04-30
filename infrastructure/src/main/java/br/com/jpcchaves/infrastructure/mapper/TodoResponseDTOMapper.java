package br.com.jpcchaves.infrastructure.mapper;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import org.modelmapper.PropertyMap;

public class TodoResponseDTOMapper extends PropertyMap<Todo, TodoResponseDTO> {
  @Override
  protected void configure() {
    map().setCategory(source.getCategory().getName());
  }
}
