package com.test.testassignment.di

import com.test.testassignment.data.ActionsRepositoryImpl
import com.test.testassignment.data.source.ActionsDataSource
import com.test.testassignment.data.source.remote.ActionsRemoteDataSource
import com.test.testassignment.data.source.remote.ApiDataServiceFactory
import com.test.testassignment.data.source.remote.api.ActionsApi
import com.test.testassignment.domain.ActionsRepository
import com.test.testassignment.domain.usecase.GetActionsUseCase
import com.test.testassignment.presentation.home.HomeViewModel
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networking = module {
    single<ActionsApi> { ApiDataServiceFactory.makeSampleDataService(BuildConfig.DEBUG) }
}
val dataSourceModules = module {
    single<ActionsDataSource> { ActionsRemoteDataSource(actionsApi = get()) }
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