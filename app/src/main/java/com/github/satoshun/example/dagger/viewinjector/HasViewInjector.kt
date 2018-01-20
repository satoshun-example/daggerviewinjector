package com.github.satoshun.example.dagger.viewinjector

import android.view.View
import dagger.android.AndroidInjector

interface HasViewInjector {
  fun viewInjector(): AndroidInjector<View>
}
