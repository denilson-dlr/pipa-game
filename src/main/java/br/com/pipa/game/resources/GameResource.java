package br.com.pipa.game.resources;

import br.com.pipa.game.domain.Ranking;
import br.com.pipa.game.domain.Score;
import br.com.pipa.game.domain.User;
import br.com.pipa.game.services.RankingService;
import br.com.pipa.game.services.ScoreService;
import br.com.pipa.game.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value="/pipa-game")
@Api(
        value = "Pipa Game Microservice Endpoint",
        tags = "Pipa Game Microservice"
)
public class GameResource {


    @Autowired
    private RankingService rankingService;

    @Autowired
    private UserService userService;

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "findHighscores", nickname = "Search users by highest score points.", response = Ranking.class)
    @RequestMapping(value="/highscorelist", method= RequestMethod.GET)
    public ResponseEntity<Ranking> findHighscores(){
        Ranking ranking = rankingService.find();
        return ResponseEntity.ok().body(ranking);
    }

    @ApiOperation(value = "findById", nickname = "Search a user by id.", response = User.class)
    @RequestMapping(value="/{id}/position", method=RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @ApiOperation(value = "saveNewScore", nickname = "Save a user's score points.")
    @RequestMapping(value = "/score", method=RequestMethod.POST)
    public ResponseEntity<User> saveNewScore(@RequestBody @Valid Score score){
        Score obj = scoreService.insert(score);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(obj.toString()).toUri();
        return ResponseEntity.created(uri).build();
    }
}