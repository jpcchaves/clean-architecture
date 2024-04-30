package br.com.jpcchaves.infrastructure.controller.resources.base;

public interface CreateResource<Req, Res> {
  Res create(Req req);
}
