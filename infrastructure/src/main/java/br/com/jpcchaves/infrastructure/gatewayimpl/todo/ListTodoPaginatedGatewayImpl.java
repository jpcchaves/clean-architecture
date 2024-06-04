package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.ListTodoPaginatedGateway;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.contracts.ITodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import br.com.jpcchaves.infrastructure.utils.pagination.PaginationUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListTodoPaginatedGatewayImpl implements ListTodoPaginatedGateway {

  @Qualifier("${application.config.libraries.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final ITodoMapper todoMapper;

  public ListTodoPaginatedGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository,
      ITodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  public PaginatedResponse<Todo> list(PaginationRequest paginationRequest) {

    Pageable pageable = PaginationUtils.convertToPageable(paginationRequest);

    Page<TodoEntity> todoEntityPage = todoRepository.findAll(pageable);

    return new PaginatedResponse.Builder<Todo>()
        .setContent(todoMapper.toTodoList(todoEntityPage.getContent()))
        .setPage(todoEntityPage.getNumber())
        .setSize(todoEntityPage.getSize())
        .setTotalElements(todoEntityPage.getTotalElements())
        .setTotalPages(todoEntityPage.getTotalPages())
        .isLast(todoEntityPage.isLast())
        .build();
  }
}
