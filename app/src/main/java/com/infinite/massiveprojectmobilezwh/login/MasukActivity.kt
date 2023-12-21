package com.infinite.massiveprojectmobilezwh.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.Retro
import com.infinite.massiveprojectmobilezwh.UserApi
import com.infinite.massiveprojectmobilezwh.UserRequest
import com.infinite.massiveprojectmobilezwh.UserResponse
import com.infinite.massiveprojectmobilezwh.beranda.BerandaListActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MasukActivity : AppCompatActivity() {

    private var isPasswordVisible = false
    private var user: UserResponse? = null
    private var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        // Inisialisasi komponen CheckBox
        val checkBoxRemember : CheckBox = findViewById(R.id.ic_check)

        // Cek status CheckBox dari SharedPreferences
        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
//        val isChecked = sharedPreferences.getBoolean("rememberCheckBox", false)
        checkBoxRemember.isChecked = isChecked

        // Pengaturan OnClickListener untuk checkbox
        checkBoxRemember.setOnCheckedChangeListener { _, isChecked ->
            // Simpan status CheckBox ke SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putBoolean("rememberCheckBox", isChecked)
            editor.apply()
            showToast("Sudah dicheck $isChecked")
        }

        // Pengaturan OnClickListener untuk teks "Daftar"
        val btnRegis = findViewById<TextView>(R.id.tv_to_register)
        btnRegis.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }

        // Mengaktifkan fungsi hide dan unhide password
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        val imageViewToggle = findViewById<ImageView>(R.id.ic_password)
        imageViewToggle.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input teks
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, isPasswordVisible)
        }

        val btnLogin : Button = findViewById(R.id.bt_confirmation)
        btnLogin.setOnClickListener {
            login()
        }
    }

    // Function untuk fitur hide/unhide password
    private fun togglePasswordVisibility(editText: EditText, isVisible: Boolean) {
        if (isVisible) {
            // Jika terlihat, ubah ke tipe teks biasa
            editText.transformationMethod = null
            editText.setSelection(editText.text.length) // Agar kursor tetap di akhir teks
        } else {
            // Jika tidak terlihat, ubah ke tipe password
            editText.transformationMethod = PasswordTransformationMethod()
            editText.setSelection(editText.text.length) // Agar kursor tetap di akhir teks
        }
    }

    fun login() {
        val etEmail: EditText = findViewById(R.id.et_phone)
        val etPassword: EditText = findViewById(R.id.et_password)
        val request = UserRequest()
        request.email = etEmail.text.toString().trim()
        request.password = etPassword.text.toString().trim()

        val retro = Retro().getRetroCLientInstance().create(UserApi::class.java)
//        checkBoxRemember.setOnCheckedChangeListener { _, checked ->
//            isChecked = checked
//        }
        retro.signin(request).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    user = response.body()
                    val accessToken = user?.access_token
                    accessToken?.let { saveBearerTokenToSharedPreferences(it, null, null, null, null, null, isChecked) }
                    accessToken?.let { requestUserData(it) }
                } else {
//                    val errorMessage = user?.message
//                    if (errorMessage?.contains("User not found") == true){
                    if (response.code() == 404){
                        Log.e("Error", " Email belum terdaftar : ${response.code()}")
                        showToast("Email Salah atau belum terdaftar")
                    } else if (response.code() == 422){
                        Log.e("Error", " Sandi salah : ${response.code()}")
                        showToast("Sandi Salah")
                    } else {
                        Log.e("Error", " Unsuccesfull Response : ${response.code()}")
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message ?: "Unknown error")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun requestUserData(bearerToken: String) {
        val retro = Retro().getRetroCLientInstance().create(UserApi::class.java)
        val authorizationHeader = "Bearer $bearerToken"

        retro.user(authorizationHeader).enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    val userProfile = response.body()
                    if (userProfile != null) {
                        val username = userProfile.user?.name
                        val uuid = userProfile.user?.uuid
                        val email = userProfile.user?.email
                        val role = userProfile.user?.role
                        val points = userProfile.user?.points
                        toHome(username)
                        saveBearerTokenToSharedPreferences(bearerToken, username, uuid, email, role, points, isChecked)
                    } else {
                        Log.e("Error", "No Username")
                    }
                } else {
                    Log.e("Error", "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message ?: "Unknown error")
            }
        })
    }

    private fun toHome(username: String?) {
        Log.d("UserToHome", "User: $username")
        val intent = Intent(this, BerandaListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        showToast(isChecked.toString())
        startActivity(intent)
    }
    private fun saveBearerTokenToSharedPreferences(token: String, username: String?, uuid: String?, email: String?, role: String?, points: String?, rememberCheckBox: Boolean) {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("bearerToken", token)
        editor.putString("username", username)
        editor.putString("uuid", uuid)
        editor.putString("email", email)
        editor.putString("role", role)
        editor.putString("points", points)
        editor.apply()
    }
}