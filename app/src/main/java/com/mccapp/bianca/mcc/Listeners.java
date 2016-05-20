package com.mccapp.bianca.mcc;

/**
 * @author Group Ella.
 * */
/**
 * This class represents the implementation of the Key Listeners for all the buttons used throughout the app.
 * */

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Listeners {

    /**
     * Method to set the keyListener for the buttons.
     * */

    BluetoothConnection bc;

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
     * Method to set the KeyListener for the upButton
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
     * Method to set the KeyListener for the downButton
     * */
    public static void DownListener(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Direction.Backward();
            }});
    }

    /**
     * Method to set the KeyListener for the rightButton
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
     * Method to set the KeyListener for the leftButton
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
     * Method to set the KeyListener for the stopButton
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
