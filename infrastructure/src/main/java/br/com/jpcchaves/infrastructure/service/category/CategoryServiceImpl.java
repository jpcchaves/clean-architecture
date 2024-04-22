package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CreateCategoryUseCase createCategoryUseCase;
  private final CategoryMapper categoryMapper;

  public CategoryServiceImpl(
      CreateCategoryUseCase createCategoryUseCase, CategoryMapper categoryMapper) {
    this.createCategoryUseCase = createCategoryUseCase;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public CategoryResponseDTO create(CategoryRequestDTO category) {
    Category createdCategory =
        createCategoryUseCase.create(categoryMapper.toCoreCategory(category));

    return categoryMapper.toDto(createdCategory);
  }
}
