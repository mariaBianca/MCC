package com.mccapp.bianca.mcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import static java.lang.String.valueOf;

public class JoystickControl extends AppCompatActivity {

    private TextView angleTextView;
    private TextView powerTextView;
    public TextView directionTextView;
    TextView movement;
    View view;

    //  private VideoEnabledWebView webView;
    // private VideoEnabledWebChromeClient webChromeClient;
    // Importing also other views
    private com.mccapp.bianca.mcc.JoystickView joystick1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick_control);
        angleTextView = (TextView) findViewById(R.id.angleTextView);
        powerTextView = (TextView)findViewById(R.id.powerTextView);
        directionTextView = (TextView) findViewById(R.id.directionTextView);
        // movement = (TextView) view.findViewById(R.id.moveLabel);
        //Referencing also other views
        joystick1 = (com.mccapp.bianca.mcc.JoystickView) findViewById(R.id.joystickView);

        //Event listener that always returns the variation of the angle in degrees, motion power in percentage and direction of movement
        joystick1.setOnJoystickMoveListener(new com.mccapp.bianca.mcc.JoystickView.OnJoystickMoveListener() {

            @Override
            public void onValueChanged(int angle, int power, int direction) {
                // TODO Auto-generated method stub


                angleTextView.setText(" " + valueOf(angle) + "°");
                powerTextView.setText(" " + valueOf(power) + "%");
                directionTextView.setText("" + valueOf(direction));

                if (BluetoothConnection.mmSocket != null) {
                    try {
                        //int move = Integer.parseInt();


                        BluetoothConnection.mmOutputStream.write((""+power+"."+angle+"#").getBytes());

                        // FirstFragment.mmOutputStream.write(("t"+angle).getBytes());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, com.mccapp.bianca.mcc.JoystickView.DEFAULT_LOOP_INTERVAL);

    }

}