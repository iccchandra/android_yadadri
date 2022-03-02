package qrcoba.w3engineers.com.qrcoba.ui.network.model;

import com.google.gson.annotations.SerializedName;

public class GetPiligrimDetails {


    @SerializedName("_id")
    public String _id;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public GetPiligrimDetails(String name, String job) {
        this.job = job;
    }
}
