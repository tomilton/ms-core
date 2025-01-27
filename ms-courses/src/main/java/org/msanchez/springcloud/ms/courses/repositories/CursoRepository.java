package org.msanchez.springcloud.ms.courses.repositories;

import org.msanchez.springcloud.ms.courses.models.entity.Curso;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {

  @Modifying
  @Query("delete from CursoUsuario cu where cu.usuarioId=?1")
  void eliminarCursoUsuarioPorId(Long id);
}
