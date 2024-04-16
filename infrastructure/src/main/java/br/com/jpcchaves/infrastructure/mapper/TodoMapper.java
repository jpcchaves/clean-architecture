package br.com.jpcchaves.infrastructure.mapper;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.utils.MapperUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoMapper {
    private final MapperUtils mapperUtils;

    public TodoMapper(MapperUtils mapperUtils) {
        this.mapperUtils = mapperUtils;
    }

    public Todo toTodo(TodoEntity todoEntity) {
        return mapperUtils.parseObject(todoEntity, Todo.class);
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
}
