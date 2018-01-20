# Dagger sample for android View

AndroidViewInjection can be injection like a AndroidInjection(Dagger Android module).

This sample is a kotlin.


## How to use it?

Dagger Android module doesn't support View, so we need to define it myself.

first, define Module and Subcomponent. 

```kotlin
@Module
abstract class MainInjectorsModule {
  @ContributesAndroidInjector(modules = [MainViewInjectorModule::class])
  abstract fun contributesMainActivity(): MainActivity
}


@Module(subcomponents = [MainViewInjectorModule.MainViewSubcomponent::class])
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

second, inject from AndroidViewInjection from View.

```kotlin
class MainView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
  : RelativeLayout(context, attrs, defStyleAttr) {

  @Inject lateinit var navigator: MainNavigator

  override fun onAttachedToWindow() {
    AndroidViewInjection.inject(this)
    super.onAttachedToWindow()
  }
}

```


## license

```
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
```
