package br.com.jpcchaves.application.usecaseimpl.category;

import br.com.jpcchaves.application.gateway.category.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;

public class CreateGategoryUseCaseImpl implements CreateCategoryUseCase {
  private final CreateCategoryGateway createGategoryGateway;

  public CreateGategoryUseCaseImpl(CreateCategoryGateway createGategoryGateway) {
    this.createGategoryGateway = createGategoryGateway;
  }

  @Override
  public Category create(Category category) {
    return createGategoryGateway.create(category);
  }
}
