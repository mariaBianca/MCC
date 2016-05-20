package com.mccapp.bianca.mcc;

/**
 * @author group Ella.
 */
/**
 * This class represents the implementation of the Video view.
 * */
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoThing extends Activity {
    private static final String MOVIE_URL = "https://youtu.be/_2kx8vJBR_s";

 //   private static VideoThing ourInstance = new VideoThing();
 //   public static VideoThing getInstance() {
 //    return ourInstance;
 // }

 //   private VideoThing() {
 //   }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        VideoView vid = (VideoView) findViewById(R.id.videoView);
        //vid.setVideoPath("/DCIM/Camera/VID_20151204_093412.mp4");
        Uri video = Uri.parse(MOVIE_URL);
        vid.setMediaController(new MediaController(this));
        vid.setVideoURI(video);
        vid.start();
        vid.requestFocus();

    }

}
