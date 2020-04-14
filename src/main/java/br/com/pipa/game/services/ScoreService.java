package br.com.pipa.game.services;

import br.com.pipa.game.domain.Score;
import br.com.pipa.game.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class ScoreService {

    @Autowired
    private UserService service;

    public Score insert(Score score) {
        User user = service.findById(score.getUserId());
        if(Objects.nonNull(user)) {
            User userPoints = new User(user.getUserId(),user.getScore()+score.getPoints(),Long.valueOf(1));
            service.updateScore(userPoints);
        } else {
            User newUser = new User(score.getUserId(),score.getPoints(),Long.valueOf(1));
            service.insert(newUser);
        }
        return score;
    }

}
