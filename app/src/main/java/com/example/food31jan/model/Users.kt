package com.example.food31jan.model

data class Users(var meta:Meta,var data:ArrayList<DataUser>)
data class Meta(var pagination:Pagination)
data class Pagination(var total:Int,var page:Int)
data class DataUser(var id:Int,var name:String,var gender:String)
