package id.co.npad93.pm.t6;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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

    public static void loadImageAsync(Context f, String url, ImageView iv) {
        Glide.with(f).load(url).into(iv);
    }

    public static <T> T nullCoalesce(T a, T b) {
        return a == null ? b : a;
    }
}
