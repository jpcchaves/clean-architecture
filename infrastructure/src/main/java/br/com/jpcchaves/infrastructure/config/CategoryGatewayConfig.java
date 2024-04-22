package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.application.usecaseimpl.category.CreateGategoryUseCaseImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.CreateCategoryGatewayImpl;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryGatewayConfig {

  @Bean
  public CreateCategoryUseCase createCategoryUseCase(
      CreateCategoryGatewayImpl createCategoryGatewayImpl) {
    return new CreateGategoryUseCaseImpl(createCategoryGatewayImpl);
  }
}
