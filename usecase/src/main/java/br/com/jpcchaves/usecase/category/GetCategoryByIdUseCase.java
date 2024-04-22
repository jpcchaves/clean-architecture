package br.com.jpcchaves.usecase.category;

import br.com.jpcchaves.core.domain.Category;

public interface GetCategoryByIdUseCase {
  Category getById(Long id);
}
