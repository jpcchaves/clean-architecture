package br.com.jpcchaves.infrastructure.mapper;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.utils.MapperUtils;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
  private final MapperUtils mapperUtils;

  public TodoMapper(MapperUtils mapperUtils) {
    this.mapperUtils = mapperUtils;
  }

  public Todo toTodo(TodoEntity todoEntity) {
    return mapperUtils.parseObject(todoEntity, Todo.class);
  }

  public Todo toTodo(TodoRequestDTO todoDTO) {
    return mapperUtils.parseObject(todoDTO, Todo.class);
  }

  public TodoEntity toTodoEntity(Todo todo) {
    return mapperUtils.parseObject(todo, TodoEntity.class);
  }

  public List<Todo> toTodoList(List<TodoEntity> todoEntityList) {
    return mapperUtils.parseObjectsCollection(todoEntityList, Todo.class);
  }

  public List<TodoEntity> toTodoEntityList(List<Todo> todos) {
    return mapperUtils.parseObjectsCollection(todos, TodoEntity.class);
  }

  public TodoResponseDTO toResponseDTO(TodoEntity todoEntity) {
    return mapperUtils.parseObject(todoEntity, TodoResponseDTO.class);
  }

  public TodoResponseDTO toResponseDTO(Todo todo) {
    return mapperUtils.parseObject(todo, TodoResponseDTO.class);
  }

  public List<TodoResponseDTO> toResponseDTOList(List<Todo> todoList) {
    return mapperUtils.parseObjectsCollection(todoList, TodoResponseDTO.class);
  }

  public List<TodoResponseDTO> toResponseDTO(List<Todo> todosList) {
    return mapperUtils.parseObjectsCollection(todosList, TodoResponseDTO.class);
  }
}
