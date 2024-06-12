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

    Sort.Direction sortDirection = Sort.Direction.ASC;

    if (sortParts.length > 1) {
      String directionPart = sortParts[1];

      sortDirection = Sort.Direction.fromString(directionPart);

      sortProperty = sortParts[0];

    } else if (paginationRequest.getDirection() != null &&
        paginationRequest.getDirection().equalsIgnoreCase(DESCENDING)) {

      sortDirection = Sort.Direction.DESC;
    }

    sort = Sort.by(sortDirection, sortProperty);

    return PageRequest.of(paginationRequest.getPage(),
        paginationRequest.getSize(), sort);
  }
}
