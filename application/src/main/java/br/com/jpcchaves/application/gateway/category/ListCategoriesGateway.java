package br.com.jpcchaves.application.gateway.category;

import br.com.jpcchaves.core.domain.Category;
import java.util.List;

public interface ListCategoriesGateway {
  List<Category> list();
}
