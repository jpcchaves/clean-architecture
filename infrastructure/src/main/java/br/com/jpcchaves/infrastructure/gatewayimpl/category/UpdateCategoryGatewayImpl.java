package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.gateway.category.UpdateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.core.exception.CategoryException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryGatewayImpl implements UpdateCategoryGateway {
  @Qualifier("${deploy.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  private final CategoryMapper categoryMapper;

  public UpdateCategoryGatewayImpl(
      ICategoryRepository<CategoryEntity, Long> repository, CategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public Category update(Long id, Category category) {
    CategoryEntity categoryById =
        repository
            .findById(id)
            .orElseThrow(() -> new CategoryException(ExceptionDefinition.CT0002));

    categoryById.setName(category.getName());

    CategoryEntity updatedCategory = repository.save(categoryById);

    return categoryMapper.toCoreCategory(updatedCategory);
  }
}
