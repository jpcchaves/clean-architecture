package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.gateway.category.CreateCategoryGateway;
import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayImpl implements CreateCategoryGateway {
  private final IRepository<Category, Long> repository;

  public CreateCategoryGatewayImpl(IRepository<Category, Long> repository) {
    this.repository = repository;
  }

  @Override
  public Category create(Category category) {
    return repository.save(category);
  }
}
