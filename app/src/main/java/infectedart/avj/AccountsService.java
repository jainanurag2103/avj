package infectedart.avj;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class AccountsService extends Functions {
    private RecyclerView sectionHeader;
    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_service);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        sectionHeader = (RecyclerView) findViewById(R.id.add_header);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AccountsService.this);
        sectionHeader.setLayoutManager(linearLayoutManager);
        sectionHeader.setHasFixedSize(true);

        List<ItemObject> accounting_work = new ArrayList<>();
        List<ItemObject> returns = new ArrayList<>();
        List<ItemObject> registration = new ArrayList<>();

        AllAccountingServices allAccServ = new AllAccountingServices(accounting_work, returns, registration);

        HeaderRecyclerViewSection firstSection = new HeaderRecyclerViewSection("Accounting Work", allAccServ.getAccounting_work());
        HeaderRecyclerViewSection secondSection = new HeaderRecyclerViewSection("Return eFiling", allAccServ.getReturns());
        HeaderRecyclerViewSection thirdSection = new HeaderRecyclerViewSection("Registration", allAccServ.getRegistration());

        sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(firstSection);
        sectionAdapter.addSection(secondSection);
        sectionAdapter.addSection(thirdSection);
        sectionHeader.setAdapter(sectionAdapter);
    }
}
