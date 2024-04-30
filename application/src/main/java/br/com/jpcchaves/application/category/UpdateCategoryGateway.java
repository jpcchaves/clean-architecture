package br.com.jpcchaves.application.category;

import br.com.jpcchaves.core.domain.Category;

public interface UpdateCategoryGateway {
  Category update(Long id, Category category);
}
