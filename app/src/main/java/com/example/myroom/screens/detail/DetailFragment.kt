package com.example.myroom.screens.detail

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myroom.APP
import com.example.myroom.R
import com.example.myroom.databinding.FragmentDetailBinding
import com.example.myroom.model.NoteModel
import java.io.Serializable


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.customGetSerializable("note")!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.tvTitleDetail.text = currentNote.title
        binding.tvTitleDescription.text = currentNote.description
        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote)
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

        @Suppress("DEPRECATION")
        inline fun <reified T : Serializable> Bundle.customGetSerializable(key: String): T? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                getSerializable(key, T::class.java)
            } else {
                getSerializable(key) as? T
            }
        }

}