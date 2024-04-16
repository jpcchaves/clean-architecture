package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.DeleteTodoGateway;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteTodoGatewayImpl implements DeleteTodoGateway {
    private final TodoRepository todoRepository;

    public DeleteTodoGatewayImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void delete(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoException(ErrorCode.TD0001.getMessage(), ErrorCode.TD0001.getCode());
        }
        

        todoRepository.deleteById(id);
    }
}
