package infectedart.avj;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends Functions {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadStausBarModifications();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent launchNextActivity;
                launchNextActivity = new Intent(getBaseContext(),Home.class);
                startActivity(launchNextActivity);
                finish();
                Toast.makeText(MainActivity.this, "Welcome to AVJ", Toast.LENGTH_SHORT).show();
            }
        }, 3000);
    }
}
