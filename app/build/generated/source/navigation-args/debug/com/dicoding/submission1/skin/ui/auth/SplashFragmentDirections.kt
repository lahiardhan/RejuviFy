package com.dicoding.submission1.skin.ui.auth

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R
import kotlin.Boolean
import kotlin.Int

public class SplashFragmentDirections private constructor() {
  private data class ActionSplashFragmentToLoginFragment(
    public val isFromSignUp: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.action_splashFragment_to_loginFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("is_from_sign_up", this.isFromSignUp)
        return result
      }
  }

  public companion object {
    public fun actionSplashFragmentToLoginFragment(isFromSignUp: Boolean = false): NavDirections =
        ActionSplashFragmentToLoginFragment(isFromSignUp)

    public fun actionSplashFragmentToSignUpFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_signUpFragment)

    public fun actionSplashFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_mainActivity)
  }
}
