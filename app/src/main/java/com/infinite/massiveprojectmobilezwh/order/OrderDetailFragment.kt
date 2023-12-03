package com.infinite.massiveprojectmobilezwh.order

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.infinite.massiveprojectmobilezwh.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_detail, container, false)
    }

    // by default value nya false
    private var confirmationClicked = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendengarkan klik pada bt_confirmation
        val btnConfirmation: Button = view.findViewById(R.id.bt_confirmation)
        btnConfirmation.setOnClickListener {
            confirmationClicked = true
            updateButtonState()
        }

        // Mendengarkan klik pada bt_payment
        val btnPayment: Button = view.findViewById(R.id.bt_payment)
        btnPayment.setOnClickListener {
            if (confirmationClicked) {
                // Jika bt_confirmation sudah diklik, function dijalankan (Intent ke order_done)
                startNextActivity()
            }
        }

    }

    private fun updateButtonState() {

        // Ubah tampilan dan status klik pada bt_confirmation
        val btnConfirmation: Button = requireView().findViewById(R.id.bt_confirmation)
        btnConfirmation.apply {
            text = "Diterima"
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green_secondary))
            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            isEnabled = false // bt_confirmation sudah diklik, tidak dapat diklik lagi
        }

        // Ubah tampilan dan status klik pada bt_payment
        val btnPayment: Button = requireView().findViewById(R.id.bt_payment)
        btnPayment.apply {
            text = "Bayar"
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
            setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            isEnabled = true // bt_payment dapat diklik setelah bt_confirmation diklik
        }
    }

    // function buat Intent ke order_done
    private fun startNextActivity() {
         Intent(requireContext(), OrderDoneActivity::class.java).also {
             startActivity(it)
         }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}