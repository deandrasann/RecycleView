package com.example.recycleview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()){
            disaster -> Toast.makeText(this@MainActivity, "You click on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvDisaster.apply{
                adapter = adapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun generateDummy():List<Disaster>{
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural") ,
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural"),
            Disaster(nameDisaster = "Flood", disasterType = "Natural"),
            Disaster(nameDisaster = "Wildfire", disasterType = "Natural"),
            Disaster(nameDisaster = "Hurricane", disasterType = "Natural"),
            Disaster(nameDisaster = "Chemical Spill", disasterType = "Man-made"),
        )
    }
}