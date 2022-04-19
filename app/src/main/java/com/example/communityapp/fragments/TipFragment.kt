package com.example.communityapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.communityapp.R
import com.example.communityapp.contentlist.ContentListActivity
import com.example.communityapp.databinding.FragmentTipBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [TipFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TipFragment : Fragment() {
    // TODO: Rename and change types of parameters
private lateinit var binding : FragmentTipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_tip,container,false)

        binding.category1.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category1")
            startActivity(intent)
        }
        binding.category2.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category2")
            startActivity(intent)
        }

        binding.category3.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category3")
            startActivity(intent)
        }

        binding.category4.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category4")
            startActivity(intent)
        }

        binding.category5.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category5")
            startActivity(intent)
        }
        binding.category6.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category6")
            startActivity(intent)
        }

        binding.category7.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category7")
            startActivity(intent)
        }
        binding.category8.setOnClickListener{
            val intent =Intent(context,ContentListActivity::class.java)
            intent.putExtra("category","category8")
            startActivity(intent)
        }
       binding.hometap.setOnClickListener{
        it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
       }

        binding.bookmarktap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment)
        }

        binding.info.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_myinfo)
        }

        binding.talktap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_talkFragment)
        }
        return binding.root
    }

}