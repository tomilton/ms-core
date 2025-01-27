package org.msanchez.springcloud.ms.users.repositories;

import org.msanchez.springcloud.ms.users.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
