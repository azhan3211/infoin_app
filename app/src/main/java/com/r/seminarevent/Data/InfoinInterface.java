package com.r.seminarevent.Data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Unknown on 3/25/2018.
 */

public interface InfoinInterface {

    @POST("userinfoin/store")
    Call<UserRegistration> registration(@Body UserRegistration userRegistration);
}
