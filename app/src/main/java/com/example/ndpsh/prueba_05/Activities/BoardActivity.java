package com.example.ndpsh.prueba_05.Activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ndpsh.prueba_05.R;

/**
 *  Created by Naim on 06/11/18
 */

public class BoardActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        fab = (FloatingActionButton) findViewById(R.id.fabAddBoard);
    }
}
