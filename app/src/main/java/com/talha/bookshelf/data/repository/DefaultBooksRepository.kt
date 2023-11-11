package com.talha.bookshelf.data.repository

import com.talha.bookshelf.data.network.BooksApi

class DefaultBooksRepository(
    private val booksApi: BooksApi
) : BooksRepository {

    override suspend fun getBooksImages(query: String): List<String>? {
        return try {
            val response = booksApi.searchBooks(query)
            if (response.isSuccessful) {
                val data = response.body()!!
                data.books?.let { books ->
                    books.mapNotNull { book -> book.volumeInfo.imageLinks?.httpsThumbnail }
                } ?: emptyList()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}



