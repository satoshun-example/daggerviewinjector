package com.github.satoshun.example.dagger.viewinjector.di

import android.view.View
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

@Module
interface AndroidViewInjectionModule {
  @Multibinds
  fun viewInjectorFactories(): Map<Class<out View>, AndroidInjector.Factory<out View>>

  @Multibinds
  fun viewInjectorFactoriesWithStringKeys(): Map<String, AndroidInjector.Factory<out View>>
}
