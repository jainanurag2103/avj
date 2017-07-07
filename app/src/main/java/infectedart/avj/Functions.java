package infectedart.avj;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by jaina on 7/5/2017.
 */

public class Functions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AdView mAdView;
    private AdRequest adRequest;
    private NavigationView navigationView;
    //private SmoothActionBarDrawerToggle mDrawerToggle;

    /*****************************************************************************************
     ********************* Ad load Function **************************************************
     *****************************************************************************************/
    public void loadAd() {


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3120452316793136~1061061208");
        mAdView = (AdView) findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                //.addTestDevice("C92F22E5475D66D6E8E33DD6D002F36A")  // An example device ID
                //.build();
        mAdView.loadAd(adRequest);
    }

    /*****************************************************************************************
     ********************* Navigation Drawer load Function ***********************************
     *****************************************************************************************/

    public void loadNavigationDrawerOnClickListner() {

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageView toggleDrawer = (ImageView) findViewById(R.id.openDrawer);
        toggleDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDrawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);

        int id = item.getItemId();
        Intent intent = null;
        if (id == R.id.menu_acc_serv) {
            intent = new Intent(this, AccountsService.class);
        } else if (id == R.id.menu_it_serv) {
            intent = new Intent(this, ITServices.class);
        } else if (id == R.id.menu_trainings) {
            intent = new Intent(this, Courses.class);
        } else if (id == R.id.menu_rec) {
            intent = new Intent(this, RecruitmentActivity.class);
        } else if (id == R.id.menu_cont_us) {
            intent = new Intent(this, ContactUs.class);
        } else if (id == R.id.menu_about_us) {
            intent = new Intent(this, AboutUs.class);
        } else if (id == R.id.menu_dev_prof) {
            intent = new Intent(this, DeveloperProfile.class);
        } else if (id == R.id.menu_share_app) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "AVJ Accounting Services");
            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=infectedart.avj");
        }
        final Intent intentFinal = intent;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intentFinal);
            }
        }, 230);
        return true;
    }

    /*****************************************************************************************
     ********************* Status Bar Modification Function **********************************
     *****************************************************************************************/

    public void loadStausBarModifications() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // finally change the color
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
    }

    /*****************************************************************************************
     ********************* Main Functions ****************************************************
     *****************************************************************************************/

    public void loadHome(View view) {
        Intent launchNextActivity;
        launchNextActivity = new Intent(this, Home.class);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(launchNextActivity);
    }

    public void loadAccountsServ(View view) {
        Intent intent = new Intent(this, AccountsService.class);
        startActivity(intent);
    }

    public void loadITServ(View view) {
        Intent intent = new Intent(this, ITServices.class);
        startActivity(intent);
    }

    public void loadCourses(View view) {
        Intent intent = new Intent(this, Courses.class);
        startActivity(intent);
    }

    public void loadRecruitment(View view) {
        Intent intent = new Intent(this, RecruitmentActivity.class);
        startActivity(intent);
    }

    public void loadAboutUs(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
    public void loadContactUs(View view) {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }
    public void loadAccountCourses(View view) {
        Intent intent = new Intent(this, Account_Courses.class);
        startActivity(intent);
    }
    public void loadITCourses(View view){
        Intent intent = new Intent(this,IT_Courses.class);
        startActivity(intent);
    }
    public void loadDeveloperProfile(View view) {
        Intent intent = new Intent(this, DeveloperProfile.class);
        startActivity(intent);
    }

    public void download_go_tic_tac_toe(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=infectedart.gotictactoe"));
        startActivity(intent);
    }
    /*****************************************************************************************
     ********************* Network connection check ******************************************
     *****************************************************************************************/
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
