package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    EditText title;
    EditText author;
    EditText pages;
    Switch available;
    Button add;
    Button save;
    book[] books=new book[20];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupviews();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i =0;
                String titleStr=title.getText().toString();
                String authorStr=author.getText().toString();
                String pagesStr=pages.getText().toString();
                boolean availableRes;
                if(available.isChecked())
                 availableRes=true;
                else
                    availableRes=false;

                book newBook=new book(titleStr,authorStr,pagesStr,availableRes);
                books[i]=newBook;
                i++;

            }
        });
        
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor=prefs.edit();
                Gson gson=new Gson();
                String bookStr=gson.toJson(books);
                editor.putString("book",bookStr);
                editor.commit();
                
            }
        });



    }

    private void setupviews() {
        title=findViewById(R.id.titleTxt);
        author=findViewById(R.id.authorTxt);
        pages=findViewById(R.id.pagesTxt);
        available=findViewById(R.id.availableSwitch);
        add=findViewById(R.id.addBtn);
        save=findViewById(R.id.saveBtn);
    }

}