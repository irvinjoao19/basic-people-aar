package com.bcp.sdk.product.peoplecompose.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcp.sdk.product.peoplecompose.presentation.R
import com.bcp.sdk.product.peoplecompose.presentation.databinding.ItemPeopleBinding
import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class PeopleAdapter(private val onClickListener: (people: PeoplePresentation) -> Unit) :
    RecyclerView.Adapter<PeopleAdapter.PreferencesCcmViewHolder>() {

    private var people = mutableListOf<PeoplePresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreferencesCcmViewHolder =
        PreferencesCcmViewHolder(
            ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: PreferencesCcmViewHolder, position: Int) {
        holder.bind(peoplePresentation = people[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: MutableList<PeoplePresentation>) {
        people = list.map { it.copy() } as MutableList<PeoplePresentation>
        notifyDataSetChanged()
    }


    inner class PreferencesCcmViewHolder(private val itemBinding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(peoplePresentation: PeoplePresentation) {

            Picasso.get()
                .load(peoplePresentation.avatar)
                .fit()
                .transform(RoundedCornersTransformation(100, 0))
                .into(itemBinding.ivPeople)

            itemBinding.tvFullName.text = itemBinding.root.context.getString(
                R.string.people_full_name, peoplePresentation.firstName, peoplePresentation.lastName
            )
            itemBinding.tvEmail.text = peoplePresentation.email
            itemBinding.root.setOnClickListener { onClickListener.invoke(peoplePresentation) }
        }
    }

}