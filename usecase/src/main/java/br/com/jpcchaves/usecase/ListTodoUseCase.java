package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.Todo;
import java.util.List;

public interface ListTodoUseCase {
  List<Todo> list();
}
