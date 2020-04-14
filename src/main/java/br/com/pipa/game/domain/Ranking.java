package br.com.pipa.game.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "Ranking Object", subTypes = {Ranking.class})
public class Ranking implements Serializable {
    public static final long  serialVersionUID = 1L;

    @ApiModelProperty(dataType = "List of User Object",
                      notes = "Retrieves the high scores list, in order by position.")
    private List<User> highscores;

    public Ranking(){

    }

    public List<User> getHighscores() {
        return highscores;
    }

    public void setHighscores(List<User> highscores) {
        this.highscores = highscores;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
