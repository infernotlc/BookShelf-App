package com.talha.bookshelf.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.talha.bookshelf.BookShelfApplication
import com.talha.bookshelf.data.repository.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {
    private val _booksUiState = MutableStateFlow<BooksUiState>(BooksUiState.Loading)
    val booksUiState = _booksUiState.asStateFlow()

    init {
        getBooksImages()
    }

    fun getBooksImages(query: String = "miami") {
        if (query.isEmpty()) return
        viewModelScope.launch {
            _booksUiState.value = BooksUiState.Loading
            try {
                val result = booksRepository.getBooksImages(query)
                _booksUiState.value = result?.let {
                    BooksUiState.Success(it)
                } ?: BooksUiState.Error
            } catch (e: Exception) {
                _booksUiState.value = BooksUiState.Error
                // Handle the exception as needed, e.g., log it.
                e.printStackTrace()
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookShelfApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}
