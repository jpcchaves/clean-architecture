package br.com.jpcchaves.infrastructure.controller.resources.base;

public interface UpdateResource<PK, Req, Res> {
  Res update(PK id, Req req);
}
