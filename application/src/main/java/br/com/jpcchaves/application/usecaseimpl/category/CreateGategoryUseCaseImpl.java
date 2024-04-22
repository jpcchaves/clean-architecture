package br.com.jpcchaves.application.usecaseimpl.category;

import br.com.jpcchaves.application.gateway.category.CreateGategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;

public class CreateGategoryUseCaseImpl implements CreateCategoryUseCase {
  private final CreateGategoryGateway createGategoryGateway;

  public CreateGategoryUseCaseImpl(CreateGategoryGateway createGategoryGateway) {
    this.createGategoryGateway = createGategoryGateway;
  }

  @Override
  public Category create(Category category) {
    return createGategoryGateway.create(category);
  }
}
