package mayanksghrathore.example.com.myhelpwali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UserSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_settings);
        getSupportActionBar().setTitle("User Settings");

    }

    public void onHelp(View view) {
        Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
    }

    public void onTC(View view) {
        Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
    }

    public void onUpdate(View view) {
        Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
    }

    public void onDelAcc(View view) {
        Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
    }

    public void onContribute(View view) {
        Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
    }
}
