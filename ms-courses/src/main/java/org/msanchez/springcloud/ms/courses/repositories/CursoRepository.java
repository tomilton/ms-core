package org.msanchez.springcloud.ms.courses.repositories;

import org.msanchez.springcloud.ms.courses.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {}
