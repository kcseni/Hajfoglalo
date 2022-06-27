package hu.bme.aut.hajfoglalo

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.hajfoglalo.databinding.ActivityContactsBinding
import hu.bme.aut.hajfoglalo.databinding.ActivityHairServicesBinding
import android.content.Intent
import android.net.Uri
import androidx.core.app.ActivityCompat

import android.content.pm.PackageManager
import android.graphics.Bitmap

import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.lang.Exception


class Contacts : AppCompatActivity() {

    private lateinit var binding : ActivityContactsBinding
    companion object{
        private const val CALL_PERMISSION_CODE = 1
        private const val CALL_REQUEST_CODE = 2

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvphone.setOnClickListener {
            if(ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED){

                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + "+36303972333")
                startActivity(callIntent)


            }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    Contacts.CALL_PERMISSION_CODE
                )
            }

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== Contacts.CALL_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + "+36303972333")
                startActivity(callIntent)
            }else{

                Toast.makeText(this, "Nem adtál engedélyt", Toast.LENGTH_LONG).show()
            }
        }
    }











}