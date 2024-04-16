package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateTodoGatewayImpl implements UpdateTodoGateway {
    private final TodoRepository todoRepository;

    public UpdateTodoGatewayImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo update(Long id,
                       Todo todo) {
        TodoEntity todoEntity = todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoException(ErrorCode.TD0001.getMessage(), ErrorCode.TD0001.getCode()));

        todoEntity.setTodo(todo.getTodo());

        TodoEntity updatedTodo = todoRepository.save(todoEntity);

        return new Todo(
                updatedTodo.getId(),
                updatedTodo.getTodo(),
                updatedTodo.getCreatedAt(),
                updatedTodo.getUpdatedAt(),
                updatedTodo.getCreatedBy(),
                updatedTodo.getModifiedBy()
        );
    }
}
