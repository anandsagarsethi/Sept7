package com.anand.sept7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //list, recyclerview, fragments, Services, Notification, Libraries, Networking, complex layouts, maps,  Android Jetpack

    override fun onResume() {

        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {

        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LinearLayout, FrameLayout, RelativeLayout, CoordinatorLayout, COnstraintLayout, --> TbalehLayout, GridLayout

        iamgeView.setImageResource(R.drawable.landscape)

        populateChips()

        swtch.setOnCheckedChangeListener { _, isChecked ->

            val message = if (isChecked) {
                "Switch is ON"
            } else {
                "Switch is off"
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        }

        //single selection
        chipGroup.setOnCheckedChangeListener { chipGroup, i ->



        }

        btn.setOnClickListener {

            Toast.makeText(this, multipleChecked().toString(), Toast.LENGTH_SHORT).show()

        }

        val button = Button(this)
        button.text = "Gaurav"

        root.addView(button)

    }

    private fun multipleChecked(): List<String> {

        val list = mutableListOf<String>()

        for (index in 0 until chipGroup.childCount) {
            val chip = chipGroup.getChildAt(index) as Chip
            if (chip.isChecked) {
                list.add(chip.id.toString())
            } else {
                list.remove(chip.id.toString())
            }
        }

        return list

    }

    private fun populateChips() {

        for (i in 0..10) {
            val chip = Chip(this)
            chip.tag = "$i"
            chip.id = View.generateViewId()
            chip.text = "Chip $i"
            chip.isCheckable = true
            chipGroup.addView(chip)
            chip.setOnClickListener {
               // Toast.makeText(this, chip.id.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(this, multipleChecked().toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

}
