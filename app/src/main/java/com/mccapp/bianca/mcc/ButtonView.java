package com.mccapp.bianca.mcc;
/**
 * @author by Group Ella.
 */
/**
 * This class represents the implementation of the Button-controlled view.
 * */

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
//import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class ButtonView extends AppCompatActivity {

    TextView myLabel;
    static BluetoothAdapter mBluetoothAdapter;
    static BluetoothSocket mmSocket;
    static BluetoothDevice mmDevice;
    static OutputStream mmOutputStream;
    static InputStream mmInputStream;
    static Thread workerThread;
    static byte[] readBuffer;
    static int readBufferPosition;
    volatile static boolean stopWorker;
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

    static void findBT()
    {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null)
        {
            //myLabel.setText("No bluetooth adapter available");
        }

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(enableBluetooth, 0);
        }

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                if(device.getName().equals("HC-06"))
                {
                    mmDevice = device;
                    break;
                }
            }
        }
        // myLabel.setText("Bluetooth Device Found");
    }

    static void openBT() throws IOException
    {
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
        mmSocket.connect();
        mmOutputStream = mmSocket.getOutputStream();
        mmInputStream = mmSocket.getInputStream();

        beginListenForData();
        //Toast.makeText(getApplicationContext(),"Bluetooth connected!" ,Toast.LENGTH_LONG).show();;  UNCOMMENT HERE
    }

    static void beginListenForData()
    {
        final Handler handler = new Handler();
        final byte delimiter = 10; //This is the ASCII code for a newline character

        stopWorker = false;
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        workerThread = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopWorker)
                {
                    try
                    {
                        int bytesAvailable = mmInputStream.available();
                        if(bytesAvailable > 0)
                        {
                            byte[] packetBytes = new byte[bytesAvailable];
                            mmInputStream.read(packetBytes);
                            for(int i=0;i<bytesAvailable;i++)
                            {
                                byte b = packetBytes[i];
                                if(b == delimiter)
                                {
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;

                                    handler.post(new Runnable()
                                    {
                                        public void run()
                                        {
                                            //myLabel.setText(data);
                                        }
                                    });
                                }
                                else
                                {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                        }
                    }
                    catch (IOException ex)
                    {
                        stopWorker = true;
                    }
                }
            }
        });

        workerThread.start();
    }


    void closeBT() throws IOException
    {
        stopWorker = true;
        mmOutputStream.close();
        mmInputStream.close();
        mmSocket.close();
        //Toast.makeText(getApplicationContext(),"Turned off" ,Toast.LENGTH_LONG).show();
        }

}