package org.msanchez.springcloud.ms.courses.clients;

import org.msanchez.springcloud.ms.courses.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-user", url = "host.docker.internal:8001/api/user")
public interface UsuarioClientRest {

  @GetMapping("/{id}")
  Usuario detalle(@PathVariable Long id);

  @PostMapping("/")
  Usuario crear(@RequestBody Usuario usuario);

  @GetMapping("/usuarios-por-curso")
  List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
