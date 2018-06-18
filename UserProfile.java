package mayanksghrathore.example.com.myhelpwali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        getSupportActionBar().setTitle("My Profile");

    }

    public void onSetting(View view) {
        startActivity(new Intent(this, UserSettings.class));
    }
}
