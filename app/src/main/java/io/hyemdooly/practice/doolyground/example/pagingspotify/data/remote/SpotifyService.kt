package io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote

import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.model.AlbumsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyService {
    @POST("")
    @GET("/artists/{id}/albums")
    fun getAlbums(
        @Path("id") id: String,
        @Query("market") market: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Call<AlbumsResponse>
}
