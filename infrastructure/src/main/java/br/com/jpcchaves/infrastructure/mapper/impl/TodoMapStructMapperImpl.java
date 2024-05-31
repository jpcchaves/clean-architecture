package br.com.jpcchaves.infrastructure.mapper.impl;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.mapper.converters.TodoConverter;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "deploy.mapper", havingValue = "mapstruct")
public class TodoMapStructMapperImpl implements TodoMapper {

  private final TodoConverter todoConverter;

  public TodoMapStructMapperImpl(TodoConverter todoConverter) {
    this.todoConverter = todoConverter;
  }

  @Override
  public Todo toTodo(TodoEntity todoEntity) {
    return todoConverter.toTodo(todoEntity);
  }

  @Override
  public Todo toTodo(TodoRequestDTO todoDTO) {
    return todoConverter.toTodo(todoDTO);
  }

  @Override
  public TodoEntity toTodoEntity(Todo todo) {
    return todoConverter.toTodoEntity(todo);
  }

  @Override
  public List<Todo> toTodoList(List<TodoEntity> todoEntityList) {
    return todoConverter.toTodoList(todoEntityList);
  }

  @Override
  public List<TodoEntity> toTodoEntityList(List<Todo> todos) {
    return null;
  }

  @Override
  public TodoResponseDTO toResponseDTO(TodoEntity todoEntity) {
    return null;
  }

  @Override
  public TodoResponseDTO toResponseDTO(Todo todo) {
    return todoConverter.toResponseDTO(todo);
  }

  @Override
  public List<TodoResponseDTO> toResponseDTOList(List<Todo> todoList) {
    return todoConverter.toResponseDTO(todoList);
  }

  @Override
  public List<TodoResponseDTO> toResponseDTO(List<Todo> todosList) {
    return todoConverter.toResponseDTOList(todosList);
  }
}
