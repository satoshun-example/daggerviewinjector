package com.github.satoshun.example.dagger.viewinjector.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.satoshun.example.dagger.viewinjector.HasViewInjector
import com.github.satoshun.example.dagger.viewinjector.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, HasViewInjector {

  @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
  @Inject lateinit var viewInjector: DispatchingAndroidInjector<View>

  private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_home -> {
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_dashboard -> {
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_notifications -> {
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)
    AndroidInjection.inject(this)

    val navigation = findViewById(R.id.navigation) as BottomNavigationView
    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

  override fun viewInjector(): AndroidInjector<View> = viewInjector
}
