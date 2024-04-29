package br.com.jpcchaves.usecase.todo;

import br.com.jpcchaves.core.domain.Todo;
import java.util.List;

public interface ListTodoUseCase {
  List<Todo> list();
}
