package infectedart.avj;

import android.os.Bundle;

public class DeveloperProfile extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_profile);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

    }
}
