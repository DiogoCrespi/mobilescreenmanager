package com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ScreenManager.mobilescreenmanager.R

class FullScreenCardViewPagerAdapter : RecyclerView.Adapter<FullScreenCardViewPagerAdapter.CardViewHolder>() {

    private val pages = listOf(
        R.layout.item_card,             // Página 1 - Configuração de rotação
        R.layout.item_card_loading,     // Página 2 - Tela cheia
        R.layout.item_card,             // Página 3 - Manter tela ligada
        R.layout.item_card_loading      // Página 4 - Mudar resolução
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // A implementação específica de cada página será adicionada posteriormente
    }

    override fun getItemCount(): Int = pages.size

    override fun getItemViewType(position: Int): Int = pages[position]

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
