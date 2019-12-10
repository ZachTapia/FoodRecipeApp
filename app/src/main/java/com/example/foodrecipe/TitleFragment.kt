package com.example.foodrecipe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.foodrecipe.databinding.FragmentTitleBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.material.internal.NavigationMenu
import kotlinx.android.synthetic.main.fragment_title.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    companion object {
        const val TAG = "LoginFragment"
        const val SIGN_IN_RESULT_CODE = 1001

    }

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentTitleBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)


        // On click listeners
        binding.toFindRecipeButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToFindRecipeFragment())
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()

        binding.loginButton.setOnClickListener { launchSignInFlow() }

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
            ).build(), SIGN_IN_RESULT_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in user.
                Log.i(
                    TAG,
                    "Successfully signed in user " +
                            "${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                // Sign in failed. If response is null the user canceled the sign-in flow using
                // the back button. Otherwise check response.getError().getErrorCode() and handle
                // the error.
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    private fun observeAuthenticationState() {

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    binding.loginButton.visibility = View.INVISIBLE
                    binding.toFindRecipeButton.visibility = View.VISIBLE
                    binding.toFindRecipeButton.setOnClickListener {view : View ->
                        view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToFindRecipeFragment())
                    }
                    binding.addRecipe.visibility = View.VISIBLE
                    binding.addRecipe.setOnClickListener { view: View ->
                        view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToAddRecipeFragment())
                    }

                }
                else -> {
                    binding.loginButton.visibility = View.VISIBLE
                    binding.addRecipe.visibility = View.INVISIBLE
                    binding.toFindRecipeButton.visibility = View.INVISIBLE
                    binding.loginButton.setOnClickListener { launchSignInFlow() }
                }
            }
        })
    }

}
