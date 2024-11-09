package com.example.storage

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.storage.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val requestPermeation =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                saveDataToExternalStorage()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPref.initSharedPreference(this)
        /*        binding.buttonSave.setOnClickListener {
                    saveDataToSharedPreference()
                    getDateFromSharedPreference()
                }
                getDateFromSharedPreference()*/
        binding.buttonSave.setOnClickListener {
            getPermeationStorage()
        }
    }

    private fun getPermeationStorage() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            saveDataToExternalStorage()
        } else {
            requestPermeation.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
    }

    private fun saveDataToExternalStorage() {
        // val path = applicationInfo.dataDir // internal storage
        // val path = getExternalFilesDir(null)?.path.toString() // external storage in android data
        val path = Environment.getExternalStorageDirectory().path // External storage
        val fileName = "First.txt"
        val file = File("$path/$fileName")
        file.writeText(binding.inputTextUsername.text.toString())

    }

    private fun getDateFromSharedPreference() {
        binding.outputTextUsername.text = SharedPref.username
    }

    private fun saveDataToSharedPreference() {
        SharedPref.username = binding.inputTextUsername.text.toString()
    }
}