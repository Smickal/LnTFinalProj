package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {
    SharedPreferences sp;
    SharedPreferences spCounter;
    Integer counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;

        v =  inflater.inflate(R.layout.activity_counter_fragment, container, false);
        TextView txtName = v.findViewById(R.id.txt_counterName);
        sp = this.getActivity().getSharedPreferences("information", Context.MODE_PRIVATE);
        String name = sp.getString("namePref", "");
        txtName.setText("Hi, " + name);

        spCounter = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editorCounter = spCounter.edit();


        TextView txtCounter = (TextView) v.findViewById(R.id.txt_counterView);
        Button btnMinus = (Button) v.findViewById(R.id.btn_minus);
        Button btnAdd = (Button) v.findViewById(R.id.btn_add);
        Button btnReset = (Button) v.findViewById(R.id.btn_reset);
        counter = spCounter.getInt("counter", counter);
        txtCounter.setText(Integer.toString(counter));
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                editorCounter.putInt("counter",counter);
                editorCounter.apply();
                txtCounter.setText(Integer.toString(counter));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                editorCounter.putInt("counter",counter);
                editorCounter.apply();
                txtCounter.setText(Integer.toString(counter));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                editorCounter.putInt("counter",counter);
                editorCounter.apply();
                txtCounter.setText(Integer.toString(counter));
            }
        });


        return v;
    }




}