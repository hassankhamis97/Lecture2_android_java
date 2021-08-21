package com.hk.lecture2_view_binding_view_model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.hk.lecture2_view_binding_view_model.databinding.ActivityMainBinding;
import com.hk.lecture2_view_binding_view_model.model.User;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = new User("Hassan", "hassan@gmail.com", 25);
        binding.setUser(user);
    }
}