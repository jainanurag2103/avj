package infectedart.avj;

/**
 * Created by jaina on 7/4/2017.
 */

public class AllITServices {
    private String it_serv_name;
    private String it_serv_detail;

    public AllITServices(String it_serv_name, String it_serv_detail) {
        this.it_serv_name = it_serv_name;
        this.it_serv_detail = it_serv_detail;
    }

    public AllITServices() {
    }

    public String getIt_serv_name() {
        return it_serv_name;
    }

    public void setIt_serv_name(String it_serv_name) {
        this.it_serv_name = it_serv_name;
    }

    public String getIt_serv_detail() {
        return it_serv_detail;
    }

    public void setIt_serv_detail(String it_serv_detail) {
        this.it_serv_detail = it_serv_detail;
    }
}
