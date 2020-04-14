package br.com.pipa.game.repositories;

import br.com.pipa.game.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserRepository implements UserRepository{

    private List<User> inMemory = new ArrayList<>();

    @Override
    public User findById(Long id) {
        User obj = inMemory.stream()
                .filter(user -> id.equals(user.getUserId()))
                .findFirst()
                .orElse(null);
        return obj;
    }

    @Override
    public void save(User user) {
        inMemory.add(user);
    }

    @Override
    public List<User> findAll() {
        return inMemory;
    }

    @Override
    public void updateScore(User userNewScore) {
        inMemory.stream()
                .filter(user -> user.getUserId().equals(userNewScore.getUserId()))
                .forEach(user -> user.setScore(userNewScore.getScore()));
    }

}
