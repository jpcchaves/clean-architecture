package br.com.jpcchaves.application.resources;

public interface GetByIdResource<PK, Res> {
  Res getById(PK id);
}
