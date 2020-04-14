package br.com.pipa.game.services;


import br.com.pipa.game.domain.User;
import br.com.pipa.game.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RankingService rankingService;

    public User findById(Long id) {
        User obj = repository.findById(id);
        return obj;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User insert(User user) {
        repository.save(user);
        rankingService.updateRanking();
        return user;
    }

    public User updateScore(User user) {
        User newUser = findById(user.getUserId());
        updateDataScore(newUser, user);
        repository.updateScore(newUser);
        rankingService.updateRanking();
        return newUser;
    }


    private void updateDataScore(User newUser, User user) {
        newUser.setScore(user.getScore());
    }

}