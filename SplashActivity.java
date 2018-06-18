package mayanksghrathore.example.com.myhelpwali;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    CountDownTimer ct = new CountDownTimer(3000, 2000) {
        @Override
        public void onTick(long millisUntilFinished) {
        }
        @Override
        public void onFinish() {
            startNew();
        }
    }.start();

    public void startNew() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
