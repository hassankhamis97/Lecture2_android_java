package com.hk.lecture2_view_binding_view_model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hk.lecture2_view_binding_view_model.model.User;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> toastMsg = new MutableLiveData<>();

    MutableLiveData<User> userMutableLiveData;
    private User user;
    private String successMessage = "Successful entry";
    private String errorMessage = "User data not valid";


    public MainViewModel() {
        super();
        Log.d("Lecture2", "MainViewModel: Start View model");
        userMutableLiveData = new MutableLiveData<>();
        user = new User("", "", 0);
    }

    public void setUser(String name, String email, String age) {
        user.setName(name);
        user.setEmail(email);
        if (!age.isEmpty()) {
            user.setAge(Integer.parseInt(age));
        } else {
            user.setAge(0);
        }
        if (isValidEntry()) {
            userMutableLiveData.setValue(user);
            toastMsg.setValue(successMessage);
        } else {
            toastMsg.setValue(errorMessage);
        }
    }

    private boolean isValidEntry() {
        return !TextUtils.isEmpty(user.getName()) &&
                !TextUtils.isEmpty(user.getEmail()) &&
                user.getAge() > 0 &&
                Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches();
    }

}
