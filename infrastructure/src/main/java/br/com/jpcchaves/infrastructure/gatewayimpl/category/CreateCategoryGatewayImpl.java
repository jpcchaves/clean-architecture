package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.gateway.category.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {
  private final IRepository<CategoryEntity, Long> repository;
  private final CategoryMapper categoryMapper;

  public CreateCategoryGatewayImpl(
      IRepository<CategoryEntity, Long> repository, CategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public Category create(Category category) {
    CategoryEntity createdCategory = repository.save(categoryMapper.toCategoryEntity(category));

    return categoryMapper.toCoreCategory(createdCategory);
  }
}
