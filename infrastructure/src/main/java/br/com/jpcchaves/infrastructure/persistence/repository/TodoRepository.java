package br.com.jpcchaves.infrastructure.persistence.repository;

import br.com.jpcchaves.core.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
