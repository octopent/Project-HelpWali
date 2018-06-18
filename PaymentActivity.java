package mayanksghrathore.example.com.myhelpwali;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setTitle("Payments");
    }

    public void onPay(View v){
        Toast.makeText(this, "Payment Success", Toast.LENGTH_LONG).show();
    }

    public void onHome(View v){
        Intent i = new Intent(this,CategoryActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(
                this, android.R.style.Theme_Material_Dialog_Alert);
        builder.setTitle("Payment Pending..")
                .setMessage("Do you want to cancel the order?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(1);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.stat_notify_error).show();
    }
}
