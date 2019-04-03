package com.example.parcial;

import android.content.Intent;
import android.content.res.Resources;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateStudent extends AppCompatActivity {

    private EditText Name, LastName, IDStudent, Grade;
    private Resources Resources;
    private ArrayList<Integer> Grades = new ArrayList<Integer>();
    private ListView LV;
    private String[] Opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student);

        Name = (EditText)findViewById(R.id.TxtNameStudent);
        LastName  = (EditText)findViewById(R.id.TxtLastNameStudent);
        IDStudent = (EditText)findViewById(R.id.TxtIDStudent);
        Grade = (EditText)findViewById(R.id.TxtGradeStudent);
        LV = (ListView)findViewById(R.id.Grades);
        Opc = new String[3];
        Opc[0] = "";
        Opc[1] = "";
        Opc[2] = "";

    }

    public void AddGrade(View view){
        if(Grade.getText().toString().equals("")){
            Toast.makeText(this, R.string.error_data, Toast.LENGTH_LONG).show();
        }else{
            if(Grades.size()<3){
                int grade = Integer.valueOf(Grade.getText().toString());
                Grades.add(grade);
                Opc[Grades.size()- 1] = "Nota " + Grades.size() + ": " + grade;
                ArrayAdapter<String> Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Opc);
                LV.setAdapter(Adapter);
            }
        }
        Grade.setText("");
    }

    public void AddStudent(View view){
        if(Name.getText().toString().equals("")|| LastName.getText().toString().equals("") || IDStudent.getText().toString().equals("")){
            Toast.makeText(this, R.string.error_data, Toast.LENGTH_LONG).show();
        }else{
            String name, lastname, id;
            name = Name.getText().toString();
            id = IDStudent.getText().toString();
            lastname = LastName.getText().toString();
            Estudiante estudiante = new Estudiante(id, name, lastname, Grades);
            Data.AddEstudiante(estudiante);
            Toast.makeText(this, R.string.done, Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.putExtra("message_return", "This data is returned when user click back menu in target activity.");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
