package com.example.ndpsh.prueba_05.Activities;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ndpsh.prueba_05.R;
import com.example.ndpsh.prueba_05.models.Board;

import io.realm.Realm;

/**
 *  Created by Naim on 06/11/18
 */

public class BoardActivity extends AppCompatActivity {

    private Realm realm;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);


        // Db Realm
        realm = Realm.getDefaultInstance();

        fab = (FloatingActionButton) findViewById(R.id.fabAddBoard);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertForCreatingBoard("title", "board");
            }
        });
    }
        //** CRUD Actions **/
        private void createdNewBoard(String boardName){
            realm.beginTransaction();
            Board board = new Board(boardName);
            realm.copyToRealm(board);
            realm.commitTransaction();

            //Otra opcion es + (final String boardName) f.42 :
            //realm.executeTransaction(new Realm.Transaction() {
            //   @Override
            //   public void execute(Realm realm) {
            //      Board board = new Board(boardName);
            //      realm.copyToRealm(board);
            //                  }
            // });

        }


        //** Dialogs **/
    private void showAlertForCreatingBoard(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(title != null)builder.setTitle(title);
        if(message != null)builder.setMessage(message);

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.dialog_create_board, null);
        builder.setView(viewInflated);


         final EditText input = (EditText) viewInflated.findViewById(R.id.editTextNewBoard);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               String boardName = input.getText().toString().trim();
               if(boardName.length() > 0)
                   createdNewBoard(boardName);
               else
                   Toast.makeText(getApplicationContext(), "The name is required to create a new Board", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
