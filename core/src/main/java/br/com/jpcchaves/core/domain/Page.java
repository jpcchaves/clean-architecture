package br.com.jpcchaves.core.domain;

import java.util.List;

public interface Page<T> {
    List<T> getContent();
    Integer getPageNumber();
    Integer getPageSize();
    Long getTotalElements();
    Integer getTotalPages();
    Boolean hasNext();
    Boolean hasPrevious();
    Boolean isLast();
}
