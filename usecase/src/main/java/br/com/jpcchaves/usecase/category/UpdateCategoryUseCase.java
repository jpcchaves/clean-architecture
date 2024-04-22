package br.com.jpcchaves.usecase.category;

import br.com.jpcchaves.core.domain.Category;

public interface UpdateCategoryUseCase {
  Category update(Long id, Category category);
}
