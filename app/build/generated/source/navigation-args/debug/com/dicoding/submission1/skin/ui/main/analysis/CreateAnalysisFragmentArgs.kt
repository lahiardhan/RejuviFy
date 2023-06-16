package com.dicoding.submission1.skin.ui.main.analysis

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.jvm.JvmStatic

public data class CreateAnalysisFragmentArgs(
  public val isBackCamera: Boolean = true
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("isBackCamera", this.isBackCamera)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("isBackCamera", this.isBackCamera)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CreateAnalysisFragmentArgs {
      bundle.setClassLoader(CreateAnalysisFragmentArgs::class.java.classLoader)
      val __isBackCamera : Boolean
      if (bundle.containsKey("isBackCamera")) {
        __isBackCamera = bundle.getBoolean("isBackCamera")
      } else {
        __isBackCamera = true
      }
      return CreateAnalysisFragmentArgs(__isBackCamera)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        CreateAnalysisFragmentArgs {
      val __isBackCamera : Boolean?
      if (savedStateHandle.contains("isBackCamera")) {
        __isBackCamera = savedStateHandle["isBackCamera"]
        if (__isBackCamera == null) {
          throw IllegalArgumentException("Argument \"isBackCamera\" of type boolean does not support null values")
        }
      } else {
        __isBackCamera = true
      }
      return CreateAnalysisFragmentArgs(__isBackCamera)
    }
  }
}
