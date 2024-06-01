package br.com.jpcchaves.infrastructure.mapper.contracts;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.category.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.category.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface ICategoryMapper {

  Category toCoreCategory(CategoryEntity createdCategory);

  Category toCoreCategory(CategoryRequestDTO categoryRequestDTO);

  CategoryEntity toCategoryEntity(Category category);

  CategoryResponseDTO toDto(Category category);

  List<Category> toCoreCategoryList(List<CategoryEntity> categoryEntityList);

  List<CategoryResponseDTO> toCategoryResDTOList(List<Category> categoryList);
}
