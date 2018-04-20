package com.example.carloszarate.listatareas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.carloszarate.listatareas.R;
import com.example.carloszarate.listatareas.models.Tareas;

import java.util.ArrayList;
import java.util.List;

public class TareasAdapter extends BaseAdapter {
    private Context context;
    private List<Tareas> tareasArrayList;


    public TareasAdapter(Context context, List<Tareas> tareasArrayList) {
        this.context = context;
        this.tareasArrayList = tareasArrayList;
    }

    @Override
    public int getCount() {
        return tareasArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tareasArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public boolean isChecked(int position) {
        return tareasArrayList.get(position).isSelected();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.lista_tareas,null);
            holder.textTarea = (TextView) convertView.findViewById(R.id.textTarea);
            holder.checkTarea = (CheckBox) convertView.findViewById(R.id.checkTarea);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textTarea.setText(tareasArrayList.get(position).getTarea());
        holder.checkTarea.setChecked(tareasArrayList.get(position).isSelected());
        holder.checkTarea.setTag(position);
        holder.checkTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean newState = !tareasArrayList.get(position).isSelected();
                tareasArrayList.get(position).isSelected = newState;
            }
        });
        holder.checkTarea.setSelected(isChecked(position));
        return convertView;
    }

    static class ViewHolder{
        TextView textTarea;
        CheckBox checkTarea;
    }
}
