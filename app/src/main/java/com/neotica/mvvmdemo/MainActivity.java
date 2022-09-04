package com.neotica.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{


    Button button;
    TextView textView;

    //6 Connecting MainActivity with ViewModel and listening to LiveData
    AppViewModel appViewModel;

    //Linking activity with presenter
    //Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling the presenter data from Model
                //No linkage between Activity and Model
                //MainActivity is handling UI only
                //All logic occurs at the presenter
                appViewModel.getAppName();
            }
        });
        //6.1 add new ViewModelProvider
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        //7 Listening and observing the changes to LiveData
        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }


    //Model: Model.java class
    //View: Activity with Text & Button
    //ViewModel: AppViewModel.java

    //The Presenter and the View is then linked using AppView.java (Interface)

    //We need to make the connection "Binding" = "ViewModel"
}