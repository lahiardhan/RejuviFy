package com.dicoding.submission1.skin.ui.main.analysis

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R

public class CreateAnalysisFragmentDirections private constructor() {
  public companion object {
    public fun actionCreateStoryFragmentToCameraFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_createStoryFragment_to_cameraFragment)

    public fun actionCreateStoryFragmentToListStoryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_createStoryFragment_to_listStoryFragment)
  }
}
