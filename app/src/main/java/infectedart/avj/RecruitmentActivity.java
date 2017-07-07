package infectedart.avj;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class RecruitmentActivity extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        RecruitmentPost post1 = new RecruitmentPost("Accountant - Junior","5000/-");
        RecruitmentPost post2 = new RecruitmentPost("Accountant - Senior","10000/-");

        ArrayList<RecruitmentPost> all_posts = new ArrayList<>();
        all_posts.add(post1);
        all_posts.add(post2);

        RecruitmentAdapter recruitmentAdapter = new RecruitmentAdapter(all_posts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecruitmentActivity.this);
        RecyclerView recruitmentRecycler = (RecyclerView) findViewById(R.id.recruitmentRecycler);
        recruitmentRecycler.setLayoutManager(layoutManager);
        recruitmentRecycler.setAdapter(recruitmentAdapter);

    }
}
