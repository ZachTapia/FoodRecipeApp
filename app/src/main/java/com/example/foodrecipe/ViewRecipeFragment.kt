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
import com.example.foodrecipe.databinding.FragmentViewRecipeBinding
import com.firebase.ui.auth.AuthUI

/**
 * A simple [Fragment] subclass.
 */
class ViewRecipeFragment : Fragment() {

    private lateinit var binding: FragmentViewRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_recipe, container, false)

        return binding.root
    }
}