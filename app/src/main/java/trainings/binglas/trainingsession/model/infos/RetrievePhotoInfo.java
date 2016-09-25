package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */

public class RetrievePhotoInfo {
    @SerializedName("photo")
    @Expose
    private PhotoInfo photo;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     *
     * @return
     *     The photo
     */
    public PhotoInfo getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     *     The photo
     */
    public void setPhoto(PhotoInfo photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     *     The stat
     */
    public String getStat() {
        return stat;
    }

    /**
     *
     * @param stat
     *     The stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "RetrievePhotoInfo{" +
                "photo=" + photo +
                ", stat='" + stat + '\'' +
                '}';
    }
}
