package br.com.jpcchaves.application.usecaseimpl.category;

import br.com.jpcchaves.application.gateway.category.DeleteCategoryGateway;
import br.com.jpcchaves.usecase.category.DeleteCategoryUseCase;

public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {
  private final DeleteCategoryGateway deleteCategoryGateway;

  public DeleteCategoryUseCaseImpl(DeleteCategoryGateway deleteCategoryGateway) {
    this.deleteCategoryGateway = deleteCategoryGateway;
  }

  @Override
  public void delete(Long id) {
    deleteCategoryGateway.delete(id);
  }
}
