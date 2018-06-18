package mayanksghrathore.example.com.myhelpwali;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class PostUserData extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    ProgressDialog progressDialog;

    PostUserData(Context ctx){ //constructor
        context=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Submitting your responses...", "This might take few seconds",true,true);
    }

    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];

        String submit_url="http://helpwali.tk/1dbaccess/submitresp.php";

        if(type=="submit"){
            String Fname = strings[1];
            String Lname = strings[2];
            String Adhar = strings[3];
            String Contact = strings[4];
            String AddL1 = strings[5];
            String AddL2 = strings[6];
            String Pin = strings[7];
            String MName = strings [8];

            try {
                URL url = new URL(submit_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data =
                        URLEncoder.encode("FNAME", "UTF-8") + "=" + URLEncoder.encode(Fname, "UTF-8") + "&"
                                + URLEncoder.encode("LNAME", "UTF-8") + "=" + URLEncoder.encode(Lname, "UTF-8") + "&"
                                + URLEncoder.encode("ADHAR", "UTF-8") + "=" + URLEncoder.encode(Adhar, "UTF-8") + "&"
                                + URLEncoder.encode("CONTACT", "UTF-8") + "=" + URLEncoder.encode(Contact, "UTF-8") + "&"
                                +  URLEncoder.encode("ADDL1", "UTF-8") + "=" + URLEncoder.encode(AddL1, "UTF-8") + "&"
                                + URLEncoder.encode("ADDL2", "UTF-8") + "=" + URLEncoder.encode(AddL2, "UTF-8") + "&"
                                + URLEncoder.encode("PIN", "UTF-8") + "=" + URLEncoder.encode(Pin, "UTF-8") + "&"
                                + URLEncoder.encode("MNAME", "UTF-8") + "=" + URLEncoder.encode(MName, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if(s.equals("Insert Successful")){
            Intent i = new Intent(context, PaymentActivity.class);
            context.startActivity(i);
        }
        else{
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }    }
}
