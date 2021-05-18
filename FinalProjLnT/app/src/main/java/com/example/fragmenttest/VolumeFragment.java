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

public class VolumeFragment extends Fragment {
    SharedPreferences spVolume;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v =  inflater.inflate(R.layout.activity_volume_fragment, container, false);
        TextView txtName = v.findViewById(R.id.txt_volumeName);

        spVolume = this.getActivity().getSharedPreferences("information", Context.MODE_PRIVATE);
        String name = spVolume.getString("namePref", "");
        txtName.setText("Hi, " + name);


        //choose button
        Button blockBtn = v.findViewById(R.id.btn_block);
        Button piramidBtn = v.findViewById(R.id.btn_piramid);
        Button tubeBtn = v.findViewById(R.id.btn_tube);

        //default block
        EditText blockLength = v.findViewById(R.id.edit_BlockPanjang);
        EditText blockWidth = v.findViewById(R.id.edit_BlockLebar);
        EditText blockHeight = v.findViewById(R.id.edit_BlockTinggi);
        Button blockSubmitBtn = v.findViewById(R.id.btn_submitBlock);
        TextView blockHasil = v.findViewById(R.id.txtHasilBlock);
        ImageView blockPict = v.findViewById(R.id.pict_block);

        //pyramid
        EditText piramidLength = v.findViewById(R.id.edit_PiramidPanjang);
        EditText piramidWidth = v.findViewById(R.id.edit_PiramidLebar);
        EditText piramidHeight = v.findViewById(R.id.edit_PiramidTinggi);
        Button piramidSubmitBtn = v.findViewById(R.id.btn_submitPiramid);
        TextView piramidHasil = v.findViewById(R.id.txtHasilPiramid);
        ImageView piramidPict = v.findViewById(R.id.pict_piramid);

        //Tabung
        EditText tubeRadius = v.findViewById(R.id.edit_TubeRadius);
        EditText tubeheight = v.findViewById(R.id.edit_TubeHeight);
        Button tubeSubmitBtn = v.findViewById(R.id.btn_submitTube);
        TextView tubeHasil = v.findViewById(R.id.txtHasilTube);
        ImageView tubePict = v.findViewById(R.id.pict_tube);

        //initial hide
        piramidLength.setVisibility(View.INVISIBLE);
        piramidWidth.setVisibility(View.INVISIBLE);
        piramidHeight.setVisibility(View.INVISIBLE);
        piramidSubmitBtn.setVisibility(View.INVISIBLE);
        piramidHasil.setVisibility(View.INVISIBLE);
        tubeRadius.setVisibility(View.INVISIBLE);
        tubeheight.setVisibility(View.INVISIBLE);
        tubeSubmitBtn.setVisibility(View.INVISIBLE);
        tubeHasil.setVisibility(View.INVISIBLE);
        piramidPict.setVisibility(View.INVISIBLE);
        tubePict.setVisibility(View.INVISIBLE);

        blockSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1, temp2, temp3;
                temp1 = blockLength.getText().toString();
                temp2 = blockWidth.getText().toString();
                temp3 = blockHeight.getText().toString();
                if(temp1.length() != 0 && temp2.length() != 0 && temp3.length() != 0 ){
                    int length, width, height;
                    double sum;
                    length = Integer.parseInt(blockLength.getText().toString());
                    width = Integer.parseInt(blockWidth.getText().toString());
                    height = Integer.parseInt(blockHeight.getText().toString());
                    sum = length*width*height;
                    blockHasil.setText(Double.toString(sum));
                }else{
                    Toast.makeText(v.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        blockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockHasil.setVisibility(View.VISIBLE);
                blockLength.setVisibility(View.VISIBLE);
                blockWidth.setVisibility(View.VISIBLE);
                blockHeight.setVisibility(View.VISIBLE);
                blockSubmitBtn.setVisibility(View.VISIBLE);
                blockPict.setVisibility(View.VISIBLE);

                piramidLength.setVisibility(View.INVISIBLE);
                piramidWidth.setVisibility(View.INVISIBLE);
                piramidHeight.setVisibility(View.INVISIBLE);
                piramidSubmitBtn.setVisibility(View.INVISIBLE);
                piramidHasil.setVisibility(View.INVISIBLE);
                piramidPict.setVisibility(View.INVISIBLE);

                tubeRadius.setVisibility(View.INVISIBLE);
                tubeheight.setVisibility(View.INVISIBLE);
                tubeSubmitBtn.setVisibility(View.INVISIBLE);
                tubeHasil.setVisibility(View.INVISIBLE);
                tubePict.setVisibility(View.INVISIBLE);

                blockSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp1, temp2, temp3;
                        temp1 = blockLength.getText().toString();
                        temp2 = blockWidth.getText().toString();
                        temp3 = blockHeight.getText().toString();
                        if(temp1.length() != 0 && temp2.length() != 0 && temp3.length() != 0 ){
                            int length, width, height;
                            double sum;
                            length = Integer.parseInt(blockLength.getText().toString());
                            width = Integer.parseInt(blockWidth.getText().toString());
                            height = Integer.parseInt(blockHeight.getText().toString());
                            sum = length*width*height;
                            blockHasil.setText(Double.toString(sum));
                        }else{
                            Toast.makeText(v.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        piramidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockHasil.setVisibility(View.INVISIBLE);
                blockLength.setVisibility(View.INVISIBLE);
                blockWidth.setVisibility(View.INVISIBLE);
                blockHeight.setVisibility(View.INVISIBLE);
                blockSubmitBtn.setVisibility(View.INVISIBLE);
                blockPict.setVisibility(View.INVISIBLE);

                piramidLength.setVisibility(View.VISIBLE);
                piramidWidth.setVisibility(View.VISIBLE);
                piramidHeight.setVisibility(View.VISIBLE);
                piramidSubmitBtn.setVisibility(View.VISIBLE);
                piramidHasil.setVisibility(View.VISIBLE);
                piramidPict.setVisibility(View.VISIBLE);

                tubeRadius.setVisibility(View.INVISIBLE);
                tubeheight.setVisibility(View.INVISIBLE);
                tubeSubmitBtn.setVisibility(View.INVISIBLE);
                tubeHasil.setVisibility(View.INVISIBLE);
                tubePict.setVisibility(View.INVISIBLE);

                piramidSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp1, temp2, temp3;
                        temp1 = piramidHeight.getText().toString();
                        temp2 = piramidWidth.getText().toString();
                        temp3 = piramidLength.getText().toString();
                        if(temp1.length() != 0 && temp2.length() != 0 && temp3.length() != 0 ){
                            int length, width, height;
                            double sum;
                            length = Integer.parseInt(piramidLength.getText().toString());
                            width = Integer.parseInt(piramidWidth.getText().toString());
                            height = Integer.parseInt(piramidHeight.getText().toString());
                            sum = (length*width*height)/3;
                            piramidHasil.setText(Double.toString(sum));
                        }else{
                            Toast.makeText(v.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        tubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockHasil.setVisibility(View.INVISIBLE);
                blockLength.setVisibility(View.INVISIBLE);
                blockWidth.setVisibility(View.INVISIBLE);
                blockHeight.setVisibility(View.INVISIBLE);
                blockSubmitBtn.setVisibility(View.INVISIBLE);
                blockPict.setVisibility(View.INVISIBLE);

                piramidLength.setVisibility(View.INVISIBLE);
                piramidWidth.setVisibility(View.INVISIBLE);
                piramidHeight.setVisibility(View.INVISIBLE);
                piramidSubmitBtn.setVisibility(View.INVISIBLE);
                piramidHasil.setVisibility(View.INVISIBLE);
                piramidPict.setVisibility(View.INVISIBLE);

                tubeRadius.setVisibility(View.VISIBLE);
                tubeheight.setVisibility(View.VISIBLE);
                tubeSubmitBtn.setVisibility(View.VISIBLE);
                tubeHasil.setVisibility(View.VISIBLE);
                tubePict.setVisibility(View.VISIBLE);

                tubeSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp1, temp2;
                        temp1 = tubeRadius.getText().toString();
                        temp2 = tubeheight.getText().toString();
                        if(temp1.length() != 0 && temp2.length() != 0){
                            int radius, height;
                            double sum;
                            radius = Integer.parseInt(tubeRadius.getText().toString());
                            height = Integer.parseInt(tubeheight.getText().toString());
                            sum = 3.14 * radius * radius* height;
                            tubeHasil.setText(Double.toString(sum));
                        }else{
                            Toast.makeText(v.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        return v;
    }
}