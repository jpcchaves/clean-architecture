package br.com.jpcchaves.infrastructure.mapper.contracts;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface TodoMapper {

  Todo toTodo(TodoEntity todoEntity);

  Todo toTodo(TodoRequestDTO todoDTO);

  TodoEntity toTodoEntity(Todo todo);

  List<Todo> toTodoList(List<TodoEntity> todoEntityList);

  List<TodoEntity> toTodoEntityList(List<Todo> todos);

  TodoResponseDTO toResponseDTO(TodoEntity todoEntity);

  TodoResponseDTO toResponseDTO(Todo todo);

  List<TodoResponseDTO> toResponseDTOList(List<Todo> todoList);

  List<TodoResponseDTO> toResponseDTO(List<Todo> todosList);
}
