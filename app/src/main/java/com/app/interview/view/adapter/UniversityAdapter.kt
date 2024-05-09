package com.app.interview.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.interview.R
import com.app.interview.data.model.University
import com.app.interview.databinding.ItemUniversityBinding


class UniversityAdapter(
    private var universities: List<University>,
    private val universityAdapterListener: UniversityAdapterListener
) :
    RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {


    inner class ViewHolder(_binding: ItemUniversityBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        private var binding: ItemUniversityBinding = _binding
        fun bind(university: University, position: Int) {
            binding.data = university
            binding.position = position
            binding.listener = universityAdapterListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemUniversityBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_university, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities[position]
        holder.bind(university, position)
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    fun updateData(universities: List<University>) {
        this.universities = universities
        notifyDataSetChanged()
    }
}

interface UniversityAdapterListener {
    fun onUniversityAdapterClick(university: University, position: Int)
}