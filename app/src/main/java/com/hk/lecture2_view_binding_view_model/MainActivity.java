package com.hk.lecture2_view_binding_view_model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hk.lecture2_view_binding_view_model.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}