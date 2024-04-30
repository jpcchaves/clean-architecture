package br.com.jpcchaves.application.category;

import br.com.jpcchaves.core.domain.Category;

public interface CreateCategoryGateway {
  Category create(Category category);
}
