package com.yujin.inphoto.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.yujin.inphoto.Base.BaseViewModel
import com.yujin.inphoto.Model.Service.FirebaseService
import com.yujin.inphoto.Model.VO.UserVO


class MemberViewModel : BaseViewModel(){
    private val firebaseService = FirebaseService()
    private val _userVO = MutableLiveData<UserVO?>()
    val userVO: LiveData<UserVO?>
        get() = _userVO

    fun singUp(name:String, email:String, pw:String, success:()->Unit, fail:()->Unit, finally:()->Unit){
        firebaseService.createUser(name, email, pw, success, fail, finally)
    }

    fun singIn(email:String, pw:String, success:()->Unit, fail:()->Unit, finally:()->Unit){
        firebaseService.signIn(email, pw, {
            val currentUser = firebaseService.getCurrentUser()!!
            val curId = currentUser.uid
            val curName = currentUser.displayName ?: ""
            val curEmail = currentUser.email ?: ""
            _userVO.value = UserVO(curId, curName, curEmail)

            success()
        }, fail, finally)
    }
    }
}