package br.com.jpcchaves.application.category;

import br.com.jpcchaves.core.domain.Category;

public interface GetCategoryByIdGateway {
  Category getById(Long id);
}
