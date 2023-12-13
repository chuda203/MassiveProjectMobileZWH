package com.infinite.massiveprojectmobilezwh.profil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.beranda.BerandaCameraActivity
import com.infinite.massiveprojectmobilezwh.dompet.BerandaDompetActivity
import com.infinite.massiveprojectmobilezwh.profile.ProfileHelpActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilListFragment : Fragment() {
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
    fun updateUsername() {
        val tvProfil = view?.findViewById<TextView>(R.id.nama)
        val username = arguments?.getString(com.infinite.massiveprojectmobilezwh.profil.ARG_PARAM1)
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

        btn_edit.setOnClickListener {
            val intent = Intent(requireActivity(), ProfilEditActivity::class.java)
            startActivity(intent)
        }

        btn_wallet.setOnClickListener {
            val intent = Intent(requireActivity(), BerandaDompetActivity::class.java)
            startActivity(intent)
        }

        btn_notif.setOnClickListener {
            val intent = Intent(requireActivity(), ProfilNotifActivity::class.java)
            startActivity(intent)
        }

        btn_help.setOnClickListener {
            val intent = Intent(requireActivity(), ProfilBantuanActivity::class.java)
            startActivity(intent)
        }

        btn_about.setOnClickListener {
            val intent = Intent(requireActivity(), ProfilTentangActivity::class.java)
            startActivity(intent)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilePenggunaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}