package com.github.satoshun.example.dagger.viewinjector

import com.github.satoshun.example.dagger.viewinjector.di.AndroidViewInjectionModule
import com.github.satoshun.example.dagger.viewinjector.ui.main.MainInjectorsModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    AndroidViewInjectionModule::class,
    MainInjectorsModule::class
))
interface AppComponent : AndroidInjector<App> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<App>()
}
