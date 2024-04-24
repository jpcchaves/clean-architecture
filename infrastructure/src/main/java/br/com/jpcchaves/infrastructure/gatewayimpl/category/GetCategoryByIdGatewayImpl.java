package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.gateway.category.GetCategoryByIdGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.core.exception.CategoryException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GetCategoryByIdGatewayImpl implements GetCategoryByIdGateway {

  @Qualifier("${deploy.repo}")
  private final IRepository<CategoryEntity, Long> repository;

  private final CategoryMapper categoryMapper;

  public GetCategoryByIdGatewayImpl(
      IRepository<CategoryEntity, Long> repository, CategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public Category getById(Long id) {
    CategoryEntity categoryEntity =
        repository
            .findById(id)
            .orElseThrow(() -> new CategoryException(ExceptionDefinition.CT0002));

    return categoryMapper.toCoreCategory(categoryEntity);
  }
}
