package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.application.todo.CreateTodoUseCaseImpl;
import br.com.jpcchaves.application.todo.DeleteTodoUseCaseImpl;
import br.com.jpcchaves.application.todo.GetTodoByIdUseCaseImpl;
import br.com.jpcchaves.application.todo.ListTodoPaginatedUseCaseImpl;
import br.com.jpcchaves.application.todo.ListTodoUseCaseImpl;
import br.com.jpcchaves.application.todo.ListTodosByCategoryUseCaseImpl;
import br.com.jpcchaves.application.todo.UpdateTodoStatusUseCaseImpl;
import br.com.jpcchaves.application.todo.UpdateTodoUseCaseImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.todo.*;
import br.com.jpcchaves.usecase.todo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoGatewayConfig {
  @Bean
  public CreateTodoUseCase createTodo(CreateTodoGatewayImpl createTodoGatewayImpl) {
    return new CreateTodoUseCaseImpl(createTodoGatewayImpl);
  }

  @Bean
  public ListTodoUseCase listTodo(ListTodoGatewayImpl listTodoGatewayImpl) {
    return new ListTodoUseCaseImpl(listTodoGatewayImpl);
  }

  @Bean
  public GetTodoByIdUseCase getTodoById(GetTodoByIdGatewayImpl getTodoByIdGatewayImpl) {
    return new GetTodoByIdUseCaseImpl(getTodoByIdGatewayImpl);
  }

  @Bean
  public DeleteTodoUseCase delete(DeleteTodoGatewayImpl deleteTodoGatewayImpl) {
    return new DeleteTodoUseCaseImpl(deleteTodoGatewayImpl);
  }

  @Bean
  UpdateTodoUseCase update(UpdateTodoGatewayImpl updateTodoGatewayImpl) {
    return new UpdateTodoUseCaseImpl(updateTodoGatewayImpl);
  }

  @Bean
  UpdateTodoStatusUseCase updateStatus(UpdateTodoStatusGatewayImpl updateTodoStatusGatewayImpl) {
    return new UpdateTodoStatusUseCaseImpl(updateTodoStatusGatewayImpl);
  }

  @Bean
  ListTodosByCategoryUseCase listByCategory(
      ListTodosByCategoryGatewayImpl listTodosByCategoryGatewayImpl) {
    return new ListTodosByCategoryUseCaseImpl(listTodosByCategoryGatewayImpl);
  }

  @Bean
  ListTodoPaginatedUseCase listTodoPaginatedUseCase(
      ListTodoPaginatedGatewayImpl listTodoPaginatedGatewayImpl) {
    return new ListTodoPaginatedUseCaseImpl(listTodoPaginatedGatewayImpl);
  }
}
