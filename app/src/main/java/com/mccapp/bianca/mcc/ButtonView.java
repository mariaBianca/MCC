package com.mccapp.bianca.mcc;
/**
 * @author Group Ella.
 * This class represents the implementation of the Button-controlled view.
 * */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class ButtonView extends Activity {

    BluetoothConnection bc;

  /**
   * This method implements the beginning of the activity
   */
      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_button_view);


        //Declaration of buttons
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