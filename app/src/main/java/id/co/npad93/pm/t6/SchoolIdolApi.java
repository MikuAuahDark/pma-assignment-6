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

    @GET("cards/?ordering=-game_id&is_special=False&is_promo=False&is_event=False&hp=4")
    Call<CardResponse> getCards(
        @Query("page_size") int itemsPerRequest,
        @Query("page") int page,
        @Query("rarity") String rarity
    );
}
