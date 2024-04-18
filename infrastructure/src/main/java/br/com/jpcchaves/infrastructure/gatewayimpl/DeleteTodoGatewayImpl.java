package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.DeleteTodoGateway;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteTodoGatewayImpl implements DeleteTodoGateway {
  @Qualifier("jpa-repository")
  private final IRepository<TodoEntity, Long> todoRepository;

  public DeleteTodoGatewayImpl(TodoJpaRepository todoJpaRepository) {
    this.todoRepository = todoJpaRepository;
  }

  @Override
  @Transactional
  public void delete(Long id) {
    if (!todoRepository.existsById(id)) {
      throw new TodoException(
          ErrorCode.TD0001.getMessage(),
          ErrorCode.TD0001.getCode(),
          ErrorCode.TD0001.getHttpStatus());
    }

    todoRepository.deleteById(id);
  }
}
