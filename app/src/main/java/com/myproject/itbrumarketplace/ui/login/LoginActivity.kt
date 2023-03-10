package com.myproject.itbrumarketplace.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.myproject.itbrumarketplace.R
import com.myproject.itbrumarketplace.databinding.ActivityLoginBinding
import com.myproject.itbrumarketplace.databinding.FragmentDashboardBinding
import com.myproject.itbrumarketplace.ui.util.Prefs

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val s = Prefs(this)
        if (s.getIsLogin()) {
            binding.tvStatus.text = "SUDAH LOGIN"
        } else binding.tvStatus.text = "BELUM LOGIN"

        binding.btnLogin.setOnClickListener {
            s.setIsLogin(true)
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            s.setIsLogin(false)
            onBackPressed()
        }

        Log.d("TAG", "PESAN SINGKAT")

    }
}