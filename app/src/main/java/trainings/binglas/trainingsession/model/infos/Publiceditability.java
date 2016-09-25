package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */
public class Publiceditability {

    @SerializedName("cancomment")
    @Expose
    private Integer cancomment;
    @SerializedName("canaddmeta")
    @Expose
    private Integer canaddmeta;

    /**
     * 
     * @return
     *     The cancomment
     */
    public Integer getCancomment() {
        return cancomment;
    }

    /**
     * 
     * @param cancomment
     *     The cancomment
     */
    public void setCancomment(Integer cancomment) {
        this.cancomment = cancomment;
    }

    /**
     * 
     * @return
     *     The canaddmeta
     */
    public Integer getCanaddmeta() {
        return canaddmeta;
    }

    /**
     * 
     * @param canaddmeta
     *     The canaddmeta
     */
    public void setCanaddmeta(Integer canaddmeta) {
        this.canaddmeta = canaddmeta;
    }

    @Override
    public String toString() {
        return "Publiceditability{" +
                "cancomment=" + cancomment +
                ", canaddmeta=" + canaddmeta +
                '}';
    }
}
