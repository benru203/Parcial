package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsList extends AppCompatActivity {

    private ListView LV;
    private ArrayList<Estudiante> Estudiantes;
    private ArrayList<String> DataEstudiantes;
    private Intent In;
    private TextView TxtNoResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_list);

        LV = (ListView)findViewById(R.id.LV);
        Estudiantes = Data.getEstudiantes();
        DataEstudiantes = new ArrayList<String>();
        TxtNoResult = (TextView)findViewById(R.id.TxtNoResult);
        if(Estudiantes.size() > 0){
            TxtNoResult.setVisibility(View.INVISIBLE);
            LV.setVisibility(View.VISIBLE);
            for (int i = 0; i < Estudiantes.size(); i++) {
                DataEstudiantes.add(Estudiantes.get(i).getNombre() + " " + Estudiantes.get(i).getApellido());
            }
        }
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DataEstudiantes);
        LV.setAdapter(Adapter);
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                In = new Intent(StudentsList.this,StudentDetail.class);
                In.putExtra("postition",position);
                startActivity(In);
            }
        });

    }
}
