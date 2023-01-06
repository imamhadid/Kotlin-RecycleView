package com.example.myroomapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myroomapp.R
import com.example.myroomapp.databinding.ActivityMainBinding
import com.example.myroomapp.helper.ViewModelFactory
import com.example.myroomapp.ui.insert.NoteAddUpdateActivity

@Suppress("DEPRECATION")

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NoteAdapter

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val mainViewModel = obtainViewModel(this@MainActivity)

        mainViewModel.getAllNotes().observe(this
        ) { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        }

        adapter = NoteAdapter()

        binding?.rvNote?.layoutManager = LinearLayoutManager(this)
        binding?.rvNote?.setHasFixedSize(true)
        binding?.rvNote?.adapter = adapter
        binding?.fabAdd?.setOnClickListener{ view ->
            if (view.id == R.id.fab_add){
                val intent = Intent(this, NoteAddUpdateActivity::class.java)
                startActivity(intent)
            }
        }


        binding?.bottomNav?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_user -> {
                    val intent = Intent(this, UserProfile::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_buttom)
                    true
                }

                R.id.menu_ppl -> {
                    val intent = Intent(this, ListMahasiswa::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_buttom)
                    true
                }
                else -> false
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }

    private fun obtainViewModel(fragment: MainActivity): MainViewModel{
        val factory = ViewModelFactory.getInstance(fragment.application)
        return ViewModelProvider(fragment, factory)[MainViewModel::class.java]
    }

}
