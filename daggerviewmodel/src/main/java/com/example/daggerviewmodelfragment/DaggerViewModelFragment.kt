package com.example.daggerviewmodelfragment

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class DaggerViewModelFragment<T : ViewModel>(var clazz: Class<T>) : DaggerFragment() {

    lateinit var viewModel: T

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

    private fun createViewModel(): T {
        return ViewModelProvider(this, factory).get(clazz)
    }
}