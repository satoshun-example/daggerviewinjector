package com.github.satoshun.example.dagger.viewinjector.ui.main

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.github.satoshun.example.dagger.viewinjector.AndroidViewInjection

class MainView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
  : RelativeLayout(context, attrs, defStyleAttr) {

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context) : this(context, null)

  init {
    AndroidViewInjection.inject(this)
  }
}
