package com.innovecs.testassignment.di

import com.innovecs.testassignment.data.ActionsRepositoryImpl
import com.innovecs.testassignment.data.source.ActionsDataSource
import com.innovecs.testassignment.data.source.remote.ActionsRemoteDataSource
import com.innovecs.testassignment.domain.ActionsRepository
import com.innovecs.testassignment.domain.usecase.GetActionsUseCase
import com.innovecs.testassignment.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networking = module {
    //TODO
}
val dataSourceModules = module {
    single<ActionsDataSource> { ActionsRemoteDataSource() }
}

val repositoryModules = module {
    single<ActionsRepository> { ActionsRepositoryImpl(remoteDataSource = get()) }
}

val useCaseModules = module {
    factory {
        GetActionsUseCase(actionsRepository = get())
    }
}

val viewModels = module {
    viewModel {
        HomeViewModel(getActionsUseCase = get())
    }
}