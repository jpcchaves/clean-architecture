package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.category.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {
  @Qualifier("${deploy.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  private final CategoryMapper categoryMapper;

  public CreateCategoryGatewayImpl(
      ICategoryRepository<CategoryEntity, Long> repository, CategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public Category create(Category category) {
    CategoryEntity createdCategory = repository.save(categoryMapper.toCategoryEntity(category));

    return categoryMapper.toCoreCategory(createdCategory);
  }
}
