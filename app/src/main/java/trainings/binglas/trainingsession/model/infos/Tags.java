package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaozao on 24/09/16.
 */
public class Tags {

    @SerializedName("tag")
    @Expose
    private List<Object> tag = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The tag
     */
    public List<Object> getTag() {
        return tag;
    }

    /**
     * 
     * @param tag
     *     The tag
     */
    public void setTag(List<Object> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tag=" + tag +
                '}';
    }
}
