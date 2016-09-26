package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by joaozao on 24/09/16.
 */
public class Dates {

    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("taken")
    @Expose
    private String taken;
    @SerializedName("takengranularity")
    @Expose
    private Integer takengranularity;
    @SerializedName("takenunknown")
    @Expose
    private Integer takenunknown;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;

    /**
     * 
     * @return
     *     The posted
     */
    public String getPosted() {
        return posted;
    }

    /**
     * 
     * @param posted
     *     The posted
     */
    public void setPosted(String posted) {
        this.posted = posted;
    }

    /**
     * 
     * @return
     *     The taken
     */
    public String getTaken() {
        return taken;
    }

    /**
     * 
     * @param taken
     *     The taken
     */
    public void setTaken(String taken) {
        this.taken = taken;
    }

    /**
     * 
     * @return
     *     The takengranularity
     */
    public Integer getTakengranularity() {
        return takengranularity;
    }

    /**
     * 
     * @param takengranularity
     *     The takengranularity
     */
    public void setTakengranularity(Integer takengranularity) {
        this.takengranularity = takengranularity;
    }

    /**
     * 
     * @return
     *     The takenunknown
     */
    public Integer getTakenunknown() {
        return takenunknown;
    }

    /**
     * 
     * @param takenunknown
     *     The takenunknown
     */
    public void setTakenunknown(Integer takenunknown) {
        this.takenunknown = takenunknown;
    }

    /**
     * 
     * @return
     *     The lastupdate
     */
    public String getLastupdate() {
        return lastupdate;
    }

    /**
     * 
     * @param lastupdate
     *     The lastupdate
     */
    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "posted='" + posted + '\'' +
                ", taken='" + taken + '\'' +
                ", takengranularity=" + takengranularity +
                ", takenunknown=" + takenunknown +
                ", lastupdate='" + lastupdate + '\'' +
                '}';
    }
}
