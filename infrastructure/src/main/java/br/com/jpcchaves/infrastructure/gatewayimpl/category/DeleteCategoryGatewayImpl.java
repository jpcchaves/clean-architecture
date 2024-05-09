package br.com.jpcchaves.infrastructure.gatewayimpl.category;

import br.com.jpcchaves.application.category.gateway.DeleteCategoryGateway;
import br.com.jpcchaves.core.exception.CategoryException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.persistence.entity.CategoryEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryGatewayImpl implements DeleteCategoryGateway {

  @Qualifier("${deploy.repo}")
  private final ICategoryRepository<CategoryEntity, Long> repository;

  public DeleteCategoryGatewayImpl(ICategoryRepository<CategoryEntity, Long> repository) {
    this.repository = repository;
  }

  @Override
  public void delete(Long id) {
    repository.findById(id).orElseThrow(() -> new CategoryException(ExceptionDefinition.CT0002));

    repository.deleteById(id);
  }
}
