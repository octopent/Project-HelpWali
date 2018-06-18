package mayanksghrathore.example.com.myhelpwali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername=(EditText)findViewById(R.id.etUser);
        etPassword=(EditText)findViewById(R.id.etPass);

        etUsername.setText("");
        etPassword.setText("");
    }

    public void onLoginPress(View view){
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        String type = "login";

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Too many fields left empty!", Toast.LENGTH_SHORT).show();
        }
        else {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);

        }
    }

    /*public void onLoginPress(View view){
        Intent i=new Intent(this,CategoryActivity.class);
        startActivity(i);
    }*/

    public void onRegisterPress(View view){
        Intent i=new Intent(this,SignupActivity.class);
        startActivity(i);
    }

    public void showTnC(View v){
        Toast.makeText(this, "Visit www.helpwali.tk to view T&C's and Privacy Policy", Toast.LENGTH_SHORT).show();
    }
}
