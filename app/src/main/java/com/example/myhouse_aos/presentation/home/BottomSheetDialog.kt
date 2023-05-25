package com.example.myhouse_aos.presentation.home

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.request.RequestAddFolderDto
import com.example.myhouse_aos.data.model.response.ResponseAddFolderDto
import com.example.myhouse_aos.databinding.LayoutBottomSheetBinding
import com.example.myhouse_aos.util.snackbar.SuccessSnackBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Call
import retrofit2.Response

class BottomSheetDialog : BottomSheetDialogFragment() {
    lateinit var binding: LayoutBottomSheetBinding
    private lateinit var rootView: View
    private var imageUrl: String? = null

    companion object {
        fun newInstance(imageUrl: String): com.example.myhouse_aos.presentation.home.BottomSheetDialog { // 반환 타입 수정
            val args = Bundle().apply {
                putString("image_url", imageUrl)
            }
            val fragment = BottomSheetDialog()
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

        val behavior = (dialog as BottomSheetDialog).behavior
        behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

        binding.ivBottomCell1.setOnClickListener {
            Log.e("test log", "isSuccessful")
            addFolder(1, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.ivBottomCell2.setOnClickListener {
            Log.e("test log", "isSuccessful")
            addFolder(2, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.ivBottomCell3.setOnClickListener {
            Log.e("test log", "isSuccessful")
            addFolder(3, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.ivBottomCell4.setOnClickListener {
            Log.e("test log", "isSuccessful")
            addFolder(4, imageUrl)
            dismiss()
            SuccessSnackBar(rootView).show()
        }
        binding.ivBottomClose.setOnClickListener {
            dismiss()
        }

        return view
    }


    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    val addFolderService = ServicePool.addFolderService
    fun addFolder(id: Int, image_url: String?) {
        addFolderService.add(id, RequestAddFolderDto(image_url))
            .enqueue(object : retrofit2.Callback<ResponseAddFolderDto> {
                override fun onResponse(
                    call: Call<ResponseAddFolderDto>,
                    response: Response<ResponseAddFolderDto>,
                ) {
                    if (response.isSuccessful) {
                        Log.e("test log", "isSuccessful")

                    } else {
                        Log.e("test log", "isnotSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseAddFolderDto>, t: Throwable) {
                    Log.e("test log", "onFailure", t)
                }
            })
    }
}