package br.com.jpcchaves.core.domain;

import java.util.List;

public interface Page<T> {
    List<T> getContent();
    int getPageNumber();
    int getPageSize();
    long getTotalElements();
    int getTotalPages();
    boolean hasNext();
    boolean hasPrevious();
    boolean isLast();
}
