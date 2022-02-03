package com.example.food31jan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food31jan.R
import com.example.food31jan.model.DataUser
import com.example.food31jan.model.Users

class UserAdapter(var user:ArrayList<DataUser>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id=itemView.findViewById<TextView>(R.id.tv_id)
        var name=itemView.findViewById<TextView>(R.id.tv_name)
        var gender=itemView.findViewById<TextView>(R.id.tv_gender)

        fun bindviews(dataUser: DataUser){
            id.text=dataUser.id.toString()
            name.text=dataUser.name.toString()
            gender.text=dataUser.gender.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bindviews(user.get(position))
    }

    override fun getItemCount(): Int {
        return user.size
    }

    fun getUserList(users: Users){
        users.meta
        users.data
        notifyDataSetChanged()
    }
}