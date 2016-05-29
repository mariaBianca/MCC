package com.mccapp.bianca.mcc;

/**
 *  @author Group Ella.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class represents the implementation of the HomeScreen view.
 * */

public class HomeScreen extends AppCompatActivity {

    BluetoothConnection bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //button declaration for buttonView activity
        Button buttonButtonView = (Button) this.findViewById(R.id.btnButton);
        buttonButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            Intent intent = new Intent(HomeScreen.this, ButtonView.class);
                            startActivity(intent);
                                     }
                   });

        //button declaration for JoystickView activity
        Button buttonJoystickView = (Button) this.findViewById(R.id.btnJoystick);
        buttonJoystickView.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View view){
                 Intent intent = new Intent(HomeScreen.this, JoystickControl.class);
                 startActivity(intent);
             }
        });

        //button declaration for  episode display activity
        Button buttonEpisode = (Button) this.findViewById(R.id.btnEpisode);
        buttonEpisode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreen.this, Episode.class);
                startActivity(intent);
            }
        });

        //button declaration for the bluetooth connection
        Button buttonBluetooth = (Button) this.findViewById(R.id.btnBluetooth);
        Listeners.BluetoothListener(buttonBluetooth);


    }
}