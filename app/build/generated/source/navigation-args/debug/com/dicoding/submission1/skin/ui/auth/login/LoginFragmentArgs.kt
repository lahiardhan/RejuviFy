package com.dicoding.submission1.skin.ui.auth.login

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.jvm.JvmStatic

public data class LoginFragmentArgs(
  public val isFromSignUp: Boolean = false
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("is_from_sign_up", this.isFromSignUp)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("is_from_sign_up", this.isFromSignUp)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): LoginFragmentArgs {
      bundle.setClassLoader(LoginFragmentArgs::class.java.classLoader)
      val __isFromSignUp : Boolean
      if (bundle.containsKey("is_from_sign_up")) {
        __isFromSignUp = bundle.getBoolean("is_from_sign_up")
      } else {
        __isFromSignUp = false
      }
      return LoginFragmentArgs(__isFromSignUp)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): LoginFragmentArgs {
      val __isFromSignUp : Boolean?
      if (savedStateHandle.contains("is_from_sign_up")) {
        __isFromSignUp = savedStateHandle["is_from_sign_up"]
        if (__isFromSignUp == null) {
          throw IllegalArgumentException("Argument \"is_from_sign_up\" of type boolean does not support null values")
        }
      } else {
        __isFromSignUp = false
      }
      return LoginFragmentArgs(__isFromSignUp)
    }
  }
}
