package com.robby.mobile_04_20192.dao;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.robby.mobile_04_20192.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Robby Tan
 */
public class StudentRepository {

    private MutableLiveData<List<Student>> mutableLiveData = new MutableLiveData<>();
    private Context context;

    public StudentRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Student>> getMutableLiveData() {
        try {
            InputStream inputStream = context.getAssets().open("students.json");
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            Gson gson = new Gson();
            Student[] studentsArr = gson.fromJson(reader, Student[].class);
            ArrayList<Student> students = new ArrayList<>(Arrays.asList(studentsArr));
            mutableLiveData.setValue(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mutableLiveData;
    }
}
