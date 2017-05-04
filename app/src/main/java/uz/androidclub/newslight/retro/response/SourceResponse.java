
package uz.androidclub.newslight.retro.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import uz.androidclub.newslight.retro.response.models.SourceDTO;

public class SourceResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<SourceDTO> sourceDTOs = null;
    public final static Parcelable.Creator<SourceResponse> CREATOR = new Creator<SourceResponse>() {

        @SuppressWarnings({
            "unchecked"
        })
        public SourceResponse createFromParcel(Parcel in) {
            SourceResponse instance = new SourceResponse();
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.sourceDTOs, (SourceDTO.class.getClassLoader()));
            return instance;
        }

        public SourceResponse[] newArray(int size) {
            return (new SourceResponse[size]);
        }

    };

    public String getStatus() {
        return status;
    }

    public List<SourceDTO> getSourceDTOs() {
        return sourceDTOs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(sourceDTOs);
    }

    public int describeContents() {
        return  0;
    }

}
