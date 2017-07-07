package infectedart.avj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ServiceDetailsActivity extends Functions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);

        loadStausBarModifications();
        loadAd();
        loadNavigationDrawerOnClickListner();

        Intent intent = new Intent(getIntent());
        String title = intent.getStringExtra("title");
        int position = intent.getIntExtra("position",0);
        TextView heading = (TextView) findViewById(R.id.heading);
        TextView work_handled_content = (TextView) findViewById(R.id.work_handled_content);
        TextView price_content = (TextView) findViewById(R.id.price_content);
        TextView desc_content = (TextView) findViewById(R.id.desc_content);
        switch (title){
            case "Accounting Work":
                heading.setText("Accounting Work");
                switch (position){
                    case 0:
                        work_handled_content.setText("Personal Accounting - Individual");
                        price_content.setText("2000/- per annum");
                        desc_content.setText("Entries upto 375");
                        break;
                    case 1:
                        work_handled_content.setText("Business Accounting - Individual");
                        price_content.setText("1. 4000/- per annum\n2. 1000/- per month");
                        desc_content.setText("1. Entries upto 500\n2. Routine entries - approx. 1000 entries annually");
                        break;
                    //case 2:
                        //sub_heading.setText("Other Account Work");
                        //break;
                }
                break;
            case "Return eFiling":
                heading.setText("Return eFiling");
                switch (position){
                    case 0:
                        work_handled_content.setText("Income Tax - Individual");
                        price_content.setText("750/-");
                        desc_content.setText("Yearly");
                        break;
                    case 1:
                        work_handled_content.setText("Income Tax - Business");
                        price_content.setText("1250/-");
                        desc_content.setText("Yearly");
                        break;
                    case 2:
                        work_handled_content.setText("TDS");
                        price_content.setText("500/-");
                        desc_content.setText("Quarterly");
                        break;
                    case 3:
                        work_handled_content.setText("GST");
                        price_content.setText("1000/-");
                        desc_content.setText("Monthly");
                        break;
                }
                break;
            case "Registration":
                heading.setText("Registration");
                switch (position){
                    case 0:
                        work_handled_content.setText("PAN");
                        price_content.setText("200/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 1:
                        work_handled_content.setText("TAN");
                        price_content.setText("300/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 2:
                        work_handled_content.setText("GST");
                        price_content.setText("3000/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 3:
                        work_handled_content.setText("DSC");
                        price_content.setText("1000/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 4:
                        work_handled_content.setText("Company Incorporation / LLP");
                        price_content.setText("25000/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 5:
                        work_handled_content.setText("Import/Export Regd.");
                        price_content.setText("2500/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 6:
                        work_handled_content.setText("Trust - Without 80G");
                        price_content.setText("30000/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 7:
                        work_handled_content.setText("Trust - With 80G");
                        price_content.setText("50000/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 8:
                        work_handled_content.setText("Firm Regd.");
                        price_content.setText("2500/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                    case 9:
                        work_handled_content.setText("Shop Act");
                        price_content.setText("1500/-");
                        desc_content.setText("For more info Contact Us");
                        break;
                }
                break;
        }
    }
}
