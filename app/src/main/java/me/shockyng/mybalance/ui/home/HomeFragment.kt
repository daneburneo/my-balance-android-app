package me.shockyng.mybalance.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.shape.ShapeAppearanceModel
import me.shockyng.mybalance.databinding.FragmentHomeBinding
import me.shockyng.mybalance.ui.adapters.HomeItemAdapter
import me.shockyng.mybalance.ui.adapters.TransactionItemAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding!!.imageView.shapeAppearanceModel = ShapeAppearanceModel.builder().setAllCornerSizes(
            ShapeAppearanceModel.PILL).build()
        return _binding!!.root
    }

    override fun onResume() {
        super.onResume()

        initializeData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeData() {
        binding.homeOptionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
            adapter = HomeItemAdapter(viewModel.homeOptions)
        }

        binding.transactionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
            adapter = TransactionItemAdapter(viewModel.homeOptions)
        }
    }
}