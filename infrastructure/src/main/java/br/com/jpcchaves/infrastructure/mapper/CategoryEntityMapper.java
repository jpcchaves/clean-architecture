package br.com.jpcchaves.infrastructure.mapper;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import org.modelmapper.PropertyMap;

public class CategoryEntityMapper extends PropertyMap<CategoryEntity, Category> {
  @Override
  protected void configure() {
    skip().setTodoList(null);
  }
}
