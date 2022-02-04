package com.example.homeworkalldialogs

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_my_dialog.*
import kotlinx.android.synthetic.main.item_custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      btn_alert.setOnClickListener {
          val dialog = AlertDialog.Builder(this)
          dialog.setTitle("Alert dialog title")
          dialog.setCancelable(false)
          dialog.setPositiveButton("Positive "
          ) { dialog, which ->
              Toast.makeText(this@MainActivity, " Salbiy ", Toast.LENGTH_SHORT).show()
          }
          dialog.setNegativeButton("Negative ", object : DialogInterface.OnClickListener {
              override fun onClick(dialog: DialogInterface?, which: Int) {
                  Toast.makeText(this@MainActivity, "Nisbiy ", Toast.LENGTH_SHORT).show()
              }
          })
          dialog.show()
      }

      btn_custom.setOnClickListener {
          val alertDialog = AlertDialog.Builder(this)
          val dialog = alertDialog.create()

          dialog.setTitle("Title Custom dialog")
          val dialogView = layoutInflater.inflate(R.layout.item_custom_dialog, null, false)
          dialog.setView(dialogView)

          dialogView.btn_ok.setOnClickListener {
              Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show()
              dialog.dismiss()
          }

          dialog.show()
      }


        btn_fragment.setOnClickListener {
            val myDialogFragment =MyDialogFragment.newInstance("birNarsa", "ikkinchiNarsa")
            myDialogFragment.show(supportFragmentManager.beginTransaction(), "keylar")
      }

        btn_data.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)

            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "${dayOfMonth}.${month+1}.$year", Toast.LENGTH_SHORT).show()
            }

            datePickerDialog.show()
        }

        btn_time.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                { view, hourOfDay, minute -> Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show() },
                24,
                60,
                true
            )
            timePickerDialog.updateTime(24, 60)
            timePickerDialog.show()
        }

        btn_bottomsheet.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_bottomsheet, null, false))
            bottomSheetDialog.show()
        }

        btn_snackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Click to ok", Snackbar.LENGTH_LONG)

            snackbar.setAction("OK", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Bosildi", Toast.LENGTH_SHORT).show()
                }
            })

            snackbar.show()
        }


    }
}