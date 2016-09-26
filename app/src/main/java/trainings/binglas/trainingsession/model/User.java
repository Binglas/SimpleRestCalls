package trainings.binglas.trainingsession.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */

public class User {

    @SerializedName("-nsid")
    @Expose
    private String nsid;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     *
     * @return
     * The nsid
     */
    public String getNsid() {
        return nsid;
    }

    /**
     *
     * @param nsid
     * The -nsid
     */
    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
