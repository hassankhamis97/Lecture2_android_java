package com.hk.lecture2_view_binding_view_model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hk.lecture2_view_binding_view_model.model.User;

public class MainViewModel extends ViewModel {
    MutableLiveData<User> userMutableLiveData;
    public MainViewModel() {
        super();
        Log.d("Lecture2", "MainViewModel: Start View model");
        userMutableLiveData = new MutableLiveData<>();
    }

    public void setData() {
        User user = new User("Hassan", "hassan@gmail.com", 25);
        userMutableLiveData.postValue(user);
    }
}
