package com.talha.bookshelf.data.network

import com.google.gson.annotations.SerializedName

data class BookDto (
    @SerializedName("items") val books:List<Book>
)