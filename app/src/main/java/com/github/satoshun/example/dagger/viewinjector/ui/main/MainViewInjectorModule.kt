package com.github.satoshun.example.dagger.viewinjector.ui.main

import android.view.View
import com.github.satoshun.example.dagger.viewinjector.di.ViewKey
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(MainViewInjectorModule.MainViewSubcomponent::class))
abstract class MainViewInjectorModule {

  @Binds
  @IntoMap
  @ViewKey(MainView::class)
  internal abstract fun bindAndroidInjectorFactory(builder: MainViewSubcomponent.Builder)
      : AndroidInjector.Factory<out View>

  @Subcomponent
  interface MainViewSubcomponent : AndroidInjector<MainView> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainView>()
  }
}
