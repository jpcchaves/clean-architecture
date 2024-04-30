package br.com.jpcchaves.infrastructure.controller.resources.base;

public interface GetByIdResource<PK, Res> {
  Res getById(PK id);
}
