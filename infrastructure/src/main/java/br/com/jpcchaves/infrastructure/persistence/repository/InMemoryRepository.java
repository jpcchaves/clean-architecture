package br.com.jpcchaves.infrastructure.persistence.repository;

import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
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
public class InMemoryRepository implements IRepository<TodoEntity, Long> {
  private Map<Long, TodoEntity> data = new HashMap<>();

  @Override
  public TodoEntity save(TodoEntity entity) {
    data.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public Optional<TodoEntity> findById(Long id) {
    return Optional.ofNullable(data.get(id));
  }

  @Override
  public List<TodoEntity> findAll() {
    return new ArrayList<>(data.values());
  }

  @Override
  public Page<TodoEntity> findAll(Pageable pageable) {
    return null;
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
