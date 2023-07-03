package com.example.tokoalatmusik.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tokoalatmusik.application.GoodsApp
import com.example.tokoalatmusik.databinding.FragmentSecondBinding
import com.example.tokoalatmusik.model.Goods

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val goodsViewModel: goodsViewModel by viewModels {
        goodsViewModelFactory((applicationContext as GoodsApp).repository)
    }
    private val args : SecondFragmentArgs by navArgs()
    private var goods: Goods? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goods = args.goods
        // cek null
        // jika
        if (goods != null) {
            binding.deleteButton.visibility = View.VISIBLE
            binding.saveButton.text =" Ubah "
        }
        val name = binding.nameEditText.text
        val address = binding.addressEditText.text
        val jenis = binding.jenisEditText.text
        binding.saveButton.setOnClickListener {
            val goods = Goods ( 0, name.toString(), address.toString(), jenis.toString())
            goodsViewModel.insert(goods)
            findNavController().popBackStack() // dismis halaman ini
        }
        binding.deleteButton.setOnClickListener {
            goods?.let { goodsViewModel.delete(it) }
            findNavController().popBackStack()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}