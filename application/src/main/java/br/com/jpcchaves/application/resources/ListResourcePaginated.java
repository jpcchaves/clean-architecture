package br.com.jpcchaves.application.resources;

public interface ListResourcePaginated<PagReq, Res> {
  Res list(PagReq paginationRequest);
}
