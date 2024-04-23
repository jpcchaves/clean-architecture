package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import br.com.jpcchaves.usecase.category.DeleteCategoryUseCase;
import br.com.jpcchaves.usecase.category.GetCategoryByIdUseCase;
import br.com.jpcchaves.usecase.category.ListCategoriesUseCase;
import br.com.jpcchaves.usecase.category.UpdateCategoryUseCase;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CreateCategoryUseCase createCategoryUseCase;
  private final ListCategoriesUseCase listCategoriesUseCase;
  private final GetCategoryByIdUseCase getCategoryByIdUseCase;
  private final UpdateCategoryUseCase updateCategoryUseCase;
  private final DeleteCategoryUseCase deleteCategoryUseCase;
  private final CategoryMapper categoryMapper;

  public CategoryServiceImpl(
      CreateCategoryUseCase createCategoryUseCase,
      ListCategoriesUseCase listCategoriesUseCase,
      GetCategoryByIdUseCase getCategoryByIdUseCase,
      UpdateCategoryUseCase updateCategoryUseCase,
      DeleteCategoryUseCase deleteCategoryUseCase,
      CategoryMapper categoryMapper) {
    this.createCategoryUseCase = createCategoryUseCase;
    this.listCategoriesUseCase = listCategoriesUseCase;
    this.getCategoryByIdUseCase = getCategoryByIdUseCase;
    this.updateCategoryUseCase = updateCategoryUseCase;
    this.deleteCategoryUseCase = deleteCategoryUseCase;
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

  @Override
  public CategoryResponseDTO update(Long id, CategoryRequestDTO requestDTO) {
    Category category = updateCategoryUseCase.update(id, categoryMapper.toCoreCategory(requestDTO));

    return categoryMapper.toDto(category);
  }

  @Override
  public void delete(Long id) {
    deleteCategoryUseCase.delete(id);
  }
}
