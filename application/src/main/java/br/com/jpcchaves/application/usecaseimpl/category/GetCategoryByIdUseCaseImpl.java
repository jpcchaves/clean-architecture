package br.com.jpcchaves.application.usecaseimpl.category;

import br.com.jpcchaves.application.gateway.category.GetCategoryByIdGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.GetCategoryByIdUseCase;

public class GetCategoryByIdUseCaseImpl implements GetCategoryByIdUseCase {
  private final GetCategoryByIdGateway getCategoryByIdGateway;

  public GetCategoryByIdUseCaseImpl(GetCategoryByIdGateway getCategoryByIdGateway) {
    this.getCategoryByIdGateway = getCategoryByIdGateway;
  }

  @Override
  public Category getById(Long id) {
    return getCategoryByIdGateway.getById(id);
  }
}
