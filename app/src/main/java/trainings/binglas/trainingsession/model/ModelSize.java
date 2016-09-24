package trainings.binglas.trainingsession.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */

public class ModelSize {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;

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

}
