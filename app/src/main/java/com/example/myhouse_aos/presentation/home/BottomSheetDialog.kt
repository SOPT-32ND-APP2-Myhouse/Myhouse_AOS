package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.LayoutBottomSheetBinding
import com.example.myhouse_aos.presentation.content.ContentViewModel
import com.example.myhouse_aos.util.snackbar.SuccessSnackBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog() : BottomSheetDialogFragment() {
    lateinit var binding: LayoutBottomSheetBinding
    private lateinit var rootView: View
    private var imageUrl: String? = null
    lateinit var viewModel: ContentViewModel

    companion object {
        fun newInstance(
            imageUrl: String,
            contentViewModel: ContentViewModel
        ): com.example.myhouse_aos.presentation.home.BottomSheetDialog { // 반환 타입 수정
            val args = Bundle().apply {
                putString("image_url", imageUrl)
            }
            val fragment = BottomSheetDialog()
            fragment.viewModel = contentViewModel
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        rootView = requireActivity().window.decorView.findViewById(android.R.id.content)
        val view = inflater.inflate(R.layout.layout_bottom_sheet, container, false)
        binding = LayoutBottomSheetBinding.bind(view)

        val imageUrl = arguments?.getString("image_url")
        this.imageUrl = imageUrl

        viewModel = ViewModelProvider(requireActivity()).get(ContentViewModel::class.java)

        val behavior = (dialog as BottomSheetDialog).behavior
        behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

        binding.layoutFolderAdd.setOnClickListener {
            Log.e("test log", "isSuccessful")
        }
        binding.layoutFolderInterior.setOnClickListener {
            Log.e("test log", "isSuccessful")
            viewModel.addFolder(2, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.layoutFolderHousewarming.setOnClickListener {
            Log.e("test log", "isSuccessful")
            viewModel.addFolder(3, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.layoutFolderTip.setOnClickListener {
            Log.e("test log", "isSuccessful")
            viewModel.addFolder(4, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.ivBottomClose.setOnClickListener {
            dismiss()
        }

        return view
    }


    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

}