package infectedart.avj;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ITServices extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itservices);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        AllITServices it_serv1 = new AllITServices("Website Development","Static/Dynamic Websites\nPrice: 6000/- onwards\nFor more details Contact Us.");
        AllITServices it_serv2 = new AllITServices("Android App Development","Price: 5000/- onwards\nFor more details Contact Us.");
        ArrayList<AllITServices> all_serv = new ArrayList<>();
        all_serv.add(it_serv1);
        all_serv.add(it_serv2);
        ITServicesAdapter adapter = new ITServicesAdapter(all_serv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ITServices.this);
        RecyclerView accTrainingRecycler = (RecyclerView) findViewById(R.id.it_services_recycler_view);
        accTrainingRecycler.setLayoutManager(layoutManager);
        accTrainingRecycler.setAdapter(adapter);

    }
}
