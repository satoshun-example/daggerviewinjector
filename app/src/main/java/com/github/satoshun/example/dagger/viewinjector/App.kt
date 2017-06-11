package com.github.satoshun.example.dagger.viewinjector

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

  override fun onCreate() {
    super.onCreate()
  }

  override fun applicationInjector(): AndroidInjector<App> {
    return DaggerAppComponent.builder().create(this)
  }
}
