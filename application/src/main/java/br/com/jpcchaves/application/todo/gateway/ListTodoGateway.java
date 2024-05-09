package br.com.jpcchaves.application.todo.gateway;

import br.com.jpcchaves.core.domain.Todo;
import java.util.List;

public interface ListTodoGateway {
  List<Todo> list();
}
