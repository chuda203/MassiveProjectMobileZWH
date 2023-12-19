package com.infinite.massiveprojectmobilezwh.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.login.SplashOptionActivity
import com.infinite.massiveprojectmobilezwh.wallet.WalletListActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileListFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_profile_list, container, false)
    }

    fun updateUsername() {
        val sharedPreferences = requireActivity().applicationContext.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val tvProfil = view?.findViewById<TextView>(R.id.nama)
        val username = sharedPreferences.getString("username", "").toString()
        tvProfil?.text = "$username"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUsername()
        val btn_edit : TextView = view.findViewById(R.id.set_akun)
        val btn_wallet : TextView = view.findViewById(R.id.dompet1)
        val btn_notif : TextView = view.findViewById(R.id.notifikasi2)
        val btn_help : TextView = view.findViewById(R.id.bantuan1)
        val btn_about : TextView = view.findViewById(R.id.tentang_kami1)
        val btnLogout : Button = view.findViewById(R.id.bt_logout)

        btn_edit.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileEditActivity::class.java)
            startActivity(intent)
        }

        btn_wallet.setOnClickListener {
            val intent = Intent(requireActivity(), WalletListActivity::class.java)
            startActivity(intent)
        }

        btn_notif.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileNotifActivity::class.java)
            startActivity(intent)
        }

        btn_help.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileHelpActivity::class.java)
            startActivity(intent)
        }

        btn_about.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileAboutActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val intent = Intent(requireActivity(), SplashOptionActivity::class.java)
            startActivity(intent)
        }


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}