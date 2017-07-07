package infectedart.avj;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        TextView about_us_content = (TextView) findViewById(R.id.about_us_content);
        about_us_content.setText("At AVJ Accounting Services, we work with a passion and believe in delivering the very best." +
                "\n\nOur firm offers a wide range of services to our individual and business clients." +
                "\n\nWe believe in providing client with benefits by serving personalized quality services that are beyond comparison." +
                "\n\nWe provide various services like:\n\n" +
                "Accounting Services\n" +
                "Tax and Consulting Services\n" +
                "Website and App Development\n" +
                "Recruitment Services\n" +
                "PF Services\n" +
                "Training in Tally Advance\n");
    }
}
