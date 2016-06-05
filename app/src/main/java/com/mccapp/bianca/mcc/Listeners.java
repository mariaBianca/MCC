package com.mccapp.bianca.mcc;

/**
 * @author Group Ella.
 * This class represents the implementation of the Key Listeners for all the buttons used throughout the app.
 * */

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Listeners {

    /**
     * This method implements the Listener for Bluetooth
     */
    public static void BluetoothListener(Button button){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BluetoothConnection.findBT();
                    BluetoothConnection.openBT();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * This method implements the KeyListener for the upButton
     * */
    public static void UpListener(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Direction.Forward();
            }
        });
    }

    /**
     * This method implements the KeyListener for the downButton
     * */
    public static void DownListener(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Direction.Backward();
            }});
    }

    /**
     * This method implements the KeyListener for the rightButton
     * */
    public static void RightListener(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Direction.Right();
            }
        });
    }

    /**
     * This method implements the KeyListener for the leftButton
     * */
    public static void LeftListener(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick (View v){
                Direction.Left();
            }
        });
    }

    /**
     * This method implements the KeyListener for the stopButton
     * */
    public static void StopListener(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Direction.Stop();
            }
        });
    }

}
