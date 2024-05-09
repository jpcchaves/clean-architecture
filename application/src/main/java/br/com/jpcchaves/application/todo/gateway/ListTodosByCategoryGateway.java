package br.com.jpcchaves.application.todo.gateway;

import br.com.jpcchaves.core.domain.Todo;
import java.util.List;

public interface ListTodosByCategoryGateway {
  List<Todo> listByCategory(Long categoryId);
}
