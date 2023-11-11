package com.talha.bookshelf.data.network

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("thumbnails") val thumbnail: String
) {
    val httpsThumbnail: String
        get() = thumbnail.replace("http", "https")
}