package com.example.hogwarts.view;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hogwarts.R;
import com.example.hogwarts.adapter.CharactorAdapter;
import com.example.hogwarts.adapter.HouseAdapter;
import com.example.hogwarts.databinding.FragmentCharactersBinding;
import com.example.hogwarts.model.House;
import com.example.hogwarts.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class CharactersFragment extends Fragment {

    private ArrayList<String> characterList;
    private RecyclerView recyclerView;
    private House house;
    private ArrayList<String>listCharacters;
    private CharactorAdapter charactorAdapter;
    FragmentCharactersBinding fragmentCharactersBinding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_characters, container, false);

        fragmentCharactersBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_characters, container, false);
        View view = fragmentCharactersBinding.getRoot();
        // ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        Bundle args = getArguments();
        characterList= args.getStringArrayList("characterList");
        house= (House) args.getSerializable("house");
        showOnRecyclerView();
        fragmentCharactersBinding.clickCharacter.setText("House of "+house.getName()+"  students based on their Identifications");
        return view;

    }

    private void showOnRecyclerView() {

        recyclerView = fragmentCharactersBinding.rvCharater;
        charactorAdapter= new CharactorAdapter(getContext(), characterList,house);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {


            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));


        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(charactorAdapter);
        charactorAdapter.notifyDataSetChanged();

    }
}
