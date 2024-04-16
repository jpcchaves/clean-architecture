package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.GetTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class GetTodoByIdGatewayImpl implements GetTodoGateway {
    private final TodoRepository todoRepository;

    public GetTodoByIdGatewayImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo getTodo(Long id) {
        TodoEntity todoEntity = todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoException(ErrorCode.TD0001.getMessage(), ErrorCode.TD0001.getCode()));

        return new Todo(todoEntity.getId(),
                todoEntity.getTodo(), todoEntity.getCreatedAt(),
                todoEntity.getUpdatedAt(), todoEntity.getCreatedBy(),
                todoEntity.getModifiedBy());
    }
}
