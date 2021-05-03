package id.co.npad93.pm.t6;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolIdolApi {
    @GET("idols/?main=True")
    Call<IdolResponse> getIdols(
        @Query("page_size") int itemsPerRequest,
        @Query("page") int page
    );
}
