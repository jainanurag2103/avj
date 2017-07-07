package infectedart.avj;

import android.os.Bundle;

public class Courses extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();
    }
}
