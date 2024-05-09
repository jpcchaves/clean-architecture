package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.category.gateway.ListCategoriesGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.mapper.CategoryMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ListCategoriesGatewayImpl implements ListCategoriesGateway {
  @Qualifier("${deploy.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  private final CategoryMapper categoryMapper;

  public ListCategoriesGatewayImpl(
      ICategoryRepository<CategoryEntity, Long> repository, CategoryMapper categoryMapper) {
    this.repository = repository;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public List<Category> list() {
    List<CategoryEntity> categoryEntityList = repository.findAll();

    return categoryMapper.toCoreCategoryList(categoryEntityList);
  }
}
