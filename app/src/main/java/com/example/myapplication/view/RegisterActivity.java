package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.viewModel.RegisterViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.etPhone)
    EditText etPhone;

    RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        setUpObservers();
    }

    @OnClick({R.id.btnRegister})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnRegister:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                viewModel.createUser("Kanwarpreet Singh", "preetkewl@gmail.com", "9501194099", "12345678", "Android", "qwertyuiopoasdfghjkl123456789zxcvbnm");
                break;


            default:
                break;

        }
    }

    private void setUpObservers() {
        viewModel.getRegisterResponseLiveData().observe(this, registerResponse -> {
            Toast.makeText(this, "Yes!", Toast.LENGTH_SHORT).show();


        });
    }

}