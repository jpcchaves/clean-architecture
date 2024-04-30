package br.com.jpcchaves.application.resources;

public interface UpdateResource<PK, Req, Res> {
  Res update(PK id, Req req);
}
