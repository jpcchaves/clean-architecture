package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.DeleteTodoGateway;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteTodoGatewayImpl implements DeleteTodoGateway {

  private final ITodoRepository<TodoEntity, Long> todoRepository;

  public DeleteTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  @Transactional
  public void delete(Long id) {
    if (!todoRepository.existsById(id)) {
      throw new TodoException(ExceptionDefinition.TD0001);
    }

    todoRepository.deleteById(id);
  }
}
