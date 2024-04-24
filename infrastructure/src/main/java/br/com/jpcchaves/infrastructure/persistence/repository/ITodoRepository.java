package br.com.jpcchaves.infrastructure.persistence.repository;

import java.util.List;

public interface ITodoRepository<E, PK> extends IRepository<E, PK> {
  List<E> findAllByCategory_Id(PK categoryId);
}
