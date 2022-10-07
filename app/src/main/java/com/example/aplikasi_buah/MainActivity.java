package com.example.aplikasi_buah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.aplikasi_buah.databinding.ActivityMainBinding;
import com.example.aplikasi_buah.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.apel2,R.drawable.anggur2,R.drawable.jeruk2,R.drawable.lemon2,R.drawable.peach2,
                R.drawable.pisang2,R.drawable.semangka2,R.drawable.jambu2,R.drawable.kelapa2};

        String[] name = {"Apel","Anggur","Jeruk","Lemon","Peach","Pisang","Semangka","Jambu","Kelapa"};

        String[] english = {"Apple","Grape","Orange","Lemon","Peach",
                "Banana","Watermelon","Guava","Coconut"};


        String[] keterangan = {"Dapat mencegah kanker, melawan alzheimer, serta\n" +
                            "menstabilkan gula darah.",
                            "Dapat mencegah kanker dan melawan penuaan dini. Awet muda dong.",
                            "Mengandung banyak vitamin C. Bagus untuk obat sariawan",
                            "Mengandung vitamin C. rasanya kecut-keut manis.",
                            "Dapat melembutkan kulit. Cocok untuk ciwi-ciwi.",
                            "Bagus untuk pencernaan. BAB jadi lancar.",
                            "Mencegah terjadinya dehidrasi, mengandung 2 vitamin sekaligus. A dan C.",
                            "Cocok untuk orang yang sedang menderita demam berdaarah / DBD.",
                            "Seger lah pokoknya. Cocok diminum di siang bolong."};

        String[] warna = {"Merah (Red)","Ungu (Purple)","Orange","Kuning (Yellow)","Merah muda (Pink)",
                            "Kuning (Yellow)","Merah dan hijau (Red & green)","Hijau (Green)",
                            "Hijau / cokelat (Green / Chocolate)"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],english[i],keterangan[i],warna[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("keterangan",keterangan[position]);
                i.putExtra("warna",warna[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}