package br.com.jpcchaves.infrastructure.controller.resources.base;

public interface DeleteResource<PK, Res> {
  Res deleteById(PK id);
}
