package br.com.jpcchaves.infrastructure.utils.pagination;

import br.com.jpcchaves.core.domain.PaginationRequest;
import org.springframework.data.domain.Pageable;

public interface ConvertToPageable {

  static Pageable convertToPageable(PaginationRequest paginationRequest) {
    return Pageable.unpaged();
  }
}
