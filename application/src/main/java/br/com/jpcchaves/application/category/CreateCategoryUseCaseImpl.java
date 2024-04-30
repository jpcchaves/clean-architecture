package br.com.jpcchaves.application.category;

import br.com.jpcchaves.application.category.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
  private final CreateCategoryGateway createCategoryGateway;

  public CreateCategoryUseCaseImpl(CreateCategoryGateway createCategoryGateway) {
    this.createCategoryGateway = createCategoryGateway;
  }

  @Override
  public Category create(Category category) {
    return createCategoryGateway.create(category);
  }
}
