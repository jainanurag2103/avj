package infectedart.avj;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class IT_Courses extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__courses);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        Training it1 = new Training("Basic Computer","2 Months","1500/-","Basic Computer\nMS Office\nTyping (Hindi & English)","IT");

        ArrayList<Training> allAccTrainingList = new ArrayList<>();
        allAccTrainingList.add(it1);

        AccountTrainingAdapter adapter = new AccountTrainingAdapter(allAccTrainingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(IT_Courses.this);
        RecyclerView accTrainingRecycler = (RecyclerView) findViewById(R.id.acc_training_recycler_view);
        accTrainingRecycler.setLayoutManager(layoutManager);
        accTrainingRecycler.setAdapter(adapter);
    }
}
