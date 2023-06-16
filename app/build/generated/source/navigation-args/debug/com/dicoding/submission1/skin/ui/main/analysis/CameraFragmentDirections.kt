package com.dicoding.submission1.skin.ui.main.analysis

import android.os.Bundle
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R
import kotlin.Boolean
import kotlin.Int

public class CameraFragmentDirections private constructor() {
  private data class ActionCameraFragmentToCreateStoryFragment(
    public val isBackCamera: Boolean = true
  ) : NavDirections {
    public override val actionId: Int = R.id.action_cameraFragment_to_createStoryFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("isBackCamera", this.isBackCamera)
        return result
      }
  }

  public companion object {
    public fun actionCameraFragmentToCreateStoryFragment(isBackCamera: Boolean = true):
        NavDirections = ActionCameraFragmentToCreateStoryFragment(isBackCamera)
  }
}
