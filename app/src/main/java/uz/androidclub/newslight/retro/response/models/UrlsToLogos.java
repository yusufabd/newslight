
package uz.androidclub.newslight.retro.response.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UrlsToLogos implements Parcelable
{

    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;
    public final static Parcelable.Creator<UrlsToLogos> CREATOR = new Creator<UrlsToLogos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UrlsToLogos createFromParcel(Parcel in) {
            UrlsToLogos instance = new UrlsToLogos();
            instance.small = ((String) in.readValue((String.class.getClassLoader())));
            instance.medium = ((String) in.readValue((String.class.getClassLoader())));
            instance.large = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public UrlsToLogos[] newArray(int size) {
            return (new UrlsToLogos[size]);
        }

    }
    ;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(small);
        dest.writeValue(medium);
        dest.writeValue(large);
    }

    public int describeContents() {
        return  0;
    }

}
