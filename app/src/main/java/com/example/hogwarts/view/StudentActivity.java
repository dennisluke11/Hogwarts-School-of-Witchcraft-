package com.example.hogwarts.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.ActivityStudentBinding;
import com.example.hogwarts.model.Student;


public class StudentActivity extends AppCompatActivity {

    private Student student;
    private ActivityStudentBinding activityStudentBinding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityStudentBinding= DataBindingUtil.setContentView(this,R.layout.activity_student);

        Intent intent = getIntent();

        if (intent.hasExtra("movie")) {

            student = getIntent().getParcelableExtra("movie");
            activityStudentBinding.setStudent(student);
            getSupportActionBar().setTitle(student.getName());


        }

    }


}
