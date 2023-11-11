package com.talha.bookshelf.data.network

import com.google.gson.annotations.SerializedName


data class Book(
    @SerializedName("id") val id:String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)