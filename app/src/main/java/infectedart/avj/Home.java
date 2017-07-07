package infectedart.avj;
import android.os.Bundle;

public class Home extends Functions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

    }

    @Override
    public void onBackPressed() {
        finish();
        moveTaskToBack(false);
    }
}
