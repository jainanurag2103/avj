package infectedart.avj;

import java.util.List;

/**
 * Created by Infected on 11-Jun-17.
 */

public class AllAccountingServices {
    private List<ItemObject> accounting_work;
    private List<ItemObject> returns;
    private List<ItemObject> registration;

    public AllAccountingServices(List<ItemObject> accounting_work, List<ItemObject> returns, List<ItemObject> registration) {

        accounting_work.add(new ItemObject("Personal Accounting - Individual"));
        accounting_work.add(new ItemObject("Business Accounting - Individual"));
        //accounting_work.add(new ItemObject("Other Account Work"));
        this.accounting_work = accounting_work;

        returns.add(new ItemObject("Income Tax - Individual"));
        returns.add(new ItemObject("Income Tax - Business"));
        returns.add(new ItemObject("TDS"));
        returns.add(new ItemObject("GST"));
        this.returns = returns;

        registration.add(new ItemObject("PAN"));
        registration.add(new ItemObject("TAN"));
        registration.add(new ItemObject("GST"));
        registration.add(new ItemObject("DSC"));
        registration.add(new ItemObject("Company Incorporation / LLP"));
        registration.add(new ItemObject("Import/Export Regd."));
        registration.add(new ItemObject("Trust - Without 80G"));
        registration.add(new ItemObject("Trust - With 80G"));
        registration.add(new ItemObject("Firm Regd."));
        registration.add(new ItemObject("Shop Act"));
        this.registration = registration;
    }

    public List<ItemObject> getAccounting_work() {
        return accounting_work;
    }

    public List<ItemObject> getReturns() {
        return returns;
    }

    public List<ItemObject> getRegistration() {
        return registration;
    }
}
