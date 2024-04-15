package br.com.jpcchaves.core.domain;

import java.util.List;

public class PaginationResponse<T> implements Page<T> {
    private final List<T> content;
    private final Integer pageNumber;
    private final Integer pageSize;
    private final Long totalElements;

    public PaginationResponse(List<T> content,
                              Integer pageNumber,
                              Integer pageSize,
                              Long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }

    public PaginationResponse(builder<T> builder) {
        this.content = builder.content;
        this.pageNumber = builder.pageNumber;
        this.pageSize = builder.pageSize;
        this.totalElements = builder.totalElements;

    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public Integer getPageNumber() {
        return pageNumber;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public Long getTotalElements() {
        return totalElements;
    }

    @Override
    public Integer getTotalPages() {
        return (int) Math.ceil((double) totalElements / pageSize);
    }

    @Override
    public Boolean hasNext() {
        return pageNumber < getTotalPages() - 1;
    }

    @Override
    public Boolean hasPrevious() {
        return pageNumber > 0;
    }

    @Override
    public Boolean isLast() {
        return !hasNext();
    }

    public static class builder<T> {
        private List<T> content;
        private Integer pageNumber;
        private Integer pageSize;
        private Long totalElements;

        public builder(){

        }

        public builder(List<T> content,
                       Integer pageNumber,
                       Integer pageSize,
                       Long totalElements) {
            this.content = content;
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.totalElements = totalElements;
        }

        public builder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public builder<T> pageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public builder<T> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public builder<T> totalElements(Long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PaginationResponse<T> build() {
            return new PaginationResponse<>(this);
        }
    }
}
