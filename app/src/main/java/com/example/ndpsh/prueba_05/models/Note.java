package com.example.ndpsh.prueba_05.models;

import com.example.ndpsh.prueba_05.Aplication.MyApplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;


/**
 *  Created by Naim on 06/11/18
 */

public class Note extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String descripcion;
    @Required
    private Date createdAt;

    public Note() {

    }

    public Note( String descripcion) {
        this.id = MyApplication.NoteID.incrementAndGet();
        this.descripcion = descripcion;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
