package qrcoba.w3engineers.com.qrcoba.ui.network;

import com.google.gson.JsonObject;

import qrcoba.w3engineers.com.qrcoba.ui.network.model.GetPiligrimDetails;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/data")
    Call<GetPiligrimDetails> fetchData(@Body JsonObject jsonObject);
}
