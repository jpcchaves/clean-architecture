package br.com.jpcchaves.infrastructure.service.category;

import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.usecase.category.CreateCategoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final CreateCategoryUseCase createCategoryUseCase;

  public CategoryServiceImpl(CreateCategoryUseCase createCategoryUseCase) {
    this.createCategoryUseCase = createCategoryUseCase;
  }

  @Override
  public CategoryRequestDTO create(CategoryRequestDTO category) {
    return null;
  }
}
