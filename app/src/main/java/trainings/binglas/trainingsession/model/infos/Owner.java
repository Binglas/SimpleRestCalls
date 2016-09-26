package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */
public class Owner {

    @SerializedName("nsid")
    @Expose
    private String nsid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("iconserver")
    @Expose
    private Integer iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("path_alias")
    @Expose
    private String pathAlias;

    /**
     * 
     * @return
     *     The nsid
     */
    public String getNsid() {
        return nsid;
    }

    /**
     * 
     * @param nsid
     *     The nsid
     */
    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 
     * @param realname
     *     The realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 
     * @return
     *     The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The iconserver
     */
    public Integer getIconserver() {
        return iconserver;
    }

    /**
     * 
     * @param iconserver
     *     The iconserver
     */
    public void setIconserver(Integer iconserver) {
        this.iconserver = iconserver;
    }

    /**
     * 
     * @return
     *     The iconfarm
     */
    public Integer getIconfarm() {
        return iconfarm;
    }

    /**
     * 
     * @param iconfarm
     *     The iconfarm
     */
    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    /**
     * 
     * @return
     *     The pathAlias
     */
    public String getPathAlias() {
        return pathAlias;
    }

    /**
     * 
     * @param pathAlias
     *     The path_alias
     */
    public void setPathAlias(String pathAlias) {
        this.pathAlias = pathAlias;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "nsid='" + nsid + '\'' +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", location='" + location + '\'' +
                ", iconserver=" + iconserver +
                ", iconfarm=" + iconfarm +
                ", pathAlias='" + pathAlias + '\'' +
                '}';
    }
}
