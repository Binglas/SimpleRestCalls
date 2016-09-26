
package trainings.binglas.trainingsession.model.infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by joaozao on 24/09/16.
 */
public class Comments {

    @SerializedName("_content")
    @Expose
    private Integer content;

    /**
     * 
     * @return
     *     The content
     */
    public Integer getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The _content
     */
    public void setContent(Integer content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "content=" + content +
                '}';
    }
}
