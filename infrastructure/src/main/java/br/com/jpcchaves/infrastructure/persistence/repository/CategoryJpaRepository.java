package br.com.jpcchaves.infrastructure.persistence.repository;

import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value = "deploy.repo", havingValue = "jpa")
public interface CategoryJpaRepository
    extends ICategoryRepository<CategoryEntity, Long>, JpaRepository<CategoryEntity, Long> {}
