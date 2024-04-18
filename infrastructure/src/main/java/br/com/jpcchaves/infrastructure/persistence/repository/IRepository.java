package br.com.jpcchaves.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRepository<E, PK> {
  E save(E entity);

  Optional<E> findById(PK id);

  List<E> findAll();

  Page<E> findAll(Pageable pageable);

  void deleteById(PK id);
}
