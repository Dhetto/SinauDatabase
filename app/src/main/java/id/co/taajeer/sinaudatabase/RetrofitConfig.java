package id.co.taajeer.sinaudatabase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Didit on 5/5/2017.
 */

public class RetrofitConfig {
    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://127.0.01/berita/berita/")
                .baseUrl("http://192.168.100.4/berita/")
                //.baseUrl("http://192.168.95.172/berita/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static API_Service getInstanceRetrofit()
    {
        return getRetrofit().create(API_Service.class);
    }

}
