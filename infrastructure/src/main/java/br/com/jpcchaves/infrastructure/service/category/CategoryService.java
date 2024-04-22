package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;

public interface CategoryService {
  CategoryRequestDTO create(CategoryRequestDTO category);
}
