package br.com.jpcchaves.application.category.usecase;

import br.com.jpcchaves.application.category.gateway.UpdateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.UpdateCategoryUseCase;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {
  private final UpdateCategoryGateway updateCategoryGateway;

  public UpdateCategoryUseCaseImpl(UpdateCategoryGateway updateCategoryGateway) {
    this.updateCategoryGateway = updateCategoryGateway;
  }

  @Override
  public Category update(Long id, Category category) {
    return updateCategoryGateway.update(id, category);
  }
}
