package trainings.binglas.trainingsession.model.photos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */

public class GetPublicPhotosResponse {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     *
     * @return
     * The photos
     */
    public Photos getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    /**
     *
     * @return
     * The stat
     */
    public String getStat() {
        return stat;
    }

    /**
     *
     * @param stat
     * The stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "GetPublicPhotosResponse{" +
                "photos=" + photos +
                ", stat='" + stat + '\'' +
                '}';
    }
}
