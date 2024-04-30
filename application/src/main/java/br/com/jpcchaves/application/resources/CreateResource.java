package br.com.jpcchaves.application.resources;

public interface CreateResource<Req, Res> {
  Res create(Req req);
}
