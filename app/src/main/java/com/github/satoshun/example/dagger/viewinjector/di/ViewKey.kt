package com.github.satoshun.example.dagger.viewinjector.di

import android.view.View
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewKey(
    val value: KClass<out View>
)
