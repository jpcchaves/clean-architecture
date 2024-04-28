package br.com.jpcchaves.infrastructure.utils;

import br.com.jpcchaves.core.domain.PaginationRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {
  public static Pageable convertToPageable(PaginationRequest paginationRequest) {
    Sort sort = null;

    if (paginationRequest.getSort() != null && !paginationRequest.getSort().isEmpty()) {
      Sort.Direction direction = Sort.Direction.ASC;
      if (paginationRequest.getDirection() != null
          && paginationRequest.getDirection().equalsIgnoreCase("desc")) {
        direction = Sort.Direction.DESC;
      }
      sort = Sort.by(direction, paginationRequest.getSort());
    }

    if (sort != null) {
      return PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), sort);
    } else {
      return PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize());
    }
  }
}
