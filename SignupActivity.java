package mayanksghrathore.example.com.myhelpwali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        radioButton = (RadioButton)findViewById(R.id.tcRadio);
        etUsername=(EditText)findViewById(R.id.etUser);
        etPassword=(EditText)findViewById(R.id.etCPass);

        etUsername.setText("");
        etPassword.setText("");

    }
    public void onRegisterPress(View view) {
        String str_uid = etUsername.getText().toString();
        String str_pass = etPassword.getText().toString();
        String type = "register";

        if(TextUtils.isEmpty(str_uid) || TextUtils.isEmpty(str_pass)){
            Toast.makeText(this, "Too many fields left blank.", Toast.LENGTH_SHORT).show();
        }
        else if(radioButton.isChecked()==false){
            Toast.makeText(this, "Please agree to Terms & Conditions", Toast.LENGTH_SHORT).show();
        }
        else {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, str_uid, str_pass);
        }
    }
}
