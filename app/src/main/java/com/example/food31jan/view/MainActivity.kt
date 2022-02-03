package com.example.food31jan.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food31jan.R
import com.example.food31jan.adapter.UserAdapter
import com.example.food31jan.model.Users
import com.example.food31jan.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: UserViewModel
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)


        viewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.users.observe(this, Observer<Users> {
            var userdata=it.data
            userAdapter= UserAdapter(userdata)
            recyclerView.adapter=userAdapter
            userAdapter.notifyDataSetChanged()
            //userAdapter.getUserList(it)
        })

        viewModel.getApi()

        viewModel.error.observe(this, Observer {
            Toast.makeText(this,"Error occured",Toast.LENGTH_SHORT).show()
        })
    }
}