package br.com.pipa.game.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "User Object", subTypes = {User.class})
public class User implements Serializable {
    public static final long  serialVersionUID = 1L;

    @ApiModelProperty(dataType = "Long",
                      notes = "User Id.",
                      example = "1",
                      position = 1)
    private Long userId;

    @ApiModelProperty(dataType = "Long",
                      notes = "Score represents the sum of the user's points during the game.",
                      example = "10",
                      position = 2)
    private Long score;

    @ApiModelProperty(dataType = "Long",
                      notes = "User's ranking position accordingly of his/hers score.",
                      example = "1",
                      position = 3)
    private Long position;

    public User(){

    }

    public User(Long userId, Long score, Long position) {
        super();
        this.userId = userId;
        this.score = score;
        this.position = position;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
