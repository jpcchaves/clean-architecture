package br.com.jpcchaves.core.domain;

public class PaginationRequest {
  private int page;
  private int size;
  private String sortBy;
  private String sortOrder;

  public PaginationRequest() {}

  public PaginationRequest(int page, int size, String sortBy, String sortOrder) {
    this.page = page;
    this.size = size;
    this.sortBy = sortBy;
    this.sortOrder = sortOrder;
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

  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }
}
