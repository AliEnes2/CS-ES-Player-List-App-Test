package com.alienesyorulmaz.csesporculistesi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alienesyorulmaz.csesporculistesi.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var esporcuListesi: ArrayList<Esporcu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val xantares = Esporcu("Can Dörtkardeş","Türkiye","Star rifle",R.drawable.xantares)
        val s1mple = Esporcu("Oleksandr Kostyliev","Ukrayna","AWP",R.drawable.simple)
        val karrigan = Esporcu("Finn Andersen","Danimarka","IGL",R.drawable.karrigan)
        val ropz = Esporcu("Robin Kool","Estonya","Support",R.drawable.ropz)

        esporcuListesi = arrayListOf(xantares,ropz,s1mple,karrigan)

        val adapter = EsporcuAdapter(esporcuListesi)
        binding.esporcuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.esporcuRecyclerView.adapter = adapter
    }
}