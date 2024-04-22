package br.com.jpcchaves.application.gateway.category;

import br.com.jpcchaves.core.domain.Category;

public interface GetCategoryByIdGateway {
  Category getById(Long id);
}
