package com.robby.mobile_04_20192;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.robby.mobile_04_20192.adapter.StudentAdapter;
import com.robby.mobile_04_20192.databinding.ActivityMainBinding;
import com.robby.mobile_04_20192.entity.Student;
import com.robby.mobile_04_20192.util.DataHelper;
import com.robby.mobile_04_20192.viewmodel.MainViewModel;

/**
 * @author Robby Tan
 */
public class AnotherMainActivity extends AppCompatActivity implements StudentAdapter.ItemClickListener {

    private ActivityMainBinding binding;
    private StudentAdapter studentAdapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        DividerItemDecoration decoration = new DividerItemDecoration(this, manager.getOrientation());
        binding.rvData.setLayoutManager(manager);
        binding.rvData.addItemDecoration(decoration);
        binding.rvData.setAdapter(getStudentAdapter());

        binding.srLayout.setOnRefreshListener(() -> {
            getAllStudents();
            binding.srLayout.setRefreshing(false);
        });

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        getAllStudents();
    }

    private StudentAdapter getStudentAdapter() {
        if (studentAdapter == null) {
            studentAdapter = new StudentAdapter();
            studentAdapter.setClickListener(this);
        }
        return studentAdapter;
    }

    private void getAllStudents() {
        mainViewModel.getAllStudents().observe(this, students -> getStudentAdapter().setStudents(students));
    }

    @Override
    public void itemClicked(Student student) {
        Intent intent = new Intent(AnotherMainActivity.this, DetailActivity.class);
        intent.putExtra(DataHelper.STUDENT_PARCEL, student);
        startActivity(intent);
    }
}
