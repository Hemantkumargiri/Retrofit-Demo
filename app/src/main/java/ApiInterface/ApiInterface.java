package ApiInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.SystemInfo;
import Model.UserParams;
import Model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("authenticate")
    Call<UserResponse> fetchUser(
            @HeaderMap Map<String, String> headers,
            @Body UserParams data);

}