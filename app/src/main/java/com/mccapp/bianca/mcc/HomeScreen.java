package com.mccapp.bianca.mcc;

/**
 *  @author Group Ella.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //button declaration
        Button buttonButtonView = (Button) this.findViewById(R.id.btnBluetooth);
        Button buttonJoystickView = (Button) this.findViewById(R.id.btnJoystick);
        Button episodeButton = (Button) this.findViewById(R.id.btnEpisode);
        Button bluetoothButton = (Button) this.findViewById(R.id.b);

    }

}
