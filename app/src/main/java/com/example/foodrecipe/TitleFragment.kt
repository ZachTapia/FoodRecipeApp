package com.example.foodrecipe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.foodrecipe.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)


        // On click listeners
        binding.toFindRecipeButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToFindRecipeFragment())
        }

        return binding.root
    }


}
