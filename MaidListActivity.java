package mayanksghrathore.example.com.myhelpwali;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MaidListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,MaidAdapter.OnItemClickListener {

    public RecyclerView recyclerView;
    public MaidAdapter maidAdapter;
    private List<ListItemModel> listItems;

    public static final String EXTRA_URL = "picture_url";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_AREA = "area";
    public static final String EXTRA_CATEGORY1 = "category1";
    public static final String EXTRA_CATEGORY2 = "category2";
    public static final String EXTRA_LANGUAGE1 = "language1";
    public static final String EXTRA_LANGUAGE2 = "language2";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_PRICE = "salary";
    public static final String EXTRA_RATING = "rating";

    private static final String URL_DATA = "http://www.helpwali.tk/1dbaccess/connect_local.php?mid=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Available Maids");



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        recyclerView operations start here

        recyclerView = (RecyclerView) findViewById(R.id.maid_rview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listItems = new ArrayList<>();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);

                                ListItemModel item = new ListItemModel(
                                        o.getString("picture_url"),
                                        o.getString("name"),
                                        o.getString("area"),
                                        o.getString("category1"),
                                        o.getString("category2"),
                                        o.getString("language1"),
                                        o.getString("language2"),
                                        o.getString("description"),
                                        o.getString("salary"),
                                        o.getString("rating")
                                );

                                listItems.add(item);
                            }
                            maidAdapter = new MaidAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(maidAdapter);
                            maidAdapter.setOnItemClickListener((MaidAdapter.OnItemClickListener) MaidListActivity.this);

                            progressDialog.dismiss();

                            ImageView img = (ImageView) findViewById(R.id.default_placeholder);
                            img.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Error has occurred...", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ListItemModel clickedItem = listItems.get(position);
        detailIntent.putExtra(EXTRA_URL, clickedItem.getPicture_url());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getName());
        detailIntent.putExtra(EXTRA_AREA,clickedItem.getArea());
        detailIntent.putExtra(EXTRA_CATEGORY1,clickedItem.getCategory1());
        detailIntent.putExtra(EXTRA_CATEGORY2,clickedItem.getCategory2());
        detailIntent.putExtra(EXTRA_LANGUAGE1,clickedItem.getLanguage1());
        detailIntent.putExtra(EXTRA_LANGUAGE2,clickedItem.getLanguage2());
        detailIntent.putExtra(EXTRA_DESCRIPTION, clickedItem.getDescription());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getSalary());
        detailIntent.putExtra(EXTRA_RATING,clickedItem.getRating());
        startActivity(detailIntent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maid_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, UserSettings.class));
        }
        else if(id == R.id.action_logout){
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(
                    this, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Logout")
                    .setMessage("Do you want to logout?")
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(this, CategoryActivity.class));
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, UserProfile.class));
        } else if (id == R.id.nav_orders) {
            startActivity(new Intent(this, UserOrders.class));


        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, UserSettings.class));


        } else if (id == R.id.nav_logout) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(
                    this, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Logout")
                    .setMessage("Do you want to logout?")
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


        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_contact){
            Toast.makeText(this, "Sorry! Not available now.", Toast.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
