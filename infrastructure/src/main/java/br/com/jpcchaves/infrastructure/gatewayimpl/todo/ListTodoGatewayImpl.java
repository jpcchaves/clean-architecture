package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.gateway.todo.ListTodoGateway;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import br.com.jpcchaves.infrastructure.utils.PaginationUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListTodoGatewayImpl implements ListTodoGateway {
  @Qualifier("${deploy.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public ListTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> list() {
    return todoMapper.toTodoList(todoRepository.findAll());
  }

  @Override
  public PaginatedResponse<Todo> list(PaginationRequest paginationRequest) {
    Pageable pageable = PaginationUtils.convertToPageable(paginationRequest);
    Page<TodoEntity> todoEntityPage = todoRepository.findAll(pageable);
    return new PaginatedResponse<>(
        todoMapper.toTodoList(todoEntityPage.getContent()),
        todoEntityPage.getNumber(),
        todoEntityPage.getSize(),
        todoEntityPage.getTotalElements(),
        todoEntityPage.getTotalPages(),
        todoEntityPage.isLast());
  }
}
