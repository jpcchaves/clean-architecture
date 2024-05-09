package br.com.jpcchaves.application.category.gateway;

import br.com.jpcchaves.core.domain.Category;
import java.util.List;

public interface ListCategoriesGateway {
  List<Category> list();
}
