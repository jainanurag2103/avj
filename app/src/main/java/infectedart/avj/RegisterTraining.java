package infectedart.avj;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.net.URL;

public class RegisterTraining extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_training);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        String training_name = intent.getStringExtra("training_name");
        String duration = intent.getStringExtra("duration");
        String training_fee = intent.getStringExtra("training_fee");
        String training_desc = intent.getStringExtra("training_desc");
        String training_detail = duration+" ("+training_fee+")";

        TextView reg_training_name_content = (TextView) findViewById(R.id.reg_training_name_content);
        TextView reg_training_detail_content = (TextView) findViewById(R.id.reg_training_detail_content);

        reg_training_name_content.setText(training_name);
        reg_training_detail_content.setText(training_detail);
    }
    public void displayExceptionMessage(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void submit_registration(View view){
        TextView reg_training_name = (TextView) findViewById(R.id.reg_training_name_content);
        EditText reg_applicant_name = (EditText) findViewById(R.id.name_content);
        EditText reg_mobile = (EditText) findViewById(R.id.phone_content);
        EditText reg_email = (EditText) findViewById(R.id.email_content);
        EditText reg_message = (EditText) findViewById(R.id.msg_content);

        if( reg_applicant_name.getText().toString().trim().equals("")){
            reg_applicant_name.setError( "Name is required!");
        } else if(reg_mobile.getText().toString().trim().equals("")){
            reg_mobile.setError( "Mobile No. is required!" );
        } else if(reg_mobile.getText().toString().length() != 10){
            reg_mobile.setError( "Invalid Mobile No.!" );
        } else {
            String training_name = reg_training_name.getText().toString();
            String applicant_name = reg_applicant_name.getText().toString();
            String mobile = reg_mobile.getText().toString();
            String email = reg_email.getText().toString();
            String message = reg_message.getText().toString();

            String[] data = {training_name, applicant_name, mobile, email, message};

            try {
                NetworkConnection connection = new NetworkConnection();
                connection.execute(data);
            } catch (Exception e) {
                e.printStackTrace();
                displayExceptionMessage(e.getMessage());
            }
        }
    }

/*    public void loadRegInfo(View view){
        final Dialog infoDialog = new Dialog(RegisterTraining.this);
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.setContentView(R.layout.info_dialog_layout);
        infoDialog.setCancelable(true);
        infoDialog.show();
    }*/
    /***********************************************************************
     NetworkConnection Class to connect to PHP Server
     ***********************************************************************/

    private class NetworkConnection extends AsyncTask<String, Void, String> {
        private ProgressDialog pdia;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdia = new ProgressDialog(RegisterTraining.this);
            pdia.setMessage("Processing Registration...");
            pdia.setCancelable(false);
            pdia.setCanceledOnTouchOutside(false);
            pdia.show();
        }
        @Override
        protected String doInBackground(String[] data) {
            //Check Internet connection
            boolean isNetworkAvailable = isNetworkAvailable();
            if(isNetworkAvailable){
                boolean mail = send_reg_mail(data);
                //Log.println(Log.ERROR,"Returned mail value ",String.valueOf(mail));
                if(mail){
                    return "We have received your registration.\n We will contact you soon.";
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
            Toast.makeText(RegisterTraining.this, result, Toast.LENGTH_LONG).show();
        }
        protected boolean send_reg_mail(String[] data){
            String url = "http://www.infectedart.in/avj/home.php?action=training&training_name="+data[0]+"&applicant_name="+data[1]+"&mobile="+data[2]+"&email="+data[3]+"&message="+data[4];
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
