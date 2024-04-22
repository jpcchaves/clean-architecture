package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;

public interface CategoryService {
  CategoryResponseDTO create(CategoryRequestDTO category);
}
