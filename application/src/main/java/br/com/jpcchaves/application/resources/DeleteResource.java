package br.com.jpcchaves.application.resources;

public interface DeleteResource<PK, Res> {
  Res deleteById(PK id);
}
