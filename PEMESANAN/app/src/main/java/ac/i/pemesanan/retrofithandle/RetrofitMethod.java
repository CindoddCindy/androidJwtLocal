package ac.i.pemesanan.retrofithandle;

import com.google.gson.JsonObject;

import java.util.Map;

import ac.i.pemesanan.model.ResponRegis;
import ac.i.pemesanan.model.ResponToken;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitMethod {

    @Headers({
            "Content-Type:application/json"
    })

    @POST("auth/signup")
    Call<ResponRegis> registerUser(@Body JsonObject body);

/*
    @FormUrlEncoded
    @POST("auth/signup")
    Call<ResponRegis> registerUser(@Field("nameOrd") String nameOrd, @Field("username") String username, @Field("email") String email, @Field("password") String password);

*/
    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponToken> loginUser(@Field("usernameOrEmai") String usernameOrEmai, @Field("password") String password);

}


