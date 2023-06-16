package com.dicoding.submission1.skin.ui.auth.signup

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R
import kotlin.Boolean
import kotlin.Int

public class SignUpFragmentDirections private constructor() {
  private data class ActionSignUpFragmentToLoginFragment(
    public val isFromSignUp: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.action_signUpFragment_to_loginFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("is_from_sign_up", this.isFromSignUp)
        return result
      }
  }

  public companion object {
    public fun actionSignUpFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signUpFragment_to_mainActivity)

    public fun actionSignUpFragmentToLoginFragment(isFromSignUp: Boolean = false): NavDirections =
        ActionSignUpFragmentToLoginFragment(isFromSignUp)
  }
}
