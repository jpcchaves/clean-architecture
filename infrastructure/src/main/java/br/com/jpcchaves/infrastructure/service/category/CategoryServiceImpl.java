package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import br.com.jpcchaves.usecase.category.GetCategoryByIdUseCase;
import br.com.jpcchaves.usecase.category.ListCategoriesUseCase;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CreateCategoryUseCase createCategoryUseCase;
  private final ListCategoriesUseCase listCategoriesUseCase;
  private final GetCategoryByIdUseCase getCategoryByIdUseCase;
  private final CategoryMapper categoryMapper;

  public CategoryServiceImpl(
      CreateCategoryUseCase createCategoryUseCase,
      ListCategoriesUseCase listCategoriesUseCase,
      GetCategoryByIdUseCase getCategoryByIdUseCase,
      CategoryMapper categoryMapper) {
    this.createCategoryUseCase = createCategoryUseCase;
    this.listCategoriesUseCase = listCategoriesUseCase;
    this.getCategoryByIdUseCase = getCategoryByIdUseCase;
    this.categoryMapper = categoryMapper;
  }

  @Override
  @Transactional
  public CategoryResponseDTO create(CategoryRequestDTO category) {
    Category createdCategory =
        createCategoryUseCase.create(categoryMapper.toCoreCategory(category));

    return categoryMapper.toDto(createdCategory);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CategoryResponseDTO> list() {
    List<Category> categoryList = listCategoriesUseCase.list();
    return categoryMapper.toCategoryResDTOList(categoryList);
  }

  @Override
  public CategoryResponseDTO getById(Long id) {
    Category category = getCategoryByIdUseCase.getById(id);
    return categoryMapper.toDto(category);
  }
}
