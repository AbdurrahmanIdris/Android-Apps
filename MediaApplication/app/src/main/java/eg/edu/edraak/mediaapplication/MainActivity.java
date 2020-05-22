package eg.edu.edraak.mediaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button playSound;
    Button playVideo;
    VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playSound = findViewById(R.id.playSoundBtn);
        playVideo = findViewById(R.id.playVideoBtn);
        vid = findViewById(R.id.myVideoView);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.aboya_byrn);
        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }//end onClick
        });
        //play video code
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController m = new MediaController(MainActivity.this);
                vid.setMediaController(m);

                String path = "android.resource://eg.edu.edraak.mediaapplication/"+R.raw.snapchat_android;
                Uri uri = Uri.parse(path);
                vid.setVideoURI(uri);
                vid.start();
            }//end onClick
        });
    }//end onCreate
}//end class
