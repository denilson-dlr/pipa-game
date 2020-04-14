package br.com.pipa.game.repositories;

import br.com.pipa.game.domain.User;

import java.util.List;

public interface UserRepository {
    User findById(Long id);

    void save(User user);

    List<User> findAll();

    void updateScore(User user);

}
