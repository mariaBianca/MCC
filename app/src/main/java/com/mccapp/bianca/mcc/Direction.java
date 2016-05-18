package com.mccapp.bianca.mcc;

import java.io.IOException;

/**
 * @author Group Ella
 */
public class Direction {

    static void Forward()
    {
        try {
            ButtonView.mmOutputStream.write("f".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Backward()
    {
        try {
            ButtonView.mmOutputStream.write("b".getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Right(){
        try{
            ButtonView.mmOutputStream.write("r".getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    static void Left(){
        try{
            ButtonView.mmOutputStream.write("l".getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    static void Stop(){
        try{
            ButtonView.mmOutputStream.write("s".getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
