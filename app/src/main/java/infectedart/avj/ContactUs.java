package infectedart.avj;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.net.URL;

public class ContactUs extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();
    }

    public void submit_contact_us_query(View view) {
        EditText name = (EditText) findViewById(R.id.name_content);
        EditText mobile = (EditText) findViewById(R.id.phone_content);
        EditText email = (EditText) findViewById(R.id.email_content);
        EditText msg = (EditText) findViewById(R.id.msg_content);

        if (name.getText().toString().trim().equals("")) {
            name.setError("Name is required!");
        } else if (mobile.getText().toString().trim().equals("")) {
            mobile.setError("Mobile No. is required!");
        } else if (mobile.getText().toString().length() != 10) {
            mobile.setError("Invalid Mobile No.!");
        } else if (msg.getText().toString().trim().equals("")) {
            msg.setError("Message is required!");
        } else {
            String name_text = name.getText().toString();
            String mobile_text = mobile.getText().toString();
            String email_text = email.getText().toString();
            String msg_text = msg.getText().toString();
            String[] data = {name_text, mobile_text, email_text, msg_text};

            try {
                ContactUs.NetworkConnection connection = new ContactUs.NetworkConnection();
                connection.execute(data);
            } catch (Exception e) {
                e.printStackTrace();
                displayExceptionMessage(e.getMessage());
            }
        }
    }

    public void displayExceptionMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /***********************************************************************
     NetworkConnection Class to connect to PHP Server
     ***********************************************************************/

    private class NetworkConnection extends AsyncTask<String, Void, String> {
        private ProgressDialog pdia;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdia = new ProgressDialog(ContactUs.this);
            pdia.setMessage("Please Wait...");
            pdia.setCancelable(false);
            pdia.setCanceledOnTouchOutside(false);
            pdia.show();
        }

        @Override
        protected String doInBackground(String[] data) {
            //Check Internet connection
            boolean isNetworkAvailable = isNetworkAvailable();
            if (isNetworkAvailable) {
                boolean mail = send_contact_mail(data);
                //Log.println(Log.ERROR,"Returned mail value ",String.valueOf(mail));
                if (mail) {
                    return "We have received your query.\n We will contact you soon.";
                } else {
                    return "Unusual Error. Try again later.";
                }
            } else {
                return "No internet connectivity.\n Try again later.";
            }
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            EditText name = (EditText) findViewById(R.id.name_content);
            EditText mobile = (EditText) findViewById(R.id.phone_content);
            EditText email = (EditText) findViewById(R.id.email_content);
            EditText msg = (EditText) findViewById(R.id.msg_content);
            name.setText("");
            mobile.setText("");
            email.setText("");
            msg.setText("");
            pdia.dismiss();
            Toast.makeText(ContactUs.this, result, Toast.LENGTH_LONG).show();
        }

        protected boolean send_contact_mail(String[] data) {
            String url = "http://www.infectedart.in/avj/home.php?action=contact&name=" + data[0] + "&mobile=" + data[1] + "&email=" + data[2] + "&message=" + data[3];
            URL uri;
            try {
                uri = new URL(url.replace("'", "").replace("\"", "").replace("\n", " ").replace(" ", "%20"));
            } catch (Exception e) {
                return false;
            }
            Log.println(Log.ERROR, "URL ", uri.toString());
            try {
                JSONObject jsonObject;
                JSONParser jsonParser = new JSONParser();
                jsonObject = jsonParser.getJSONFromUrl(uri.toString());
                String id = jsonObject.getString("id");

                Log.println(Log.ERROR, "Returned from site ", id);
                //Integer id = jsonObject.getInt("id");
                if (id == "true") {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
