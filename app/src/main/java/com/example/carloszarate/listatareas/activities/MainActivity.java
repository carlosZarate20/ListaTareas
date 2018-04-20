package com.example.carloszarate.listatareas.activities;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carloszarate.listatareas.R;
import com.example.carloszarate.listatareas.adapter.TareasAdapter;
import com.example.carloszarate.listatareas.models.Tareas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<Tareas> items;
    ArrayList<Tareas> tareasList;
    TareasAdapter tareasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listTareas);
        /*tareasList.add(new Tareas("Tarea 1",false));
        tareasList.add(new Tareas("Tarea 2",false));
        tareasList.add(new Tareas("Tarea 3",false));
        tareasList.add(new Tareas("Tarea 4",false));
        tareasList.add(new Tareas("Tarea 5",false)); */
        initItems();
        tareasAdapter = new TareasAdapter(this,items);
        listView.setAdapter(tareasAdapter);

    }
    private void initItems(){
        items = new ArrayList<Tareas>();
        TypedArray arrayText = getResources().obtainTypedArray(R.array.tareas);
        for(int i=0; i<arrayText.length(); i++){
            String s = arrayText.getString(i);
            boolean b = false;
            Tareas item = new Tareas(s, b);
            items.add(item);
        }
        arrayText.recycle();
    }

    /*private ArrayList<Tareas> getTareas(boolean isSelect){
        ArrayList<Tareas> list= new ArrayList<>();
        for ()
    }*/
}
