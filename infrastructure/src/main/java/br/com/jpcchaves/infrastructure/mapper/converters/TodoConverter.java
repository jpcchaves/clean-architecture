package br.com.jpcchaves.infrastructure.mapper.converters;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "application.config.libraries.mapper", havingValue = "mapstruct")
@Mapper(
    componentModel = "spring",
    uses = {CategoryConverter.class})
public interface TodoConverter {

  Todo toTodo(TodoEntity todoEntity);

  @Mapping(target = "category", ignore = true)
  @Mapping(target = "id", ignore = true)
  Todo toTodo(TodoRequestDTO todoDTO);

  TodoEntity toTodoEntity(Todo todo);

  List<Todo> toTodoList(List<TodoEntity> todoEntityList);

  List<TodoEntity> toTodoEntityList(List<Todo> todos);

  @Mapping(target = "category", source = "category", qualifiedByName = "categoryToString")
  TodoResponseDTO toResponseDTO(TodoEntity todoEntity);

  @Mapping(target = "category", source = "category", qualifiedByName = "categoryToString")
  TodoResponseDTO toResponseDTO(Todo todo);

  List<TodoResponseDTO> toResponseDTOList(List<Todo> todoList);

  List<TodoResponseDTO> toResponseDTO(List<Todo> todosList);

  @Named("categoryToString")
  @Mapping(target = "todoList", ignore = true)
  default String categoryToString(Category category) {
    return category.getName();
  }

  @Named("categoryToString")
  @Mapping(target = "todoList", ignore = true)
  default String categoryToString(CategoryEntity category) {
    return category.getName();
  }
}
