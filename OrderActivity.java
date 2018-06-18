package mayanksghrathore.example.com.myhelpwali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    EditText Fname, Lname, Aadhar, Contact, AddL1, AddL2, Pin;
    String fname, lname, adhar, contact, addl1, addl2, pincode, maid_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("Order");

        Fname = (EditText)findViewById(R.id.userFName);
        Lname = (EditText)findViewById(R.id.userLName);
        Aadhar = (EditText)findViewById(R.id.userAdhar);
        Contact = (EditText)findViewById(R.id.userContact);
        AddL1 = (EditText)findViewById(R.id.userAddL1);
        AddL2 = (EditText)findViewById(R.id.userAddL2);
        Pin = (EditText)findViewById(R.id.userPin);


        Intent intent = getIntent();
        maid_name = intent.getStringExtra(DetailActivity.EXTRA_MNAME);


        Fname.setText("");
        Lname.setText("");
        Aadhar.setText("");
        Contact.setText("");
        AddL1.setText("");
        AddL2.setText("");
        Pin.setText("");
    }

    public void onProceed(View view) {
        fname = Fname.getText().toString();
        lname = Lname.getText().toString();
        adhar = Aadhar.getText().toString();
        contact = Contact.getText().toString();
        addl1 = AddL1.getText().toString();
        addl2 = AddL2.getText().toString();
        pincode = Pin.getText().toString();
        Toast.makeText(this, maid_name, Toast.LENGTH_SHORT).show();

        String type = "submit";

        if (TextUtils.isEmpty(fname) || TextUtils.isEmpty(lname) || TextUtils.isEmpty(adhar) || TextUtils.isEmpty(contact) ||
                TextUtils.isEmpty(addl1) || TextUtils.isEmpty(addl2) || TextUtils.isEmpty(pincode)) {
            Toast.makeText(this, "Too many fields left empty!", Toast.LENGTH_SHORT).show();
        }
        else {
            PostUserData postUserData = new PostUserData(this);
            postUserData.execute(type, fname, lname, adhar, contact, addl1, addl2, pincode, maid_name);

        }
    }
}
