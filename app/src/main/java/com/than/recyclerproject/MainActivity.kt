package com.than.recyclerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.than.recyclerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listContact = arrayListOf(
            Contact(1,"Ale-Ale", "0895326653527"),
            Contact(2,"Bandulan", "0895326653527"),
            Contact(3,"Beng-Beng", "0895326653527"),
            Contact(4,"Granita", "0895326653527")
        )
        //panggil adapter
        val adapter = ContactAdapter(listContact)

        //layout manager
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //layout manager
//        val layoutManager = GridLayoutManager(this, 2)

        //set layout manager pada recycler
        binding.rvMain.layoutManager = layoutManager


        //set adapter pada recyclerView
        binding.rvMain.adapter = adapter
        adapter.submitData(listContact)
        var id = 5
        binding.btnCek.setOnClickListener {
            listContact.add(Contact(id, "${binding.etNama.text}", binding.etNomor.text.toString()))
            id++
            adapter.submitData(listContact)
        }
    }
}