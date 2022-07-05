package com.mykhailo_pavliuk.smart_cookie.repository.impl;

import com.mykhailo_pavliuk.smart_cookie.exception.EntityNotFoundException;
import com.mykhailo_pavliuk.smart_cookie.model.User;
import com.mykhailo_pavliuk.smart_cookie.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {
  private final List<User> list = new ArrayList<>();

  @Override
  public User getUser(long id) {
    log.info("Get user with id {}", id);
    return list.stream()
        .filter(user -> user.getId() == id)
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException("User is not found"));
  }

  @Override
  public List<User> getUsers() {
    log.info("Get all users");
    return new ArrayList<>(list);
  }

  @Override
  public User createUser(User user) {
    log.info("Create user {}", user);
    user.setId((long) (list.size() + 1));
    user.setSubscriptions(new ArrayList<>());
    list.add(user);
    return user;
  }

  @Override
  public User updateUser(long id, User user) {
    log.info("Update user with id {}", id);
    boolean isDeleted = list.removeIf(u -> u.getId() == id);
    if (isDeleted) {
      list.add(user);
    } else {
      throw new EntityNotFoundException("User is not found");
    }
    return user;
  }

  @Override
  public void deleteUser(long id) {
    log.info("Delete user with id {}", id);
    list.removeIf(user -> user.getId() == id);
  }

  @Override
  public boolean existsByEmail(String email) {
    return list.stream().anyMatch(user -> user.getEmail().equals(email));
  }
}
