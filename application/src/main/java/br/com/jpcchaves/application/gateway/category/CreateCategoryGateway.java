package br.com.jpcchaves.application.gateway.category;

import br.com.jpcchaves.core.domain.Category;

public interface CreateCategoryGateway {
  Category create(Category category);
}
