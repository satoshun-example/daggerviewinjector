package com.github.satoshun.example.dagger.viewinjector.ui.main

import dagger.Binds
import dagger.Module

@Module
interface BindMainActivity {
  @Binds
  fun bindMainNavigator(activity: MainActivity): MainNavigator
}
