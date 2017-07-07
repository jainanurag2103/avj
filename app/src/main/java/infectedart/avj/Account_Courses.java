package infectedart.avj;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Account_Courses extends Functions {
    private AdView mAdView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__courses);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        Training accounts1 = new Training("Tally.Erp 9  Advance + MS Excel","45 Days","5000/-","All Accounting Vouchers\nInventories\nBank Reconcilation\nMS Excel\nOther Reports","Accounts");
        Training accounts2 = new Training("Tally.Erp 9  Advance Practical Course","90 Days","10000/-","All Accounting Vouchers\nInventories\nBank Reconcilation\nInvoicing\nAdvance MS Excel\nOther Reports\nPersonal Net Banking\n\nTaxation:\nGST\nIncome Tax \nTDS Work\n\n*Tax: Deduction Entry+Challan Deposit+ TDS Return","Accounts");
        ArrayList<Training> allAccTrainingList = new ArrayList<>();
        allAccTrainingList.add(accounts1);
        allAccTrainingList.add(accounts2);

        AccountTrainingAdapter adapter = new AccountTrainingAdapter(allAccTrainingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Account_Courses.this);
        RecyclerView accTrainingRecycler = (RecyclerView) findViewById(R.id.acc_training_recycler_view);
        accTrainingRecycler.setLayoutManager(layoutManager);
        accTrainingRecycler.setAdapter(adapter);
    }
}
