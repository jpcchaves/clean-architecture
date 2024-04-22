package br.com.jpcchaves.infrastructure.persistence.repository;

import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value = "deploy.repo", havingValue = "jpa")
public interface TodoJpaRepository
    extends IRepository<TodoEntity, Long>, JpaRepository<TodoEntity, Long> {}
