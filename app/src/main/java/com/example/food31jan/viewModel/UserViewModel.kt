package com.example.food31jan.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food31jan.model.Users
import com.example.food31jan.repository.UserRepository
import kotlinx.coroutines.*
import retrofit2.Response

class UserViewModel :ViewModel() {

    var users:MutableLiveData<Users> = MutableLiveData()
    var error:MutableLiveData<String> = MutableLiveData()
    var job: Job? =null
    var repository=UserRepository()


    fun getApi(){
        job= CoroutineScope(Dispatchers.IO).launch{
            var response:Response<Users> =repository.getApiUserData()

            withContext(Dispatchers.Main){
            if (response.isSuccessful){
                users.value=response.body()
            }else{
                error.value= response.errorBody().toString()
            }
            }
        }
    }
}