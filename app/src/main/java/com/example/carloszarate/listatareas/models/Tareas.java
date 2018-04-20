package com.example.carloszarate.listatareas.models;

public class Tareas {
    String tarea;
    public boolean isSelected;

    public Tareas(String tarea, boolean isSelected) {
        this.tarea = tarea;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
}
