package com.example.codelock

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.codelock.databinding.FragmentCodeBinding

class CodeFragment : Fragment() {

    private var binding: FragmentCodeBinding? = null
    private val codeViewModel: CodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCodeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.resultado.text = codeViewModel.getCurrentCode()

        binding!!.generateButton.setOnClickListener {
            binding!!.resultado.text = codeViewModel.getGenerateCode()
        }

        binding!!.zero.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(0) }
        binding!!.um.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(1) }
        binding!!.dois.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(2) }
        binding!!.tres.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(3) }
        binding!!.quatro.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(4) }
        binding!!.cinco.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(5) }
        binding!!.seis.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(6) }
        binding!!.sete.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(7) }
        binding!!.oito.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(8) }
        binding!!.nove.setOnClickListener { binding!!.resultado.text = codeViewModel.numberClicked(9) }
        binding!!.c.setOnClickListener {
            binding!!.resultado.text = ""
            codeViewModel.clean()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}