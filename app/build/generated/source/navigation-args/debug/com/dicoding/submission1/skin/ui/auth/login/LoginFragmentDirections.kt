package com.dicoding.submission1.skin.ui.auth.login

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dicoding.submission1.skin.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_mainActivity)

    public fun actionLoginFragmentToSignUpFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_signUpFragment)
  }
}
