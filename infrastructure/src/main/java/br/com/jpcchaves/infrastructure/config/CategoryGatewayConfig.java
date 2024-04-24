package br.com.jpcchaves.infrastructure.config;

import br.com.jpcchaves.application.usecaseimpl.category.CreateCategoryUseCaseImpl;
import br.com.jpcchaves.application.usecaseimpl.category.DeleteCategoryUseCaseImpl;
import br.com.jpcchaves.application.usecaseimpl.category.GetCategoryByIdUseCaseImpl;
import br.com.jpcchaves.application.usecaseimpl.category.ListCategoriesUseCaseImpl;
import br.com.jpcchaves.application.usecaseimpl.category.UpdateCategoryUseCaseImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.CreateCategoryGatewayImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.DeleteCategoryGatewayImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.GetCategoryByIdGatewayImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.ListCategoriesGatewayImpl;
import br.com.jpcchaves.infrastructure.gatewayimpl.category.UpdateCategoryGatewayImpl;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import br.com.jpcchaves.usecase.category.DeleteCategoryUseCase;
import br.com.jpcchaves.usecase.category.GetCategoryByIdUseCase;
import br.com.jpcchaves.usecase.category.ListCategoriesUseCase;
import br.com.jpcchaves.usecase.category.UpdateCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryGatewayConfig {

  @Bean
  public CreateCategoryUseCase createCategoryUseCase(
      CreateCategoryGatewayImpl createCategoryGatewayImpl) {
    return new CreateCategoryUseCaseImpl(createCategoryGatewayImpl);
  }

  @Bean
  public ListCategoriesUseCase listCategoriesUseCase(
      ListCategoriesGatewayImpl listCategoriesGatewayImpl) {
    return new ListCategoriesUseCaseImpl(listCategoriesGatewayImpl);
  }

  @Bean
  public GetCategoryByIdUseCase getCategoryByIdUseCase(
      GetCategoryByIdGatewayImpl getCategoryByIdGatewayImpl) {
    return new GetCategoryByIdUseCaseImpl(getCategoryByIdGatewayImpl);
  }

  @Bean
  public UpdateCategoryUseCase updateCategoryUseCase(
      UpdateCategoryGatewayImpl updateCategoryGatewayImpl) {
    return new UpdateCategoryUseCaseImpl(updateCategoryGatewayImpl);
  }

  @Bean
  public DeleteCategoryUseCase deleteCategoryUseCase(
      DeleteCategoryGatewayImpl deleteCategoryGatewayImpl) {
    return new DeleteCategoryUseCaseImpl(deleteCategoryGatewayImpl);
  }
}
