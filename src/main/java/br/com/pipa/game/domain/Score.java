package br.com.pipa.game.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Score Object", subTypes = {Score.class})
public class Score implements Serializable {
    public static final long  serialVersionUID = 1L;

    @ApiModelProperty(dataType = "Long",
                      notes = "User Id.",
                      example = "1",
                      position = 1)
    private Long userId;

    @ApiModelProperty(dataType = "Long",
                      notes = "User's points.",
                      example = "5",
                      position = 2)
    private Long points;

    public Score(){

    }

    public Score(Long userId, Long points) {
        super();
        this.userId = userId;
        this.points = points;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
