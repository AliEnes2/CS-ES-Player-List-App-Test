package com.alienesyorulmaz.csesporculistesi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alienesyorulmaz.csesporculistesi.databinding.ActivityIntroductionBinding
import com.alienesyorulmaz.csesporculistesi.databinding.ActivityMainBinding

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       // val adapterdanGelenIntent = intent
        //val secilenOyuncu = adapterdanGelenIntent.getSerializableExtra("secilenOyuncu",Esporcu::class.java) yeni hali bazı eski tellerde çalışmaz
        //val secilenOyuncu = adapterdanGelenIntent.getSerializableExtra("secilenOyuncu") as Esporcu

        /*
        binding.imageView.setImageResource(secilenOyuncu.gorsel)
        binding.textViewAd.text = secilenOyuncu.ad
        binding.textViewUlke.text = secilenOyuncu.ulke
        binding.textViewRol.text = secilenOyuncu.rol */

        val secilenOyuncu = MySingleton.secilenEsporcu

        secilenOyuncu?.let {
            binding.imageView.setImageResource(secilenOyuncu.gorsel)
            binding.textViewAd.text = secilenOyuncu.ad
            binding.textViewUlke.text = secilenOyuncu.ulke
            binding.textViewRol.text = secilenOyuncu.rol
        }

    }
}