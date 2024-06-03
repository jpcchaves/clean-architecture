package br.com.jpcchaves.infrastructure.utils;

import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.enums.PaginationDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {

  // TODO: 6/3/24 Create a custom annotation using Spring AOP to handle the pagination
  public static Pageable convertToPageable(PaginationRequest paginationRequest) {
    PaginationDirection.isValid(paginationRequest.getDirection());

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
