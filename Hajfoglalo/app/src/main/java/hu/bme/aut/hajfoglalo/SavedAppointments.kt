package hu.bme.aut.hajfoglalo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.hajfoglalo.data.AppointmentInfoViewModel
import hu.bme.aut.hajfoglalo.data.PriceViewModel
import hu.bme.aut.hajfoglalo.data.ServiceItem
import hu.bme.aut.hajfoglalo.data.ServiceItemViewModel
import hu.bme.aut.hajfoglalo.databinding.ActivityAppointmentBinding
import hu.bme.aut.hajfoglalo.databinding.ActivitySavedAppointmentsBinding

class SavedAppointments : AppCompatActivity() {

    private lateinit var binding : ActivitySavedAppointmentsBinding
    private lateinit var appViewModel: AppointmentInfoViewModel
    private lateinit var serviceViewModel: ServiceItemViewModel
    private lateinit var priceViewModel: PriceViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appViewModel= ViewModelProvider(this).get(AppointmentInfoViewModel::class.java)
        priceViewModel = ViewModelProvider(this).get(PriceViewModel::class.java)
        serviceViewModel = ViewModelProvider(this).get(ServiceItemViewModel::class.java)


            appViewModel.getAllData.observe(this, Observer { appointments ->
                binding.tvNev.text = appointments[appointments.size - 1].name.toString()
                binding.tvEmailAddress.text = appointments[appointments.size - 1].email.toString()
                binding.tvPhoneNumber.text =
                    appointments[appointments.size - 1].phonenumber.toString()
                binding.tvdatumido.text = appointments[appointments.size - 1].datetime.toString()


            }
            )



            serviceViewModel.getAllData.observe(this, Observer { services ->
                var szolgaltatasok = ""
                for (i in services) {
                    szolgaltatasok += i.name.toString() + "\n"
                }
                binding.tvszolgaltatas.text = szolgaltatasok
            })


            priceViewModel.getAllData.observe(this, Observer { prices ->
                binding.tvar.text = prices[prices.size - 1].price.toString()


            })


            binding.btnDelete.setOnClickListener {
                /*appViewModel.deleteAllAppointment()
                priceViewModel.deleteAllPrice()
                serviceViewModel.deleteAllServiceItem()*/

            }










    }
}