package hu.bme.aut.hajfoglalo

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener{
    private lateinit var onTimeSelectedListener: OnTimeSelectedListener


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is OnTimeSelectedListener){
            throw RuntimeException("The activity does not implement the OnDateSelectedListener interface")
        }
        onTimeSelectedListener = context


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)




        return TimePickerDialog(requireContext(), this, hour, minute, true)

    }

    interface OnTimeSelectedListener {
        fun onTimeSelected(hour: Int, minute: Int)
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        onTimeSelectedListener.onTimeSelected(hour, minute)
    }


}
