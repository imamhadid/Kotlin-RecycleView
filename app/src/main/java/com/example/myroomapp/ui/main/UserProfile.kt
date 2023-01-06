package com.example.myroomapp.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myroomapp.R

@Suppress("DEPRECATION")
class UserProfile: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_note)

        openNewTabWindow()

        val actionbar = supportActionBar
        //set back button
        actionbar.run {
            //set actionbar title
            this!!.title = "About Me"
            //set back button
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun openNewTabWindow() {
        val buttonBio = findViewById<Button>(R.id.bio)
        buttonBio.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/imamhadid"))
            startActivity(i)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_buttom)
        return true
    }
}