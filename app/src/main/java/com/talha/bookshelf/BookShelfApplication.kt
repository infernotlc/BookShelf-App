package com.talha.bookshelf

import android.app.Application
import com.talha.bookshelf.di.AppContainer
import com.talha.bookshelf.di.DefaultAppContainer

class BookShelfApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()

    }

}