package br.com.jpcchaves.infrastructure.mapper.converters;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.dto.category.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.category.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "deploy.mapper", havingValue = "mapstruct")
@Mapper(componentModel = ComponentModel.SPRING)
public interface CategoryConverter {

  @Mapping(target = "todoList", ignore = true)
  Category toCoreCategory(CategoryEntity createdCategory);

  @Mapping(target = "todoList", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", source = "name")
  Category toCoreCategory(CategoryRequestDTO categoryRequestDTO);

  CategoryEntity toCategoryEntity(Category category);

  CategoryResponseDTO toDto(Category category);

  List<Category> toCoreCategoryList(List<CategoryEntity> categoryEntityList);

  List<CategoryResponseDTO> toCategoryResDTOList(List<Category> categoryList);
}
