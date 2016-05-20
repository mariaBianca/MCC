package com.mccapp.bianca.mcc;

/**
 * @author group Ella.
 */
/**
 * This class represents the implementation of the Video view.
 * */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoThing extends Activity {
    private static VideoThing ourInstance = new VideoThing();

    public static VideoThing getInstance() {
        return ourInstance;
    }

//    private VideoThing() {
 //   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        VideoView vid = (VideoView) findViewById(R.id.videoview);
        vid.setVideoPath("/DCIM/Camera/VID_20151204_093412.mp4");
        vid.setMediaController(new MediaController(this));
        vid.start();
        vid.requestFocus();

    }

}
