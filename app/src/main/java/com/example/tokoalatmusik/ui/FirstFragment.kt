package com.example.tokoalatmusik.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokoalatmusik.application.GoodsApp
import com.example.tokoalatmusik.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val goodsViewModel: goodsViewModel by viewModels {
        goodsViewModelFactory((applicationContext as GoodsApp).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GoodsListAdapter { goods ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(goods)
            findNavController().navigate(action)
        }

        binding.datarecyclerView.adapter = adapter
        binding.datarecyclerView.layoutManager = LinearLayoutManager(context)
        goodsViewModel.allgoods.observe(viewLifecycleOwner) { goods ->
            goods.let {
                if (goods.isEmpty()) {
                    binding.emptytextView.visibility = View.VISIBLE
                    binding.Iilustrasionimageview.visibility = View.VISIBLE
                } else {
                    binding.emptytextView.visibility = View.GONE
                    binding.Iilustrasionimageview.visibility = View.GONE
                }
                adapter.submitList(goods)
            }
        }

     binding.addFAB.setOnClickListener {
         val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
         findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}