package com.example.hogwarts.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.adapter.HouseAdapter;
import com.example.hogwarts.databinding.FragmentCharacterDetailBinding;
import com.example.hogwarts.databinding.FragmentHouseBinding;
import com.example.hogwarts.model.House;
import com.example.hogwarts.model.Student;
import com.example.hogwarts.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterFragment extends Fragment {
    private Student theStudent;
    private MainActivityViewModel mainActivityViewModel;
    private FragmentCharacterDetailBinding fragmentCharacterDetailBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCharacterDetailBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_character_detail, container, false);
        View view = fragmentCharacterDetailBinding.getRoot();
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        Bundle arg=getArguments();
        String studentId= arg.getString("studentId");
        getCharacter(studentId);
        return view;
    }


    public void getCharacter( String studentId) {

        mainActivityViewModel.getStudent(studentId).observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                theStudent=student;
                fragmentCharacterDetailBinding.setStudent(theStudent);
            }

        });


    }
















}
