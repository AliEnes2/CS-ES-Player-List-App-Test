package com.alienesyorulmaz.csesporculistesi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alienesyorulmaz.csesporculistesi.databinding.ActivityMainBinding
import com.alienesyorulmaz.csesporculistesi.databinding.RecyclerRowBinding

class EsporcuAdapter(val esporcuListesi: ArrayList<Esporcu>): RecyclerView.Adapter<EsporcuAdapter.EsporcuViewHolder>() {

    class EsporcuViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EsporcuViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EsporcuViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return esporcuListesi.size

    }

    override fun onBindViewHolder(holder: EsporcuViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text = esporcuListesi[position].ad

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,IntroductionActivity::class.java)
            MySingleton.secilenEsporcu = esporcuListesi[position]
            //intent.putExtra("secilenOyuncu",esporcuListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }



}