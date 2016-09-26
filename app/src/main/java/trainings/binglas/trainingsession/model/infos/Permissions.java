package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */
public class Permissions {

    @SerializedName("permcomment")
    @Expose
    private Integer permcomment;
    @SerializedName("permaddmeta")
    @Expose
    private Integer permaddmeta;

    /**
     * 
     * @return
     *     The permcomment
     */
    public Integer getPermcomment() {
        return permcomment;
    }

    /**
     * 
     * @param permcomment
     *     The permcomment
     */
    public void setPermcomment(Integer permcomment) {
        this.permcomment = permcomment;
    }

    /**
     * 
     * @return
     *     The permaddmeta
     */
    public Integer getPermaddmeta() {
        return permaddmeta;
    }

    /**
     * 
     * @param permaddmeta
     *     The permaddmeta
     */
    public void setPermaddmeta(Integer permaddmeta) {
        this.permaddmeta = permaddmeta;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permcomment=" + permcomment +
                ", permaddmeta=" + permaddmeta +
                '}';
    }
}
