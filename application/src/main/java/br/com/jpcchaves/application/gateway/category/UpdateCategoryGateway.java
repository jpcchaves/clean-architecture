package br.com.jpcchaves.application.gateway.category;

import br.com.jpcchaves.core.domain.Category;

public interface UpdateCategoryGateway {
  Category update(Long id, Category category);
}
