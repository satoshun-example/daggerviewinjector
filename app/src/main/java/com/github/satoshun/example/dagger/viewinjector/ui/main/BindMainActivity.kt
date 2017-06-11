package com.github.satoshun.example.dagger.viewinjector.ui.main

import dagger.Binds
import dagger.Module

@Module
abstract class BindMainActivity {

  @Binds
  abstract fun bindMainNavigator(activity: MainActivity): MainNavigator
}