package org.msanchez.springcloud.ms.users.services;

import lombok.AllArgsConstructor;
import org.msanchez.springcloud.ms.users.model.entity.User;
import org.msanchez.springcloud.ms.users.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Transactional(readOnly = true)
  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  @Transactional
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
