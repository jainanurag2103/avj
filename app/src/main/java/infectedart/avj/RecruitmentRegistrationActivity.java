package infectedart.avj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.net.URL;

public class RecruitmentRegistrationActivity extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_registration);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        String post_name = intent.getStringExtra("recruitment_post_name");

        TextView post = (TextView) findViewById(R.id.rec_post_name_content);
        post.setText(post_name);
    }
    public void displayExceptionMessage(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void submit_recruitment(View view){
        TextView rec_post_name_content = (TextView) findViewById(R.id.rec_post_name_content);
        EditText reg_applicant_name = (EditText) findViewById(R.id.name_content);
        EditText reg_mobile = (EditText) findViewById(R.id.phone_content);
        EditText reg_email = (EditText) findViewById(R.id.email_content);
        EditText reg_message = (EditText) findViewById(R.id.msg_content);

        String post_name = rec_post_name_content.getText().toString();
        String applicant_name = reg_applicant_name.getText().toString();
        String mobile = reg_mobile.getText().toString();
        String email = reg_email.getText().toString();
        String message = reg_message.getText().toString();

        if( reg_applicant_name.getText().toString().trim().equals("")){
            reg_applicant_name.setError( "Name is required!");
        } else if(reg_mobile.getText().toString().trim().equals("")){
            reg_mobile.setError( "Mobile No. is required!" );
        } else if(reg_mobile.getText().toString().length() != 10){
            reg_mobile.setError( "Invalid Mobile No.!" );
        } else if(reg_email.getText().toString().trim().equals("")){
            reg_email.setError( "Email is required!" );
        } else {
            String[] data = {post_name, applicant_name, mobile, email, message};

            try {
                RecruitmentRegistrationActivity.NetworkConnection connection = new RecruitmentRegistrationActivity.NetworkConnection();
                connection.execute(data);
            } catch (Exception e) {
                e.printStackTrace();
                displayExceptionMessage(e.getMessage());
            }
        }
    }
    /***********************************************************************
     NetworkConnection Class to connect to PHP Server
     ***********************************************************************/

    private class NetworkConnection extends AsyncTask<String, Void, String> {

        private ProgressDialog pdia;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdia = new ProgressDialog(RecruitmentRegistrationActivity.this);
            pdia.setMessage("Processing Application...");
            pdia.setCancelable(false);
            pdia.setCanceledOnTouchOutside(false);
            pdia.show();
        }
        @Override
        protected String doInBackground(String[] data) {
            //Check Internet connection
            boolean isNetworkAvailable = isNetworkAvailable();
            if(isNetworkAvailable){
                boolean mail = send_rec_mail(data);
                //Log.println(Log.ERROR,"Returned mail value ",String.valueOf(mail));
                if(mail){
                    return "We have received your application.\n We will contact you soon.";
                } else{
                    return "Unusual Error. Try again later.";
                }
            }else {
                return "No internet connectivity.\n Try again later.";
            }
        }
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            EditText reg_applicant_name = (EditText) findViewById(R.id.name_content);
            EditText reg_mobile = (EditText) findViewById(R.id.phone_content);
            EditText reg_email = (EditText) findViewById(R.id.email_content);
            EditText reg_message = (EditText) findViewById(R.id.msg_content);
            reg_applicant_name.setText("");
            reg_mobile.setText("");
            reg_email.setText("");
            reg_message.setText("");
            pdia.dismiss();
            Toast.makeText(RecruitmentRegistrationActivity.this, result, Toast.LENGTH_LONG).show();

        }
        protected boolean send_rec_mail(String[] data){
            String url = "http://www.infectedart.in/avj/home.php?action=recruitment&post_name="+data[0]+"&applicant_name="+data[1]+"&mobile="+data[2]+"&email="+data[3]+"&message="+data[4];
            URL uri;
            try{
                uri = new URL(url.replace("'","").replace("\"","").replace("\n"," ").replace(" ", "%20"));
            }catch(Exception e){
                return false;
            }
            Log.println(Log.ERROR,"URL ",uri.toString());
            try {
                JSONObject jsonObject;
                JSONParser jsonParser = new JSONParser();
                jsonObject = jsonParser.getJSONFromUrl(uri.toString());
                String id = jsonObject.getString("id");

                Log.println(Log.ERROR,"Returned from site ",id);
                //Integer id = jsonObject.getInt("id");
                if(id == "true"){
                    return true;
                } else {
                    return false;
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return false;
        }
    }
}
