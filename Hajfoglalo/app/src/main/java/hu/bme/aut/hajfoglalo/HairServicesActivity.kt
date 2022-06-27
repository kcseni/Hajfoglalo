package hu.bme.aut.hajfoglalo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.hajfoglalo.data.*

import hu.bme.aut.hajfoglalo.databinding.ActivityHairLengthBinding
import hu.bme.aut.hajfoglalo.databinding.ActivityHairServicesBinding
import kotlin.concurrent.thread
import kotlin.math.absoluteValue

class HairServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHairServicesBinding
    private lateinit var mServiceViewModel: ServiceItemViewModel
    private lateinit var priceViewModel: PriceViewModel
    private lateinit var appViewModel: AppointmentInfoViewModel

    var selectedServices: ArrayList<String>? = null
    var sum= 0.0

    companion object {
        const val KEY_HAIRLENGTH_TYPE = "KEY_HAIRLENGTH_TYPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val hairLength = this.intent.getDoubleExtra(KEY_HAIRLENGTH_TYPE, -1.0)
        super.onCreate(savedInstanceState)
        binding = ActivityHairServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mServiceViewModel= ViewModelProvider(this).get(ServiceItemViewModel::class.java)
        priceViewModel = ViewModelProvider(this).get(PriceViewModel::class.java)
        appViewModel = ViewModelProvider(this).get(AppointmentInfoViewModel::class.java)




        /*database = ServiceItemDatabase.getDatabase(applicationContext)
        if(!database.isOpen){
            Toast.makeText(this, "Nyitva", Toast.LENGTH_LONG).show()
        }
            val item = ServiceItem(0, "valami")
            database.serviceItemDao().insert(item)*/





        binding.szaritasSelected.setOnClickListener{

            if(binding.szaritasSelected.isChecked){

                mServiceViewModel.addServiceItem(ServiceItem(0, binding.szaritasSelected.text.toString()))
                selectedServices?.add(binding.szaritasSelected.text.toString())
                sum+= hairLength * 3300
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.szaritasSelected.text.toString())
                selectedServices?.remove(binding.szaritasSelected.text.toString())
                sum-=hairLength * 3300
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }

        binding.vagasSelected.setOnClickListener{

            if(binding.vagasSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.vagasSelected.text.toString()))
                selectedServices?.add(binding.vagasSelected.text.toString())
                sum+= hairLength * 6400
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.vagasSelected.text.toString())
                selectedServices?.remove(binding.vagasSelected.text.toString())
                sum-=hairLength * 6400
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.dauerSelected.setOnClickListener{

            if(binding.dauerSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.dauerSelected.text.toString()))
                selectedServices?.add(binding.dauerSelected.text.toString())
                sum+= hairLength * 10700
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.dauerSelected.text.toString())
                selectedServices?.remove(binding.dauerSelected.text.toString())
                sum-=hairLength * 10700
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.balayageSelected.setOnClickListener{

            if(binding.balayageSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.balayageSelected.text.toString()))
                selectedServices?.add(binding.balayageSelected.text.toString())
                sum+= hairLength * 20200
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.balayageSelected.text.toString())
                selectedServices?.remove(binding.balayageSelected.text.toString())
                sum-=hairLength * 20200
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.babylightsSelected.setOnClickListener{

            if(binding.babylightsSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.babylightsSelected.text.toString()))
                selectedServices?.add(binding.babylightsSelected.text.toString())
                sum+= hairLength * 30000
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.babylightsSelected.text.toString())
                selectedServices?.remove(binding.babylightsSelected.text.toString())
                sum-=hairLength * 30000
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.ombreSelected.setOnClickListener{

            if(binding.ombreSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.ombreSelected.text.toString()))
                selectedServices?.add(binding.ombreSelected.text.toString())
                sum+= hairLength * 18000
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.ombreSelected.text.toString())
                selectedServices?.remove(binding.ombreSelected.text.toString())
                sum-=hairLength * 18000
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.tofestesSelected.setOnClickListener{

            if(binding.tofestesSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.tofestesSelected.text.toString()))
                selectedServices?.add(binding.tofestesSelected.text.toString())
                sum+= hairLength * 9200
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.tofestesSelected.text.toString())
                selectedServices?.remove(binding.tofestesSelected.text.toString())
                sum-=hairLength * 9200
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.egeszSelected.setOnClickListener{

            if(binding.egeszSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.egeszSelected.text.toString()))
                selectedServices?.add(binding.egeszSelected.text.toString())
                sum+= hairLength * 12200
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.egeszSelected.text.toString())
                selectedServices?.remove(binding.egeszSelected.text.toString())
                sum-=hairLength * 12200
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.festekradirSelected.setOnClickListener{

            if(binding.festekradirSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.festekradirSelected.text.toString()))
                selectedServices?.add(binding.festekradirSelected.text.toString())
                sum+= hairLength * 12000
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.festekradirSelected.text.toString())
                selectedServices?.remove(binding.festekradirSelected.text.toString())
                sum-=hairLength * 12000
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.joicoSelected.setOnClickListener{

            if(binding.joicoSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.joicoSelected.text.toString()))
                selectedServices?.add(binding.joicoSelected.text.toString())
                sum+= hairLength * 10600
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.joicoSelected.text.toString())
                selectedServices?.remove(binding.joicoSelected.text.toString())
                sum-=hairLength * 10600
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.hosszabbitasSelected.setOnClickListener{

            if(binding.hosszabbitasSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.hosszabbitasSelected.text.toString()))
                selectedServices?.add(binding.hosszabbitasSelected.text.toString())
                sum+= hairLength * 6200
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.hosszabbitasSelected.text.toString())
                selectedServices?.remove(binding.hosszabbitasSelected.text.toString())
                sum-=hairLength * 6200
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.frufruSelected.setOnClickListener{

            if(binding.frufruSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.frufruSelected.text.toString()))
                selectedServices?.add(binding.frufruSelected.text.toString())
                sum+= hairLength * 1000
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.frufruSelected.text.toString())
                selectedServices?.remove(binding.frufruSelected.text.toString())
                sum-=hairLength * 1000
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }


        binding.keratinSelected.setOnClickListener{

            if(binding.keratinSelected.isChecked){
                mServiceViewModel.addServiceItem(ServiceItem(0, binding.keratinSelected.text.toString()))
                selectedServices?.add(binding.keratinSelected.text.toString())
                sum+= hairLength * 10600
                binding.sum.text=sum.toInt().toString() + "Ft"

            }
            else{
                mServiceViewModel.deletebyName(binding.keratinSelected.text.toString())
                selectedServices?.remove(binding.keratinSelected.text.toString())
                sum-=hairLength * 10600
                binding.sum.text=sum.toInt().toString() + "Ft"
            }
        }

        binding.btnFoglalas.setOnClickListener{

            if(sum==0.0){
                Toast.makeText(this, "Legalább egy szolgáltatást válassz!", Toast.LENGTH_LONG).show()
            }else {
                var l = 0
                /*for( i in selectedServices!!){
                    var item = ServiceItem(id = null, i.toString())
                    database.shoppingItemDao().insert(item)
                    l++
                }*/
                //insertToDatabase()

                priceViewModel.addPrice(Price(0,binding.sum.text.toString()))

                val intent = Intent(this, AppointmentActivity::class.java)
                //intent.putExtra(AppointmentActivity.KEY_SERVICES_LIST, selectedServices)
                //intent.putExtra(AppointmentActivity.KEY_SUM, sum)
                startActivity(intent)
            }
        }



    }


   /* private fun insertToDatabase(){
        for( i in selectedServices!!) {
            var item = ServiceItem(0, i.toString())
            mServiceViewModel.addServiceItem(item)

        }


    }*/




}