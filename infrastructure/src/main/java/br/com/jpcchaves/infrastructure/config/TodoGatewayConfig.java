package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.application.usecaseimpl.CreateTodoUseCaseImpl;
import br.com.jpcchaves.application.usecaseimpl.ListTodoUseCaseImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.CreateTodoGatewayImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.ListTodoGatewayImpl;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import br.com.jpcchaves.usecase.ListTodoUseCase;
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
}
