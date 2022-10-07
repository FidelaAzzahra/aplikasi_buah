package com.example.aplikasi_buah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.aplikasi_buah.databinding.ActivityMainBinding;
import com.example.aplikasi_buah.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String keterangan = intent.getStringExtra("keterangan");
            String warna = intent.getStringExtra("warna");
            int imageid = intent.getIntExtra("imageid",R.drawable.apel2);

            binding.nameBuah.setText(name);
            binding.keteranganBuah.setText(keterangan);
            binding.warnaBuah.setText(warna);
            binding.profileImage.setImageResource(imageid);


        }

    }
}