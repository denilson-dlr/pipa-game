package br.com.pipa.game.services;

import br.com.pipa.game.domain.Ranking;
import br.com.pipa.game.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RankingService {

    @Autowired
    private UserService service;

    @Autowired
    private QuickSortService sortService;

    public List<User> findAllUsers() {
        List<User> obj = service.findAll();
        return obj;
    }

    public Ranking find() {
        List<User> list = findAllUsers();
        Ranking ranking = new Ranking();
        ranking.setHighscores(list);
        return ranking;
    }

    public void updateRanking(){
        List<User> list = findAllUsers();
        int last = list.size()-1;
        sortService.quickSort(list, 0, last);
    }

}