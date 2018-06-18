package mayanksghrathore.example.com.myhelpwali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_AREA;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_CATEGORY1;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_CATEGORY2;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_DESCRIPTION;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_LANGUAGE1;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_LANGUAGE2;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_NAME;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_PRICE;
import static mayanksghrathore.example.com.myhelpwali.MaidListActivity.EXTRA_RATING;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MNAME = "maid_name";

    public Button maidOrder;
    public ImageView mPic;
    public TextView mName, mSpecialization, mArea, mLang, mDesc, mSal, mRCount;
    public ProgressBar progressBar;
    public RatingBar maidRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Maid Details");


        mPic = (ImageView) findViewById(R.id.maidPic);
        mName = (TextView) findViewById(R.id.maidName);
        mSpecialization = (TextView)findViewById(R.id.maidSpecialization);
        mArea = (TextView)findViewById(R.id.maidCircle);
        mLang = (TextView)findViewById(R.id.maidLang);
        mDesc = (TextView) findViewById(R.id.maidWork);
        mSal = (TextView) findViewById(R.id.maidCharges);
        mRCount = (TextView)findViewById(R.id.ratingcount);
        progressBar = (ProgressBar)findViewById(R.id.maidrating);

        maidRatingBar = (RatingBar)findViewById(R.id.ratingBar);
        maidRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                Toast.makeText(DetailActivity.this, "Rated Successfully", Toast.LENGTH_SHORT).show();
                maidRatingBar.setEnabled(false);
            }
        });

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(MaidListActivity.EXTRA_URL);
        String name = intent.getStringExtra(EXTRA_NAME);
        String area = intent.getStringExtra(EXTRA_AREA);
        String cat1 = intent.getStringExtra(EXTRA_CATEGORY1);
        String cat2 = intent.getStringExtra(EXTRA_CATEGORY2);
        String lang1 = intent.getStringExtra(EXTRA_LANGUAGE1);
        String lang2 = intent.getStringExtra(EXTRA_LANGUAGE2);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        String price = intent.getStringExtra(EXTRA_PRICE);
        String rating = intent.getStringExtra(EXTRA_RATING);

        Picasso.with(this).load(imageUrl).placeholder(R.drawable.maiddefault).fit().centerInside().into(mPic);
        mName.setText(name);
        mSpecialization.setText(cat1 + ", " + cat2);
        mArea.setText(area);
        mLang.setText(lang1 + ", " + lang2);
        mDesc.setText(description);
        mSal.setText("Charges: Rs. "+ price + " (Inclusive of all taxes)");
        mRCount.setText(rating);
        maidOrder = (Button)findViewById(R.id.bookMaid);

        maidOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceOrder(v);
                Log.v("working................" , "maybe");
            }
        });
    }

    public void PlaceOrder(View v){
        Intent i=new Intent(this,OrderActivity.class);
        i.putExtra(EXTRA_MNAME, mName.getText());
        startActivity(i);
    }


}
