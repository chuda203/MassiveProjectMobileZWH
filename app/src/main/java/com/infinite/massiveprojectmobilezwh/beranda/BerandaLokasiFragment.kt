package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
//import com.infinite.massiveprojectmobilezwh.Manifest
import android.Manifest
import android.location.Geocoder
import android.net.Uri
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
//import android.location.LocationRequest
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.databinding.ActivityMainBinding
import com.infinite.massiveprojectmobilezwh.databinding.FragmentBerandaLokasiBinding
import com.infinite.massiveprojectmobilezwh.dompet.BerandaDompetActivity
import com.infinite.massiveprojectmobilezwh.dompet.BerandaTukarActivity
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import java.io.IOException
import java.util.Locale
import android.content.IntentSender
import android.util.Log
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaLokasiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaLokasiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentBerandaLokasiBinding
    lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

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
        binding = FragmentBerandaLokasiBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

//        return inflater.inflate(R.layout.fragment_beranda_lokasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnConfrim : Button = binding.root.findViewById(R.id.bt_confirmation)
        // Intent ke Capture Sampah
        btnConfrim.setOnClickListener {
            Intent(requireActivity(), BerandaCameraActivity::class.java).also {
                startActivity(it)
            }
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        binding.btGet.setOnClickListener {
            // cek self permission
            checkLocationPermission()
        }

    }

    private fun checkLocationPermission() {
        if(ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
            ){
            // kalo izin lokasi sudah di hidupkan
            checkGPS()

        }

        else{
            //kalo izin lokasi belum dhidupkan
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)

        }

    }

    private fun checkGPS() {
        locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 2000

        val builder = LocationSettingsRequest.Builder()
            .addAllLocationRequests(listOf(locationRequest))

        builder.setAlwaysShow(true)

        val result = LocationServices.getSettingsClient(
            requireActivity().applicationContext
        )

            .checkLocationSettings(builder.build())

        result.addOnCompleteListener { task ->

            try {
                // kalo GPS udah on
                val response = task.getResult(
                    ApiException::class.java
                )

                getUserLocation()

            } catch (e : ApiException ){
                // kalo GPS masih off
                e.printStackTrace()

                when(e.statusCode){
                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> try {
                        // buat request GPS on
                        val resolveApiException = e as ResolvableApiException
                        resolveApiException.startResolutionForResult(requireActivity(), 200)

                    }catch (sendIntentException : IntentSender.SendIntentException){
                        }
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE ->{
                        // kalo settingan GPS gak ada
                        Log.e("Error", "Gak ada settingan GPS")


                    }

                }

            }


        }

    }

    private fun getUserLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->

            val location = task.getResult()

            if(location != null){
                try {
                    val geocoder  = Geocoder(requireContext(), Locale.getDefault())
                    val address = geocoder.getFromLocation(location.latitude,location.longitude, 1)
                    val lat = location.latitude
                    val long = location.longitude

                    if (address != null && address.isNotEmpty()){
                        // buat nampilin alamat
                        val address_line = address[0].getAddressLine(0)
                        binding.tvMapsDetail.setText(address_line)

                        val address_location = address[0].getAddressLine(0)

                        openLocation(lat.toString(), long.toString())

                    }

                }catch (e: IOException){

                }

            }


        }


    }

    private fun openLocation(lat: String, long: String) {
        // buka lokasi di gmaps
        binding.btCheck.setOnClickListener {
            if(!binding.tvMapsDetail.text.isEmpty()){
                // kalo dapet lokasi nya
                val location = "$lat, $long"
                val mapUrl = "https://www.google.com/maps/search/?api=1&query=$location"
                val uri = Uri.parse(mapUrl)
                val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
                Log.d("URL", "URL Maps: $mapUrl")
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BerandaLokasiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BerandaLokasiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}