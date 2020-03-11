package com.robby.mobile_04_20192;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.robby.mobile_04_20192.entity.Student;
import com.robby.mobile_04_20192.util.DataHelper;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.robby.mobile_04_20192.databinding.ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        if (getIntent().hasExtra(DataHelper.STUDENT_PARCEL)) {
            Student student = getIntent().getParcelableExtra(DataHelper.STUDENT_PARCEL);
            if (student != null) {
                binding.toolbar.setTitle(student.getId());
                binding.layInside.tvFullName.setText(student.getFullName());
                binding.layInside.tvAddress.setText(student.getAddress());
                binding.layInside.tvDepartment.setText(student.getDepartment());
            }
        }
        setSupportActionBar(binding.toolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
