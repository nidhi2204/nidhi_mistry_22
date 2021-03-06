package com.example.prakashjobapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prakashjobapp.R
import com.example.prakashjobapp.models.CompanyData

class CompanyListAdapter(val context :Context, var companyList: ArrayList<CompanyData>) : RecyclerView.Adapter<CompanyListAdapter.MyViewHolder>() {
    private lateinit var mlistener:OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
   
    fun setOnItemClickListener(listener :OnItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val View = LayoutInflater.from(parent.context).inflate(R.layout.companylist, parent, false)
        return MyViewHolder(View,mlistener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val company = companyList[position]
        holder.companyName.text = company.company_name
    }

    override fun getItemCount(): Int {
        return companyList.size
    }
    fun filterList(filteredList: ArrayList<CompanyData>) {
    filteredList.also { it.also { companyList = it } }
    notifyDataSetChanged()
}

    inner class MyViewHolder(itemview: View , listner: OnItemClickListener)  : RecyclerView.ViewHolder(itemview)
      {
        val companyName = itemView.findViewById<TextView>(R.id.compayName)

        init {
            itemview.setOnClickListener{
                listner.onItemClick(adapterPosition)
            }
        }
    }


}

