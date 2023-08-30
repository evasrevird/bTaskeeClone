package com.example.btaskee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.btaskee.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeBtkFragment());

        binding.bottomNavigationMenu.setOnItemSelectedListener(item -> {



            if (item.getItemId() == R.id.homebtk){
                replaceFragment(new HomeBtkFragment());
            } else if (item.getItemId() == R.id.activitybtk) {
                replaceFragment(new ActivityBtkFragment());
            } else if (item.getItemId() == R.id.messagebtk) {
                replaceFragment(new MessageBtkFragment());
            } else if (item.getItemId() == R.id.accountbtk) {
                replaceFragment(new AccountBtkFragment());
            }


            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}