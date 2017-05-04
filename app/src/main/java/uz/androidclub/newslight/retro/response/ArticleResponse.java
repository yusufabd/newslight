
package uz.androidclub.newslight.retro.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import uz.androidclub.newslight.retro.response.models.ArticleDTO;

public class ArticleResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("sortBy")
    @Expose
    private String sortBy;
    @SerializedName("articles")
    @Expose
    private List<ArticleDTO> articleDTOs = null;
    public final static Parcelable.Creator<ArticleResponse> CREATOR = new Creator<ArticleResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ArticleResponse createFromParcel(Parcel in) {
            ArticleResponse instance = new ArticleResponse();
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.source = ((String) in.readValue((String.class.getClassLoader())));
            instance.sortBy = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.articleDTOs, (ArticleDTO.class.getClassLoader()));
            return instance;
        }

        public ArticleResponse[] newArray(int size) {
            return (new ArticleResponse[size]);
        }

    }
    ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<ArticleDTO> getArticleDTOs() {
        return articleDTOs;
    }

    public void setArticleDTOs(List<ArticleDTO> articleDTOs) {
        this.articleDTOs = articleDTOs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(source);
        dest.writeValue(sortBy);
        dest.writeList(articleDTOs);
    }

    public int describeContents() {
        return  0;
    }

}
