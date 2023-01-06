package com.example.myroomapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomapp.R
import com.example.myroomapp.database.ClassList

@Suppress("DEPRECATION")
class ListMahasiswa: AppCompatActivity() {

    private var classList: MutableList<ClassList> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val list = findViewById<RecyclerView>(R.id.list_siswa)

        initData()

        list.layoutManager = LinearLayoutManager(this)

        list.adapter = ClassAdaptor(this, classList) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }

        val actionbar = supportActionBar
        //set back button
        actionbar.run {
            //set actionbar title
            this!!.title = "List Manusia Di Kelas"
            //set back button
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private  fun initData() {
        val name = resources.getStringArray(R.array.name)
        val nim = resources.getStringArray(R.array.nim)
        val image = resources.obtainTypedArray(R.array.image)

        classList.clear()

        for (i in name.indices) {
            classList.add(
                ClassList(name[i], nim[i], image.getResourceId(i,0))
            )
        }
        image.recycle()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_buttom)
        return true
    }

}