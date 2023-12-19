package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.dompet.BerandaDompetActivity
import com.infinite.massiveprojectmobilezwh.dompet.BerandaTukarActivity
import com.infinite.massiveprojectmobilezwh.profil.ProfilListFragment
import com.infinite.massiveprojectmobilezwh.profil.ProfilNotifActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaListFragment : Fragment() {
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
        val sharedPreferences = requireActivity().applicationContext.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val tvProfil = view?.findViewById<TextView>(R.id.tv_profil)
        val username = sharedPreferences.getString("username", "").toString()
        tvProfil?.text = "Halo $username"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUsername()

        // Intent ke fitur pickup
        val btnJemput : CardView = view.findViewById(R.id.cardView_jemput)
        btnJemput.setOnClickListener {
            Intent(requireActivity(), BerandaLokasiActivity::class.java).also {
                startActivity(it)
            }
        }

        // Intent ke fitur reedem
        val btnTukar : CardView = view.findViewById(R.id.cardView_tukar)
        btnTukar.setOnClickListener {
            Intent(requireActivity(), BerandaTukarActivity::class.java).also {
                startActivity(it)
            }
        }

        // Intent ke riwayat transaksi
        val btnHistory : ImageView = view.findViewById(R.id.iv_history)
        btnHistory.setOnClickListener {
            Intent(requireActivity(), BerandaDompetActivity::class.java).also {
                startActivity(it)
            }
        }

        // Intent ke Frame Artikel
        val btnArtikel : TextView = view.findViewById(R.id.tv_subtitle_artikel)
        btnArtikel.setOnClickListener {
            Intent(requireActivity(), BerandaArtikelActivity::class.java).also {
                startActivity(it)
            }
        }

        // Intent ke Frame Notifikasi
        val btnNotif : ImageView =  view.findViewById(R.id.iv_notif)
        btnNotif.setOnClickListener {
            Intent(requireActivity(), ProfilNotifActivity::class.java).also {
                startActivity(it)
            }
        }

        // Intent ke Frame Profil
        val btnProfil : ImageView =  view.findViewById(R.id.iv_profile)
        btnProfil.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfilListFragment())
                .commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BerandaListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BerandaListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}