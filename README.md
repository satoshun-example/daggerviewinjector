# Dagger sample for android View

AndroidViewInjection can be injection like a AndroidInjection.

this sample is a kotlin.


## How to use it?

define

```kotlin
@Module
abstract class MainInjectorsModule {

  @ContributesAndroidInjector(modules = arrayOf(
      MainViewInjectorModule::class
  ))
  abstract fun contributesMainActivity(): MainActivity
}


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
```

use from View

```kotlin
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

```


## license

Copyright 2017 SatoShun

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
