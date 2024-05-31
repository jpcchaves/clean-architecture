package br.com.jpcchaves.infrastructure.mapper.impl;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.category.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.category.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.mapper.converters.CategoryConverter;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "deploy.mapper", havingValue = "mapstruct")
public class CategoryMapStructMapperImpl implements CategoryMapper {

  private final CategoryConverter categoryConverter;

  public CategoryMapStructMapperImpl(CategoryConverter categoryConverter) {
    this.categoryConverter = categoryConverter;
  }

  @Override
  public Category toCoreCategory(CategoryEntity createdCategory) {
    return categoryConverter.toCoreCategory(createdCategory);
  }

  @Override
  public Category toCoreCategory(CategoryRequestDTO categoryRequestDTO) {
    return categoryConverter.toCoreCategory(categoryRequestDTO);
  }

  @Override
  public CategoryEntity toCategoryEntity(Category category) {
    return categoryConverter.toCategoryEntity(category);
  }

  @Override
  public CategoryResponseDTO toDto(Category category) {
    return categoryConverter.toDto(category);
  }

  @Override
  public List<Category> toCoreCategoryList(List<CategoryEntity> categoryEntityList) {
    return null;
  }

  @Override
  public List<CategoryResponseDTO> toCategoryResDTOList(List<Category> categoryList) {
    return null;
  }
}
