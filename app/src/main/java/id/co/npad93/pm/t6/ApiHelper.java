package id.co.npad93.pm.t6;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://schoolido.lu/api/").addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
