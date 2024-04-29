package br.com.jpcchaves.core.domain;

import br.com.jpcchaves.core.domain.enums.PaginationDirection;

public class PaginationRequest {
  private int page = 0;
  private int size = 10;
  private String sort = "";
  private String direction = PaginationDirection.ASC.getDirection();

  public PaginationRequest() {}

  public PaginationRequest(int page, int size, String sort, String direction) {
    this.page = page;
    this.size = size;
    this.sort = sort;
    this.direction = direction;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    final String normalizedDirection = direction.toUpperCase();
    this.direction = PaginationDirection.fromDir(normalizedDirection);
  }
}
