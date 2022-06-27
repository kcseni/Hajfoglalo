package hu.bme.aut.hajfoglalo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.hajfoglalo.data.*
import hu.bme.aut.hajfoglalo.databinding.ActivityHairLengthBinding
import hu.bme.aut.hajfoglalo.databinding.ActivityHairLengthBinding.inflate


class HairLengthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHairLengthBinding
    private lateinit var appViewModel: AppointmentInfoViewModel
    private lateinit var serviceViewModel: ServiceItemViewModel
    private lateinit var priceViewModel: PriceViewModel


    //private lateinit var database : ServiceItemDatabase
    companion object {
        const val TYPE_SHORT = 0.5
        const val TYPE_MIDIUM = 0.75
        const val TYPE_LONG = 1.0
    }
    var length = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_Hajfoglalo)
        super.onCreate(savedInstanceState)
        binding = ActivityHairLengthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appViewModel= ViewModelProvider(this).get(AppointmentInfoViewModel::class.java)
        serviceViewModel = ViewModelProvider(this).get(ServiceItemViewModel::class.java)
        priceViewModel = ViewModelProvider(this).get(PriceViewModel::class.java)

        appViewModel.deleteAllAppointment()
        serviceViewModel.deleteAllServiceItem()
        priceViewModel.deleteAllPrice()


        binding.btnLong.setOnClickListener{

                val intent = Intent(this, HairServicesActivity::class.java)
                intent.putExtra(HairServicesActivity.KEY_HAIRLENGTH_TYPE, TYPE_LONG)
                startActivity(intent)

        }

        binding.btnMidium.setOnClickListener{

                val intent = Intent(this, HairServicesActivity::class.java)
                intent.putExtra(HairServicesActivity.KEY_HAIRLENGTH_TYPE, TYPE_MIDIUM)
                startActivity(intent)

        }

        binding.btnShort.setOnClickListener{

                val intent = Intent(this, HairServicesActivity::class.java)
                intent.putExtra(HairServicesActivity.KEY_HAIRLENGTH_TYPE, TYPE_SHORT)
                startActivity(intent)

        }

        binding.btnContacts.setOnClickListener{

            startActivity(Intent(this, Contacts::class.java))
        }

        binding.btnAppointment.setOnClickListener{
            /*if(appViewModel.getAllData.value.isNullOrEmpty()){
                Toast.makeText(this, "Még nincs időpontod.", Toast.LENGTH_LONG).show()
            }else {
                startActivity(Intent(this, SavedAppointments::class.java))
            }*/
        }



    }

    /*override fun onResume() {
        super.onResume()
        appViewModel= ViewModelProvider(this).get(AppointmentInfoViewModel::class.java)
        serviceViewModel = ViewModelProvider(this).get(ServiceItemViewModel::class.java)
        priceViewModel = ViewModelProvider(this).get(PriceViewModel::class.java)

        appViewModel.deleteAllAppointment()
        serviceViewModel.deleteAllServiceItem()
        priceViewModel.deleteAllPrice()
    }*/






}