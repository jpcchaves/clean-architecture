package br.com.jpcchaves.application.usecaseimpl.category;

import br.com.jpcchaves.application.gateway.category.ListCategoriesGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.usecase.category.ListCategoriesUseCase;
import java.util.List;

public class ListCategoriesUseCaseImpl implements ListCategoriesUseCase {
  private final ListCategoriesGateway listCategoriesGateway;

  public ListCategoriesUseCaseImpl(ListCategoriesGateway listCategoriesGateway) {
    this.listCategoriesGateway = listCategoriesGateway;
  }

  @Override
  public List<Category> list() {
    return listCategoriesGateway.list();
  }
}
