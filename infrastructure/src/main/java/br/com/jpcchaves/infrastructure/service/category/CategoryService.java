package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.infrastructure.dto.category.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.category.CategoryResponseDTO;
import java.util.List;

public interface CategoryService {
  CategoryResponseDTO create(CategoryRequestDTO requestDTO);

  List<CategoryResponseDTO> list();

  CategoryResponseDTO getById(Long id);

  CategoryResponseDTO update(Long id, CategoryRequestDTO requestDTO);

  void delete(Long id);
}
