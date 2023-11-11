package com.talha.bookshelf.data.network

import com.google.gson.annotations.SerializedName
import com.talha.bookshelf.data.network.Thumbnails

data class VolumeInfo (
    @SerializedName("imageLinks") val imageLinks:Thumbnails?
)