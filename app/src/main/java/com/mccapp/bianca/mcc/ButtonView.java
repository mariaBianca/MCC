package com.mccapp.bianca.mcc;
/**
 * @author by Group Ella.
 */
/**
 * This class represents the implementation of the Button-controlled view.
 * */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class ButtonView extends AppCompatActivity {

    BluetoothConnection bluetoothConnection = new BluetoothConnection();
    //MediaPlayer honk = MediaPlayer.create(getApplicationContext(), R.raw.startaudio );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //honk.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //honk.stop();

        //button declaration
        Button bluetoothButton = (Button) this.findViewById(R.id.bluetoothBtn);
        Button upButton = (Button) this.findViewById(R.id.up);
        Button downButton = (Button) this.findViewById(R.id.down);
        Button leftButton = (Button) this.findViewById(R.id.left);
        Button rightButton = (Button) this.findViewById(R.id.right);
        Button stopButton = (Button) this.findViewById(R.id.stop);


        //assign keyListeners to the buttons.
        Listeners.BluetoothListener(bluetoothButton);
        Listeners.UpListener(upButton);
        Listeners.DownListener(downButton);
        Listeners.LeftListener(leftButton);
        Listeners.RightListener(rightButton);
        Listeners.StopListener(stopButton);
    }


}