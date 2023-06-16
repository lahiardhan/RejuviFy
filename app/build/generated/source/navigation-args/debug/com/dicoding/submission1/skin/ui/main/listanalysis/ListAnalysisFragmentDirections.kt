package com.dicoding.submission1.skin.ui.main.listanalysis

import android.os.Bundle
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class ListAnalysisFragmentDirections private constructor() {
  private data class ActionListStoryFragmentToDetailStoryFragment(
    public val name: String,
    public val description: String,
    public val photoUrl: String,
    public val id: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listStoryFragment_to_detailStoryFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        result.putString("description", this.description)
        result.putString("photo_url", this.photoUrl)
        result.putString("id", this.id)
        return result
      }
  }

  private data class ActionListStoryFragmentToCreateStoryFragment(
    public val isBackCamera: Boolean = true
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listStoryFragment_to_createStoryFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("isBackCamera", this.isBackCamera)
        return result
      }
  }

  public companion object {
    public fun actionListStoryFragmentToDetailStoryFragment(
      name: String,
      description: String,
      photoUrl: String,
      id: String
    ): NavDirections = ActionListStoryFragmentToDetailStoryFragment(name, description, photoUrl, id)

    public fun actionListStoryFragmentToCreateStoryFragment(isBackCamera: Boolean = true):
        NavDirections = ActionListStoryFragmentToCreateStoryFragment(isBackCamera)
  }
}
