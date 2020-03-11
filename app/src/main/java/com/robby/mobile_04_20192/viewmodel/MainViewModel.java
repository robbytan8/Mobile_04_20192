package com.robby.mobile_04_20192.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.robby.mobile_04_20192.dao.StudentRepository;
import com.robby.mobile_04_20192.entity.Student;

import java.util.List;

/**
 * @author Robby Tan
 */
public class MainViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application.getApplicationContext());
    }

    public LiveData<List<Student>> getAllStudents() {
        return studentRepository.getMutableLiveData();
    }
}
