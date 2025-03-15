package com.ScreenManager.mobilescreenmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ScreenManager.mobilescreenmanager.R
import com.ScreenManager.mobilescreenmanager.databinding.CardInfoBinding
import com.ScreenManager.mobilescreenmanager.databinding.CardOrientationControlBinding

class CardPagerAdapter(
    private val onNextClick: () -> Unit,
    private val onOrientationChange: (Boolean, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val INFO_CARD = 0
        private const val ORIENTATION_CONTROL_CARD = 1
        private const val CARD_COUNT = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            INFO_CARD -> {
                val binding = CardInfoBinding.inflate(inflater, parent, false)
                InfoCardViewHolder(binding, onNextClick)
            }
            ORIENTATION_CONTROL_CARD -> {
                val binding = CardOrientationControlBinding.inflate(inflater, parent, false)
                OrientationControlViewHolder(binding, onOrientationChange)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InfoCardViewHolder -> holder.bind()
            is OrientationControlViewHolder -> holder.bind()
        }
    }

    override fun getItemCount(): Int = CARD_COUNT

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> INFO_CARD
            1 -> ORIENTATION_CONTROL_CARD
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    class InfoCardViewHolder(
        private val binding: CardInfoBinding,
        private val onNextClick: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.nextButton.setOnClickListener { onNextClick() }
        }
    }

    class OrientationControlViewHolder(
        private val binding: CardOrientationControlBinding,
        private val onOrientationChange: (Boolean, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.autoRotateSwitch.setOnCheckedChangeListener { _, isChecked ->
                onOrientationChange(isChecked, binding.orientationRadioGroup.checkedRadioButtonId)
                binding.orientationRadioGroup.isEnabled = !isChecked
            }

            binding.orientationRadioGroup.setOnCheckedChangeListener { _, _ ->
                if (!binding.autoRotateSwitch.isChecked) {
                    onOrientationChange(false, binding.orientationRadioGroup.checkedRadioButtonId)
                }
            }

            binding.applyButton.setOnClickListener {
                onOrientationChange(
                    binding.autoRotateSwitch.isChecked,
                    binding.orientationRadioGroup.checkedRadioButtonId
                )
            }
        }
    }
} 