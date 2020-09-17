package com.example.hogwarts.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.HouseListItemssBinding;
import com.example.hogwarts.databinding.StudentListItemssBinding;
import com.example.hogwarts.model.House;
import com.example.hogwarts.model.Student;
import com.example.hogwarts.view.StudentActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder>{

private Context context;
private ArrayList<House> houseArrayList;

public HouseAdapter(Context context, ArrayList<House> houseArrayList) {
        this.context = context;
        this.houseArrayList= houseArrayList;
        }

@NonNull
@Override
public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    HouseListItemssBinding houseListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
        , R.layout.house_list_itemss,parent,false);

        return new HouseViewHolder(houseListItemBinding);
        }

@Override
public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {

        House house=houseArrayList.get(position);
        holder.houseListItemBinding.setHouse(house);

        }

@Override
public int getItemCount() {
        return houseArrayList.size();
        }


public class HouseViewHolder extends RecyclerView.ViewHolder {
    private HouseListItemssBinding houseListItemBinding;


    public HouseViewHolder(@NonNull HouseListItemssBinding houseListItemBinding) {
        super(houseListItemBinding.getRoot());
        this.houseListItemBinding=houseListItemBinding;

        houseListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position=getAdapterPosition();

                if(position!=RecyclerView.NO_POSITION) {

                    House selectedHouse = houseArrayList.get(position);

//                    Intent intent=new Intent(context, StudentActivity.class);
//                    intent.putExtra("house", (Parcelable) selectedHouse);
//                    context.startActivity(intent);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("selectedHouse", (Serializable) selectedHouse);
                    NavController navController= Navigation.findNavController(view);
                   // navController.navigate(R.id.action_houseFragment_to_houseDetailsFragment2,bundle);
                    navController.navigate(R.id.action_houseFragment_to_houseDetailsFragment2,bundle);

                }


            }
        });


    }
}
}
