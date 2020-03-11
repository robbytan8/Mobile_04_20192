package com.robby.mobile_04_20192;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.robby.mobile_04_20192.adapter.ContactAdapter;
import com.robby.mobile_04_20192.databinding.ActivityMainBinding;

/**
 * @author Robby Tan
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvData.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvData.getContext(),
                layoutManager.getOrientation());
        binding.rvData.addItemDecoration(dividerItemDecoration);
        binding.rvData.setHasFixedSize(true);
        binding.rvData.setAdapter(getContactAdapter());

        binding.srLayout.setOnRefreshListener(() -> {
            getContactAdapter().getNames().add(String.format("%s", "Mr. X"));
            getContactAdapter().notifyDataSetChanged();
            binding.srLayout.setRefreshing(false);
        });
    }

    private ContactAdapter getContactAdapter() {
        if (contactAdapter == null) {
            contactAdapter = new ContactAdapter();
        }
        return contactAdapter;
    }
}
