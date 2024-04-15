package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.application.usecaseimpl.CreateTodoUseCaseImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.CreateTodoGatewayImpl;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoGatewayConfig {
    @Bean
    private CreateTodoUseCase createTodo(CreateTodoGatewayImpl createTodoGatewayImpl) {
        return new CreateTodoUseCaseImpl(createTodoGatewayImpl);
    }
}
