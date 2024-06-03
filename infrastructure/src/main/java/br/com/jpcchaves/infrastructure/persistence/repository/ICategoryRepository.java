package br.com.jpcchaves.infrastructure.persistence.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "application.config.libraries.repo", havingValue = "in-memo")
public interface ICategoryRepository<E, PK> extends IRepository<E, PK> {}
