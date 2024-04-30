package br.com.jpcchaves.infrastructure.controller.resources.base;

public interface ListResourcePaginated<PagReq, Res> {
  Res list(PagReq paginationRequest);
}
