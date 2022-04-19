package com.example.communityapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.communityapp.R
import com.example.communityapp.databinding.FragmentMyinfoBinding



class MyInfoFragment : Fragment() {
    private lateinit var  binding: FragmentMyinfoBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_myinfo,container,false)

        binding.hometap.setOnClickListener{
            it.findNavController().navigate(R.id.action_myinfo_to_homeFragment)
        }

        binding.bookmarktap.setOnClickListener{
            it.findNavController().navigate(R.id.action_myinfo_to_bookmarkFragment)
        }

        binding.tiptap.setOnClickListener{
            it.findNavController().navigate(R.id.action_myinfo_to_tipFragment)
        }

        binding.talktap.setOnClickListener{
            it.findNavController().navigate(R.id.action_myinfo_to_talkFragment)
        }


        return binding.root
    }


}