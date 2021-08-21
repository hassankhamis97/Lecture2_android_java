package com.hk.lecture2_view_binding_view_model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.hk.lecture2_view_binding_view_model.databinding.ActivityMainBinding;
import com.hk.lecture2_view_binding_view_model.model.User;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initObservers();
        initListeners();
    }

    private void initListeners() {
        binding.okBtn.setOnClickListener(v -> {
            mainViewModel.setUser(binding.edtName.getText().toString(),
                    binding.edtEmail.getText().toString(),
                    binding.edtAge.getText().toString());
        });
    }

    private void initObservers() {
        mainViewModel.userMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setUser(user);
            }
        });

        mainViewModel.toastMsg.observe(this, msg -> {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
    }


}