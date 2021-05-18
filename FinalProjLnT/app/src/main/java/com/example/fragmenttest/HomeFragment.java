package com.example.fragmenttest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    SharedPreferences sp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootV;
        rootV = inflater.inflate(R.layout.activity_home_fragment, container, false);
        sp = this.getActivity().getSharedPreferences("information", Context.MODE_PRIVATE);

        String string = sp.getString("namePref","");
        TextView txtname = rootV.findViewById(R.id.txt_name);
        txtname.setText(string);



        return rootV;
    }

}