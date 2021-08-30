package com.example.tokyoolympics.util

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blongho.country_data.World
import com.example.tokyoolympics.R
import com.example.tokyoolympics.data.domain.Match
import com.example.tokyoolympics.databinding.ItemMatchBinding
import com.example.tokyoolympics.interfaces.MatchInteractionListener

class MatchAdapter(
    private val list: List<Match>,
    private val listener: MatchInteractionListener
) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMatchBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val layoutItem = R.layout.item_match
        val view = LayoutInflater.from(parent.context).inflate(layoutItem, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.binding.apply {
            with(list[position]) {
                rank.apply {
                    text = rankValue.toString()
                    textSize = if (rankValue in 1..3) 16f else 15f
                    setTextColor(if (rankValue in 1..3) Color.WHITE else Color.BLACK)
                }

                countryIso3.text = iso3
                gold.text = goldMedal.toString()
                silver.text = silverMedal.toString()
                bronze.text = bronzeMedal.toString()
                total.text = totalValue.toString()
                flagImage.setImageResource(World.getFlagOf(iso3))
                flagImage.setOnClickListener { listener.onClickFlag(countryName) }

                rankCard.setCardBackgroundColor(
                    when (rankValue) {
                        1 -> Constant.Color.GOLD
                        2 -> Constant.Color.SILVER
                        3 -> Constant.Color.BRONZE
                        else -> Color.WHITE
                    }
                )
            }
        }
    }

    override fun getItemCount() = list.size
}