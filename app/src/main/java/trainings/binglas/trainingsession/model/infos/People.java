package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */
public class People {

    @SerializedName("haspeople")
    @Expose
    private Integer haspeople;

    /**
     * 
     * @return
     *     The haspeople
     */
    public Integer getHaspeople() {
        return haspeople;
    }

    /**
     * 
     * @param haspeople
     *     The haspeople
     */
    public void setHaspeople(Integer haspeople) {
        this.haspeople = haspeople;
    }

    @Override
    public String toString() {
        return "People{" +
                "haspeople=" + haspeople +
                '}';
    }
}
