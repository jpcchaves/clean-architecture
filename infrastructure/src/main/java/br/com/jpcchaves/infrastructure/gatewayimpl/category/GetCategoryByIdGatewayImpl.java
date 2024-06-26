package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.category.gateway.GetCategoryByIdGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.core.exception.CategoryException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.mapper.contracts.ICategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GetCategoryByIdGatewayImpl implements GetCategoryByIdGateway {

  @Qualifier("${application.config.libraries.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  private final ICategoryMapper categoryMapper;

  public GetCategoryByIdGatewayImpl(
      ICategoryRepository<CategoryEntity, Long> repository, ICategoryMapper categoryMapper) {
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
