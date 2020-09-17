package com.example.hogwarts.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.CharacterListBinding;
import com.example.hogwarts.databinding.HouseListItemssBinding;
import com.example.hogwarts.model.House;

import java.io.Serializable;
import java.util.ArrayList;

public class CharactorAdapter extends RecyclerView.Adapter<CharactorAdapter.HouseViewHolder>{

private Context context;
private ArrayList<String> characterArrayList;
String characterId;
private House house;

public CharactorAdapter(Context context, ArrayList<String> characterArrayList, House house) {
        this.context = context;
        this.characterArrayList= characterArrayList;
        this.house=house;
        }

@NonNull
@Override
public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    CharacterListBinding characterListBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
        , R.layout.character_list,parent,false);

        return new HouseViewHolder(characterListBinding);
        }

@Override
public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {

    characterId=characterArrayList.get(position);
        holder.characterListBinding.textViewName.setText(characterId);

        }

@Override
public int getItemCount() {
        return characterArrayList.size();
        }


public class HouseViewHolder extends RecyclerView.ViewHolder {
    private CharacterListBinding characterListBinding;


    public HouseViewHolder(@NonNull CharacterListBinding characterListBinding) {
        super(characterListBinding.getRoot());
        this.characterListBinding=characterListBinding;

        characterListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position=getAdapterPosition();
                characterId=characterArrayList.get(position);

                if(position!=RecyclerView.NO_POSITION) {
                  Bundle bundle = new Bundle();
                  bundle.putString("studentId",characterId);
                  bundle.putSerializable("house",house);
                    NavController navController= Navigation.findNavController(view);
                    navController.navigate(R.id.action_charactersFragment_to_characterFragment,bundle);
                }


            }
        });


    }
}
}
