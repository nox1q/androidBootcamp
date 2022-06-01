package kz.noxiq.chocoexpress.di.modules

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        DataModule::class,
        NetworkModule::class
    ]
)
class AppModule