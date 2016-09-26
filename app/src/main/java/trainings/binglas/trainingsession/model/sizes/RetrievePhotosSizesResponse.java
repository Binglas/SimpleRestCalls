package trainings.binglas.trainingsession.model.sizes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 25/09/16.
 */

public class RetrievePhotosSizesResponse {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     *
     * @return
     * The sizes
     */
    public Sizes getSizes() {
        return sizes;
    }

    /**
     *
     * @param sizes
     * The sizes
     */
    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
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
        return "RetrievePhotosSizesResponse{" +
                "sizes=" + sizes +
                ", stat='" + stat + '\'' +
                '}';
    }
}