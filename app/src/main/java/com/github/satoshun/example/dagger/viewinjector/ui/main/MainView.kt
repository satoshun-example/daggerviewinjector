package com.github.satoshun.example.dagger.viewinjector.ui.main

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import com.github.satoshun.example.dagger.viewinjector.AndroidViewInjection
import javax.inject.Inject

class MainView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

  @Inject
  lateinit var navigator: MainNavigator

  init {
    val button = Button(context)
    button.text = "SHOW TOAST"
    button.setOnClickListener {
      navigator.showToast()
    }
    addView(button)
  }

  override fun onAttachedToWindow() {
    AndroidViewInjection.inject(this)
    super.onAttachedToWindow()
  }
}
