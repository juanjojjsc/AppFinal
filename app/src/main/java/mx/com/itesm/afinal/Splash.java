package mx.com.itesm.afinal;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    VideoView muestraVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitar title bar y notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.layout_splash);

        try {
            VideoView muestraVideo = new VideoView(this);
            setContentView(muestraVideo);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1);
            muestraVideo.setVideoURI(video);

            muestraVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Intent intentoPrincipal = new Intent().setClass(Splash.this, Login.class);
                    startActivity(intentoPrincipal);
                }
            });

            muestraVideo.start();

        } catch(Exception ex) {
            Intent intentoPrincipal = new Intent().setClass(Splash.this, Login.class);
            startActivity(intentoPrincipal);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
