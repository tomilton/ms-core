package org.msanchez.springcloud.ms.courses.services;

import org.msanchez.springcloud.ms.courses.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
  List<Curso> listar();

  Optional<Curso> porId(Long id);

  Curso guardar(Curso curso);

  void eliminar(Long id);
}
