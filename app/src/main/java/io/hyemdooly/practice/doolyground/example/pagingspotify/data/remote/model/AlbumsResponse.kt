package io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumsResponse(
    val href: String,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int,
    val items: List<Album>,
)

@Serializable
data class Album(
    @SerialName("album_type") val albumType: String,
    @SerialName("total_tracks") val totalTracks: Int,
    @SerialName("available_markets") val availableMarkets: List<String>,
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<AlbumImage>,
    val name: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("release_date_precision") val releaseDatePrecision: String,
    val restrictions: Restrictions?,
    val type: String,
    val uri: String,
    val artists: List<Artist>,
    @SerialName("album_group") val albumGroup: String,
)

@Serializable
data class ExternalUrls(
    val spotify: String,
)

@Serializable
data class AlbumImage(
    val url: String,
    val height: Int,
    val width: Int,
)

@Serializable
data class Restrictions(
    val reason: String,
)

@Serializable
data class Artist(
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String,
)
