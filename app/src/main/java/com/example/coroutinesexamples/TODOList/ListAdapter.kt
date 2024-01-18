package com.example.coroutinesexamples.TODOList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ItemTolistBinding

class ListAdapter(private val listData: List<ToDoListData>, private val onClick: OnItemClick): RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding : ItemTolistBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_tolist,parent,false)
        return ListViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindData(listData[position])
    }


}

class ListViewHolder(val binding: ItemTolistBinding, val onClick: OnItemClick):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
    override fun onClick(view: View?) {
        view?.let {
            onClick.onItemClick(it,adapterPosition)
        }
    }
    fun bindData(toDoListData: ToDoListData){
       // binding.toDoList = toDoListData
        //binding.isRead = toDoListData.isShow ==1
        binding.root.setOnClickListener(this)
    }

}