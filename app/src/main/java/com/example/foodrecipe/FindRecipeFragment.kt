package com.example.foodrecipe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.foodrecipe.databinding.FragmentFindRecipeBinding

/**
 * A simple [Fragment] subclass.
 */
class FindRecipeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFindRecipeBinding>(inflater, R.layout.fragment_find_recipe, container, false)



        return binding.root
    }


}
