package br.com.jpcchaves.infrastructure.controller.resources.base;

import java.util.List;

public interface ListResource<Res> {
  List<Res> list();
}
