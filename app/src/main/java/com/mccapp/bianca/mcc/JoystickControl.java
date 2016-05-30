package com.mccapp.bianca.mcc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;

import static java.lang.String.valueOf;

public class JoystickControl extends AppCompatActivity {

    private TextView angleTextView;
    private TextView powerTextView;
    public TextView directionTextView;
    TextView movement;
    View view;

    //  Importing also other views
    private com.mccapp.bianca.mcc.JoystickView joystick1;


    @Override

    // Beginning of the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick_control);
        angleTextView = (TextView) findViewById(R.id.angleTextView);
        powerTextView = (TextView) findViewById(R.id.powerTextView);
        directionTextView = (TextView) findViewById(R.id.directionTextView);


        //Referencing also other views
        joystick1 = (com.mccapp.bianca.mcc.JoystickView) findViewById(R.id.joystickView);

        // Webview for the live feedback
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://192.168.43.171/");          //raspberry-pi  http://192.168.43.171/
        webView.setWebViewClient(new WebplayerClient());
        webView.setWebChromeClient(new WebplayerChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Event listener that always returns the variation of the angle in degrees, motion power in percentage and direction of movement
        joystick1.setOnJoystickMoveListener(new com.mccapp.bianca.mcc.JoystickView.OnJoystickMoveListener() {

            @Override
            public void onValueChanged(int angle, int power, int direction) {
                // TODO Auto-generated method stub


                angleTextView.setText(" " + valueOf(angle) + "°");
                powerTextView.setText(" " + valueOf(power) + "%");
                directionTextView.setText("" + valueOf(direction));

                if (BluetoothConnection.mmSocket != null) {
                    try {

                        if (direction == 5 || direction == 6) {
                            BluetoothConnection.mmOutputStream.write("w".getBytes());
                        }
                        else if (direction == 7 || direction == 8) {
                            BluetoothConnection.mmOutputStream.write("t".getBytes());
                        }
                        else if (direction == 1 || direction == 2){
                            BluetoothConnection.mmOutputStream.write("r".getBytes());
                        }
                        else if (direction == 3 || direction == 3){
                            BluetoothConnection.mmOutputStream.write("l".getBytes());
                        }
                        else if (angle == 0){
                            BluetoothConnection.mmOutputStream.write("f".getBytes());
                        }
                        else if (angle == 180){
                            BluetoothConnection.mmOutputStream.write("b".getBytes());
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, com.mccapp.bianca.mcc.JoystickView.DEFAULT_LOOP_INTERVAL);

    }

}