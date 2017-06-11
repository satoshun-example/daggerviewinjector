package com.github.satoshun.example.dagger.viewinjector.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainInjectorsModule {

  @ContributesAndroidInjector(modules = arrayOf(
      BindMainActivity::class,
      MainViewInjectorModule::class
  ))
  abstract fun contributesMainActivity(): MainActivity
}
