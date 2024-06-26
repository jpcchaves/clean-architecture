package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.category.gateway.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.mapper.contracts.ICategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {

  @Qualifier("${application.config.libraries.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  private final ICategoryMapper categoryMapper;

  public CreateCategoryGatewayImpl(
      ICategoryRepository<CategoryEntity, Long> repository, ICategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public Category create(Category category) {
    CategoryEntity entity = categoryMapper.toCategoryEntity(category);
    CategoryEntity createdCategory = repository.save(entity);

    return categoryMapper.toCoreCategory(createdCategory);
  }
}
