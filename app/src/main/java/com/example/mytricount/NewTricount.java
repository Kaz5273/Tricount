package com.example.mytricount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mytricount.Models.Tricount;
import com.example.mytricount.databinding.ActivityMainBinding;
import com.example.mytricount.databinding.ActivityNewTricountBinding;

public class NewTricount extends AppCompatActivity {
    private ActivityNewTricountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tricount);
        binding= ActivityNewTricountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tricount unTricount = new Tricount(binding.textTitre.getText().toString(), binding.textDescription.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newTricount", unTricount);
                setResult(1, resultIntent);
                NewTricount.super.onBackPressed();

            }
        });


    }
}