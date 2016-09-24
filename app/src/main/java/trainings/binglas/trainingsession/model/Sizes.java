package trainings.binglas.trainingsession.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaozao on 24/09/16.
 */

public class Sizes {

    @SerializedName("-canblog")
    @Expose
    private String canblog;
    @SerializedName("-canprint")
    @Expose
    private String canprint;
    @SerializedName("-candownload")
    @Expose
    private String candownload;
    @SerializedName("size")
    @Expose
    private List<Size> size = new ArrayList<Size>();

    /**
     *
     * @return
     * The canblog
     */
    public String getCanblog() {
        return canblog;
    }

    /**
     *
     * @param canblog
     * The -canblog
     */
    public void setCanblog(String canblog) {
        this.canblog = canblog;
    }

    /**
     *
     * @return
     * The canprint
     */
    public String getCanprint() {
        return canprint;
    }

    /**
     *
     * @param canprint
     * The -canprint
     */
    public void setCanprint(String canprint) {
        this.canprint = canprint;
    }

    /**
     *
     * @return
     * The candownload
     */
    public String getCandownload() {
        return candownload;
    }

    /**
     *
     * @param candownload
     * The -candownload
     */
    public void setCandownload(String candownload) {
        this.candownload = candownload;
    }

    /**
     *
     * @return
     * The size
     */
    public List<Size> getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    public void setSize(List<Size> size) {
        this.size = size;
    }

}
