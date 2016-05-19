package com.mccapp.bianca.mcc;

/**
 * @author group Ella.
 */
/**
 * This class represents the implementation of the Video view.
 * */
import android.app.Activity;
import android.os.Bundle;

public class VideoThing extends Activity {
    private static VideoThing ourInstance = new VideoThing();

    public static VideoThing getInstance() {
        return ourInstance;
    }

    private VideoThing() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
    }

}
