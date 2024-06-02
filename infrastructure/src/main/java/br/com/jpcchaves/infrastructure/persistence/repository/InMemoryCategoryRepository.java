package br.com.jpcchaves.infrastructure.persistence.repository;

import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value = "application.config.libraries.repo", havingValue = "in-memo")
public class InMemoryCategoryRepository implements ICategoryRepository<CategoryEntity, Long> {
  private Map<Long, CategoryEntity> data = new HashMap<>();

  @Override
  public CategoryEntity save(CategoryEntity entity) {
    data.put(1L, entity);
    return entity;
  }

  @Override
  public Optional<CategoryEntity> findById(Long id) {
    return Optional.ofNullable(data.get(id));
  }

  @Override
  public List<CategoryEntity> findAll() {
    return new ArrayList<>(data.values());
  }

  @Override
  public Page<CategoryEntity> findAll(Pageable pageable) {
    return Page.empty();
  }

  @Override
  public void deleteById(Long id) {
    data.remove(id);
  }

  @Override
  public boolean existsById(Long id) {
    return !Objects.isNull(data.get(id));
  }
}
