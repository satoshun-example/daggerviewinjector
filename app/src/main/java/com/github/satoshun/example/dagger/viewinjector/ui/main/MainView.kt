package com.github.satoshun.example.dagger.viewinjector.ui.main

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import com.github.satoshun.example.dagger.viewinjector.AndroidViewInjection
import javax.inject.Inject

class MainView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
  : RelativeLayout(context, attrs, defStyleAttr) {

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context) : this(context, null)

  @Inject lateinit var navigator: MainNavigator

  init {
    val button = Button(context)
    button.text = "SHOW TOAST"
    button.setOnClickListener {
      navigator.showToast()
    }
    addView(button)
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    AndroidViewInjection.inject(this)
  }
}
