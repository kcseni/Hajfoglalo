package hu.bme.aut.hajfoglalo




import android.app.Activity
import android.app.ProgressDialog.show
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import hu.bme.aut.hajfoglalo.data.*

import hu.bme.aut.hajfoglalo.databinding.ActivityAppointmentBinding
import java.util.jar.Manifest


class AppointmentActivity : AppCompatActivity(), DatePickerDialogFragment.OnDateSelectedListener, TimePickerDialogFragment.OnTimeSelectedListener {



    companion object{
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2

    }

    private lateinit var binding: ActivityAppointmentBinding

    private lateinit var mviewModel:ServiceItemViewModel
    private lateinit var appViewModel: AppointmentInfoViewModel
    private lateinit var priceViewModel:PriceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mviewModel= ViewModelProvider(this).get(ServiceItemViewModel::class.java)
        appViewModel=  ViewModelProvider(this).get(AppointmentInfoViewModel::class.java)
        priceViewModel=  ViewModelProvider(this).get(PriceViewModel::class.java)

        /*mviewModel.getAllData.observe(this, Observer{services ->
            Toast.makeText(this, services[0].name , Toast.LENGTH_LONG).show()
        })*/

        //database = ServiceItemDatabase.getDatabase(applicationContext)
        //Toast.makeText(this, database.serviceItemDao().getNames(0), Toast.LENGTH_LONG).show()

        //binding.tvidopont.text = database.shoppingItemDao().getNames(0)
        //binding.tvidopont2.text=sum.toString()


        binding.btnSave.setOnClickListener {
            when {
                binding.etEmailAddress.text.toString().isEmpty() -> {
                    binding.etEmailAddress.requestFocus()
                    binding.etEmailAddress.error = "Kérlek add meg az email-címed!"
                }
                binding.etNev.text.toString().isEmpty() -> {
                    binding.etNev.requestFocus()
                    binding.etNev.error = "Kérlek add meg a neved!"
                }
                binding.etPhoneNumber.text.toString().isEmpty() -> {
                    binding.etPhoneNumber.requestFocus()
                    binding.etPhoneNumber.error = "Kérlek add meg a telefonszámod!"
                }
                else -> {


                    val datetime = binding.tvdatum.text.toString() + binding.tvido.text.toString()
                    val item =
                            AppointmentInfo(0, binding.etNev.text.toString(), binding.etEmailAddress.text.toString(),
                                binding.etPhoneNumber.text.toString(), datetime)



                        appViewModel.addAppointment(item)

                    val intent = Intent(this, SavedAppointments::class.java)

                    startActivity(intent)

                }
            }
        }

        binding.btnDatetime.setOnClickListener {
           DatePickerDialogFragment().show(supportFragmentManager, "DATE_TAG")

        }

        binding.btnCamera.setOnClickListener{
            if(ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED){

                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
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
        if(requestCode== CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }else{

                Toast.makeText(this, "Nem adtál engedélyt", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            if(requestCode== CAMERA_REQUEST_CODE){
                val thumbNail: Bitmap = data!!.extras!!.get("data") as Bitmap
                binding.ivCamera.setImageBitmap(thumbNail)

            }
        }
    }

    override fun onDateSelected(year: Int, month: Int, day: Int) {
        TimePickerDialogFragment().show(supportFragmentManager, "TIME_TAG");
        binding.tvdatum.text = "$year-$month-$day "
    }

    override fun onTimeSelected(hour: Int, minute: Int) {
        binding.tvido.text = "$hour:$minute"
    }


}