package id.fadhlanhawali.talingan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import id.fadhlanhawali.talingan.View.MainActivity;

public class Splash extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_splash);
        initToolbar();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(() -> {

                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();


        }, SPLASH_DISPLAY_LENGTH);
    }
    private void initToolbar() {
        ViewTools.setSystemBarColor(this, R.color.banner_red);
        ViewTools.setSystemBarLight(this);
    }


}