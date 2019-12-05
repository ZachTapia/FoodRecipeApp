package com.example.foodrecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.foodrecipe.databinding.FragmentSettingBinding
import com.firebase.ui.auth.AuthUI

/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        observeAuthenticationState()

        return binding.root
    }

    private fun observeAuthenticationState() {

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {

                    binding.logoutButton.text = "Logout"
                    binding.logoutButton.setOnClickListener {
                        AuthUI.getInstance().signOut(requireContext())
                    }


                }
                else -> {
                    binding.logoutButton.text = "Login"
                    binding.logoutButton.setOnClickListener {
                        launchSignInFlow()
                    }

                }
            }
        })
    }

    fun launchSignInFlow (){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
        )

        // Create and launch sign-in intent. We listen to the response of this activity with the
        // SIGN_IN_RESULT_CODE code.
        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                providers
            ).build(), TitleFragment.SIGN_IN_RESULT_CODE
        )
    }
}
