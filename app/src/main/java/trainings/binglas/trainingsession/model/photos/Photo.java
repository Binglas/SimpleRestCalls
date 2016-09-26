package trainings.binglas.trainingsession.model.photos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joaozao on 24/09/16.
 */

public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;

    private String thumbnailListSize;
    private String thumbnailGridSize;
    private String imageViewSize;
    private String description;
    private String originalFormat;
    private String postedDate;
    private String postedDateHR;
    private String takenDate;
    private String lastUpdated;
    private String lastUpdatedHR;
    private String location;
    private String username;


    public String getPostedDateHR() {
        return postedDateHR;
    }

    public void setPostedDateHR(String pPostedDateHR) {
        postedDateHR = pPostedDateHR;
    }


    public String getLastUpdatedHR() {
        return lastUpdatedHR;
    }

    public void setLastUpdatedHR(String pLastUpdatedHR) {
        lastUpdatedHR = pLastUpdatedHR;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String pUsername) {
        username = pUsername;
    }




    public String getLocation() {
        return location;
    }

    public void setLocation(String pLocation) {
        location = pLocation;
    }




    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String pLastUpdated) {
        lastUpdated = pLastUpdated;
    }




    public String getImageViewSize() {
        return imageViewSize;
    }

    public void setImageViewSize(String pImageViewSize) {
        imageViewSize = pImageViewSize;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String pPostedDate) {
        postedDate = pPostedDate;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String pTakenDate) {
        takenDate = pTakenDate;
    }

    public String getOriginalFormat() {
        return originalFormat;
    }

    public void setOriginalFormat(String pOriginalFormat) {
        originalFormat = pOriginalFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        description = pDescription;
    }

    public String getThumbnailGridSize() {
        return thumbnailGridSize;
    }

    public void setThumbnailGridSize(String pThumbnailGridSize) {
        thumbnailGridSize = pThumbnailGridSize;
    }

    public String getThumbnailListSize() {
        return thumbnailListSize;
    }

    public void setThumbnailListSize(String pThumbnailListSize) {
        thumbnailListSize = pThumbnailListSize;
    }


    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     * The owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return
     * The secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     *
     * @param secret
     * The secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     *
     * @return
     * The server
     */
    public String getServer() {
        return server;
    }

    /**
     *
     * @param server
     * The server
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     *
     * @return
     * The farm
     */
    public Integer getFarm() {
        return farm;
    }

    /**
     *
     * @param farm
     * The farm
     */
    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The ispublic
     */
    public Integer getIspublic() {
        return ispublic;
    }

    /**
     *
     * @param ispublic
     * The ispublic
     */
    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    /**
     *
     * @return
     * The isfriend
     */
    public Integer getIsfriend() {
        return isfriend;
    }

    /**
     *
     * @param isfriend
     * The isfriend
     */
    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    /**
     *
     * @return
     * The isfamily
     */
    public Integer getIsfamily() {
        return isfamily;
    }

    /**
     *
     * @param isfamily
     * The isfamily
     */
    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    protected Photo(Parcel in) {
        id = in.readString();
        owner = in.readString();
        secret = in.readString();
        server = in.readString();
        farm = in.readByte() == 0x00 ? null : in.readInt();
        title = in.readString();
        ispublic = in.readByte() == 0x00 ? null : in.readInt();
        isfriend = in.readByte() == 0x00 ? null : in.readInt();
        isfamily = in.readByte() == 0x00 ? null : in.readInt();
        thumbnailListSize = in.readString();
        thumbnailGridSize = in.readString();
        imageViewSize = in.readString();
        description = in.readString();
        originalFormat = in.readString();
        postedDate = in.readString();
        takenDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(owner);
        dest.writeString(secret);
        dest.writeString(server);
        if (farm == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(farm);
        }
        dest.writeString(title);
        if (ispublic == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ispublic);
        }
        if (isfriend == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isfriend);
        }
        if (isfamily == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isfamily);
        }
        dest.writeString(thumbnailListSize);
        dest.writeString(thumbnailGridSize);
        dest.writeString(imageViewSize);
        dest.writeString(description);
        dest.writeString(originalFormat);
        dest.writeString(postedDate);
        dest.writeString(takenDate);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", secret='" + secret + '\'' +
                ", server='" + server + '\'' +
                ", farm=" + farm +
                ", title='" + title + '\'' +
                ", ispublic=" + ispublic +
                ", isfriend=" + isfriend +
                ", isfamily=" + isfamily +
                ", thumbnailListSize='" + thumbnailListSize + '\'' +
                ", thumbnailGridSize='" + thumbnailGridSize + '\'' +
                ", imageViewSize='" + imageViewSize + '\'' +
                ", description='" + description + '\'' +
                ", originalFormat='" + originalFormat + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", takenDate='" + takenDate + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}