package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.ListTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListTodoGatewayImpl implements ListTodoGateway {
    private final TodoRepository todoRepository;

    public ListTodoGatewayImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> list() {
        List<TodoEntity> todosEntities = todoRepository.findAll();

        return todosEntities
                .stream()
                .map(todo -> new Todo(
                        todo.getId(),
                        todo.getTodo(),
                        todo.getCreatedAt(),
                        todo.getUpdatedAt(),
                        todo.getCreatedBy(),
                        todo.getModifiedBy()
                ))
                .collect(Collectors.toList());
    }
}
