package com.dicoding.submission1.skin.ui.main.detailanalysis

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailAnalysisFragmentArgs(
  public val name: String,
  public val description: String,
  public val photoUrl: String,
  public val id: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("name", this.name)
    result.putString("description", this.description)
    result.putString("photo_url", this.photoUrl)
    result.putString("id", this.id)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("name", this.name)
    result.set("description", this.description)
    result.set("photo_url", this.photoUrl)
    result.set("id", this.id)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailAnalysisFragmentArgs {
      bundle.setClassLoader(DetailAnalysisFragmentArgs::class.java.classLoader)
      val __name : String?
      if (bundle.containsKey("name")) {
        __name = bundle.getString("name")
        if (__name == null) {
          throw IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue")
      }
      val __description : String?
      if (bundle.containsKey("description")) {
        __description = bundle.getString("description")
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue")
      }
      val __photoUrl : String?
      if (bundle.containsKey("photo_url")) {
        __photoUrl = bundle.getString("photo_url")
        if (__photoUrl == null) {
          throw IllegalArgumentException("Argument \"photo_url\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"photo_url\" is missing and does not have an android:defaultValue")
      }
      val __id : String?
      if (bundle.containsKey("id")) {
        __id = bundle.getString("id")
        if (__id == null) {
          throw IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue")
      }
      return DetailAnalysisFragmentArgs(__name, __description, __photoUrl, __id)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        DetailAnalysisFragmentArgs {
      val __name : String?
      if (savedStateHandle.contains("name")) {
        __name = savedStateHandle["name"]
        if (__name == null) {
          throw IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue")
      }
      val __description : String?
      if (savedStateHandle.contains("description")) {
        __description = savedStateHandle["description"]
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue")
      }
      val __photoUrl : String?
      if (savedStateHandle.contains("photo_url")) {
        __photoUrl = savedStateHandle["photo_url"]
        if (__photoUrl == null) {
          throw IllegalArgumentException("Argument \"photo_url\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"photo_url\" is missing and does not have an android:defaultValue")
      }
      val __id : String?
      if (savedStateHandle.contains("id")) {
        __id = savedStateHandle["id"]
        if (__id == null) {
          throw IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue")
      }
      return DetailAnalysisFragmentArgs(__name, __description, __photoUrl, __id)
    }
  }
}
