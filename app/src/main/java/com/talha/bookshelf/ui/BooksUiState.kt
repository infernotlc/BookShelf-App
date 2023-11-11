package com.talha.bookshelf.ui

sealed interface BooksUiState {
    object Loading : BooksUiState
    object Error : BooksUiState
    data class Success(val images: List<String>) : BooksUiState
}