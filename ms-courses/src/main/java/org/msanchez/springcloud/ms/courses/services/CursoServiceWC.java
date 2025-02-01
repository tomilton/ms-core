package org.msanchez.springcloud.ms.courses.services;

import org.msanchez.springcloud.ms.courses.models.Usuario;
import org.msanchez.springcloud.ms.courses.models.entity.Curso;
import org.msanchez.springcloud.ms.courses.models.entity.CursoUsuario;
import org.msanchez.springcloud.ms.courses.repositories.CursoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Service("cursoServiceWC")
@Primary
public class CursoServiceWC implements CursoService {

  private final CursoRepository repository;
  private final WebClient.Builder client;

  public CursoServiceWC(WebClient.Builder client, CursoRepository repository) {
    this.client = client;
    this.repository = repository;
  }

  @Override
  public List<Curso> listar() {
    return List.of();
  }

  @Override
  public Optional<Curso> porId(Long id) {
    return Optional.empty();
  }

  @Override
  public Optional<Curso> porIdConUsuarios(Long id) {
    return Optional.empty();
  }

  @Override
  public Curso guardar(Curso curso) {
    return null;
  }

  @Override
  public void eliminar(Long id) {}

  @Override
  public void eliminarCursoUsuarioPorId(Long id) {}

  @Override
  public Optional<Usuario> asignarUsuario(Usuario payload, Long cursoId) {
    Optional<Curso> cursoDB = repository.findById(cursoId);
    if (cursoDB.isEmpty()) {
      return Optional.empty();
    }
    String uri = String.format("/api/user/%d", payload.getId());
    Usuario usuario;

    try {
      usuario =
          client
              .build()
              .get()
              .uri(uri)
              .accept(MediaType.APPLICATION_JSON)
              .retrieve()
              .bodyToMono(Usuario.class)
              .block();
    } catch (WebClientException e) {
      return Optional.empty();
    }

    if (Objects.isNull(usuario)) {
      return Optional.empty();
    }

    Curso curso = cursoDB.get();

    Predicate<CursoUsuario> booleanPredicate =
        x -> Objects.equals(x.getUsuarioId(), usuario.getId());
    List<CursoUsuario> cursoUsuarioLIst =
        curso.getCursoUsuarios().stream().filter(booleanPredicate).toList();

    if (!cursoUsuarioLIst.isEmpty()) {
      return Optional.of(usuario);
    }

    CursoUsuario cursoUsuario = new CursoUsuario();
    cursoUsuario.setUsuarioId(usuario.getId());

    curso.addCursoUsuario(cursoUsuario);
    repository.save(curso);
    return Optional.of(usuario);
  }

  @Override
  public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {
    return Optional.empty();
  }

  @Override
  public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId) {
    return Optional.empty();
  }
}
