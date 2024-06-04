package br.com.jpcchaves.infrastructure.utils.pagination;

import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.enums.PaginationDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils implements ConvertToPageable {

  private static final String DESCENDING = "desc";

  public static Pageable convertToPageable(
      PaginationRequest paginationRequest) {

    PaginationDirection.isValid(paginationRequest.getDirection());

    String sortProperty = paginationRequest.getSort();
    Sort sort;

    String[] sortParts = sortProperty.split(",");

    Sort.Direction direction = Sort.Direction.ASC;

    if (sortParts.length > 1) {

      direction = Sort.Direction.fromString(sortParts[1]);

      sortProperty = sortParts[0];

    } else if (paginationRequest.getDirection() != null &&
        paginationRequest.getDirection().equalsIgnoreCase(DESCENDING)) {

      direction = Sort.Direction.DESC;
    }

    sort = Sort.by(direction, sortProperty);

    return PageRequest.of(paginationRequest.getPage(),
        paginationRequest.getSize(), sort);
  }
}
