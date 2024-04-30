package br.com.jpcchaves.application.resources;

import java.util.List;

public interface ListResource<Res> {
  List<Res> list();
}
