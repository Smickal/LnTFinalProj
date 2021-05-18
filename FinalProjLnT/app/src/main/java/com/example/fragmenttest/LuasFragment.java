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

public class LuasFragment extends Fragment {
    SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView =  inflater.inflate(R.layout.activity_luas_fragment, container, false);

        TextView txtName = rootView.findViewById(R.id.txt_name);
        sp = this.getActivity().getSharedPreferences("information", Context.MODE_PRIVATE);
        String name = sp.getString("namePref", "");
        txtName.setText("Hi, " + name);


        //Choose Buttons
        Button squareBtn = rootView.findViewById(R.id.btn_square);
        Button triangleBtn = rootView.findViewById(R.id.btn_triangle);
        Button CircleBtn = rootView.findViewById(R.id.btn_circle);

        //default Square
        ImageView squareImg = rootView.findViewById(R.id.pict_square);
        EditText squareEdit = rootView.findViewById(R.id.edit_SquareSide);
        Button SquareSubmitBtn = rootView.findViewById(R.id.btn_submitSquare);
        TextView squareHasil = rootView.findViewById(R.id.txtHasilSquare);

        //Triangle
        ImageView triangleImg = rootView.findViewById(R.id.pict_triangle);
        EditText triangleEditAlas = rootView.findViewById(R.id.edit_TriangleAlas);
        EditText triangleEditTinggi = rootView.findViewById(R.id.edit_TriangleTinggi);
        Button triangleSubmitBtn = rootView.findViewById(R.id.btn_submitTriangle);
        TextView triangleHasil = rootView.findViewById(R.id.txtHasiltriangle);

        //Circle
        ImageView circleImg = rootView.findViewById(R.id.pict_circle);
        EditText circleEdit = rootView.findViewById(R.id.edit_CircleRadius);
        Button circleSubmitBtn = rootView.findViewById(R.id.btn_submitCircle);
        TextView circleHasil = rootView.findViewById(R.id.txtHasilCircle);

        //initiale HIDE
        triangleImg.setVisibility(View.INVISIBLE);
        triangleEditAlas.setVisibility(View.INVISIBLE);
        triangleEditTinggi.setVisibility(View.INVISIBLE);
        triangleSubmitBtn.setVisibility(View.INVISIBLE);
        triangleHasil.setVisibility(View.INVISIBLE);
        circleImg.setVisibility(View.INVISIBLE);
        circleEdit.setVisibility(View.INVISIBLE);
        circleSubmitBtn.setVisibility(View.INVISIBLE);
        circleHasil.setVisibility(View.INVISIBLE);
        //
        SquareSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp;
                temp = squareEdit.getText().toString();
                if(temp.length() != 0){
                    Integer squareSide = 0;
                    double squareSum = 0;
                    squareSide = Integer.parseInt(squareEdit.getText().toString());
                    squareSum = squareSide*squareSide;
                    squareHasil.setText(Double.toString(squareSum));
                }else{
                    Toast.makeText(rootView.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        squareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squareImg.setVisibility(View.VISIBLE);
                squareEdit.setVisibility(View.VISIBLE);
                squareHasil.setVisibility(View.VISIBLE);
                SquareSubmitBtn.setVisibility(View.VISIBLE);

                triangleImg.setVisibility(View.INVISIBLE);
                triangleEditAlas.setVisibility(View.INVISIBLE);
                triangleEditTinggi.setVisibility(View.INVISIBLE);
                triangleSubmitBtn.setVisibility(View.INVISIBLE);
                triangleHasil.setVisibility(View.INVISIBLE);

                circleImg.setVisibility(View.INVISIBLE);
                circleEdit.setVisibility(View.INVISIBLE);
                circleSubmitBtn.setVisibility(View.INVISIBLE);
                circleHasil.setVisibility(View.INVISIBLE);

                SquareSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp;
                        temp = squareEdit.getText().toString();
                        if(temp.length() != 0){
                            Integer squareSide = 0;
                            double squareSum = 0;
                            squareSide = Integer.parseInt(squareEdit.getText().toString());
                            squareSum = squareSide*squareSide;
                            squareHasil.setText(Double.toString(squareSum));
                        }else{
                            Toast.makeText(rootView.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        triangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleImg.setVisibility(View.INVISIBLE);
                circleEdit.setVisibility(View.INVISIBLE);
                circleSubmitBtn.setVisibility(View.INVISIBLE);
                circleHasil.setVisibility(View.INVISIBLE);

                squareImg.setVisibility(View.INVISIBLE);
                squareEdit.setVisibility(View.INVISIBLE);
                squareHasil.setVisibility(View.INVISIBLE);
                SquareSubmitBtn.setVisibility(View.INVISIBLE);

                triangleImg.setVisibility(View.VISIBLE);
                triangleEditAlas.setVisibility(View.VISIBLE);
                triangleEditTinggi.setVisibility(View.VISIBLE);
                triangleSubmitBtn.setVisibility(View.VISIBLE);
                triangleHasil.setVisibility(View.VISIBLE);

                triangleSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp1,temp2;
                        temp1 = triangleEditAlas.getText().toString();
                        temp2 = triangleEditTinggi.getText().toString();
                        if(temp1.length() != 0 && temp2.length() != 0){
                            Integer triangleAlas= 0, triangleHeight= 0;
                            double triangleSum = 0;
                            triangleAlas = Integer.parseInt(triangleEditAlas.getText().toString());
                            triangleHeight = Integer.parseInt(triangleEditTinggi.getText().toString());
                            triangleSum = 0.5*triangleAlas*triangleHeight;
                            triangleHasil.setText(Double.toString(triangleSum));
                        }else{
                            Toast.makeText(rootView.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        CircleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squareImg.setVisibility(View.INVISIBLE);
                squareEdit.setVisibility(View.INVISIBLE);
                squareHasil.setVisibility(View.INVISIBLE);
                SquareSubmitBtn.setVisibility(View.INVISIBLE);

                triangleImg.setVisibility(View.INVISIBLE);
                triangleEditAlas.setVisibility(View.INVISIBLE);
                triangleEditTinggi.setVisibility(View.INVISIBLE);
                triangleSubmitBtn.setVisibility(View.INVISIBLE);
                triangleHasil.setVisibility(View.INVISIBLE);

                circleImg.setVisibility(View.VISIBLE);
                circleEdit.setVisibility(View.VISIBLE);
                circleSubmitBtn.setVisibility(View.VISIBLE);
                circleHasil.setVisibility(View.VISIBLE);

                circleSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp;
                        temp = circleEdit.getText().toString();
                        if(temp.length() != 0){
                            Integer circleRadius= 0;
                            double circleSum= 0;
                            circleRadius = Integer.parseInt(circleEdit.getText().toString());
                            circleSum = 3.14 * circleRadius * circleRadius;
                            circleHasil.setText(Double.toString(circleSum));
                        }else{
                            Toast.makeText(rootView.getRootView().getContext(), "Please fill all boxes!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        return rootView;
    }


}