package com.example.taskappplaner.dependencies

import com.example.taskappplaner.model.dbTask
import com.example.taskappplaner.ui.taskViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleTaksInject = module {
    single { dbTask.getInstance(androidApplication()).userDao() }
    single { dbTask.getInstance(androidApplication()).taskDao() }
    single { taskRep(get()) }
    single { userRep(get()) }
    single<storagePrefer> { sharedPrefer(androidApplication()) }
    viewModel { taskViewModel(get()) }
}