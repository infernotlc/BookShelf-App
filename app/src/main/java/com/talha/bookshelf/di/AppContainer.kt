package com.talha.bookshelf.di

import com.talha.bookshelf.data.network.BooksApi
import com.talha.bookshelf.data.repository.BooksRepository

interface AppContainer {
    val booksApi: BooksApi
    val booksRepository: BooksRepository
}