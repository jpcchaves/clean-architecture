package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;
import java.util.List;

public interface CategoryService {
  CategoryResponseDTO create(CategoryRequestDTO category);

  List<CategoryResponseDTO> list();

  CategoryResponseDTO getById(Long id);
}
