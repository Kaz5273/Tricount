package com.example.mytricount;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mytricount.R;
import com.example.mytricount.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import com.example.mytricount.Adapters.RecyclerViewAdapter;
import com.example.mytricount.Models.Tricount;


public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
    private ActivityMainBinding binding;
    private List<Tricount> dataTricounts;
    private ActivityResultLauncher<Intent> activityResutlLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == 1){
                Intent resultIntent = result.getData();

                if(resultIntent != null){
                    Tricount monTricount = (Tricount) resultIntent.getSerializableExtra("newTricount");
                    dataTricounts.add(monTricount);
                    adapter.notifyDataSetChanged();
                }
            }

        }
});


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(getApplicationContext(), NewTricount.class);
                activityResutlLauncher.launch(myintent);
            }
        });


        binding.rvTricount.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvTricount.setLayoutManager(layoutManager);
        binding.rvTricount.setFocusable(false);

        dataTricounts = new ArrayList<Tricount>();
        adapter = new RecyclerViewAdapter(dataTricounts);
        binding.rvTricount.setAdapter(adapter);



    }
}