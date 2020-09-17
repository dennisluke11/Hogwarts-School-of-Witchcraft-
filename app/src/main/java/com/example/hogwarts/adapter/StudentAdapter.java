package com.example.hogwarts.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.StudentListItemBinding;
import com.example.hogwarts.databinding.StudentListItemssBinding;
import com.example.hogwarts.databinding.StudentListItemssBindingImpl;
import com.example.hogwarts.model.Student;
import com.example.hogwarts.view.StudentActivity;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

private Context context;
private ArrayList<Student> studentArrayList;

public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
        }

@NonNull
@Override
public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    StudentListItemssBinding studentListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
        , R.layout.student_list_itemss,parent,false);

        return new StudentViewHolder(studentListItemBinding);
        }

@Override
public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        Student student=studentArrayList.get(position);
        holder.studentListItemBinding.setStudent(student);

        }

@Override
public int getItemCount() {
        return studentArrayList.size();
        }


public class StudentViewHolder extends RecyclerView.ViewHolder {
    private StudentListItemssBinding studentListItemBinding;


    public StudentViewHolder(@NonNull StudentListItemssBinding studentListItemBinding) {
        super(studentListItemBinding.getRoot());
        this.studentListItemBinding=studentListItemBinding;

        studentListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position=getAdapterPosition();

                if(position!=RecyclerView.NO_POSITION) {

                    Student selectedStudent = studentArrayList.get(position);

                    Intent intent=new Intent(context, StudentActivity.class);
                    intent.putExtra("student", (Parcelable) selectedStudent);
                    context.startActivity(intent);



                }


            }
        });


    }
}
}
