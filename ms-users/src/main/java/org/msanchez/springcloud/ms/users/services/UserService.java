package org.msanchez.springcloud.ms.users.services;

import org.msanchez.springcloud.ms.users.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  List<User> findAll();

  Optional<User> getById(Long id);

  User save(User user);

  void delete(Long id);
}
