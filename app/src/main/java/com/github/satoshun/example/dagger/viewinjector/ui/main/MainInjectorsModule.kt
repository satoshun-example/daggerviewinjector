package com.github.satoshun.example.dagger.viewinjector.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainInjectorsModule {
  @ContributesAndroidInjector(modules = [BindMainActivity::class, MainViewInjectorModule::class])
  fun contributesMainActivity(): MainActivity
}
