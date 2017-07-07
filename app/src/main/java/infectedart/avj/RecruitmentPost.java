package infectedart.avj;

/**
 * Created by Infected on 13-Jun-17.
 */

public class RecruitmentPost {
    private Integer post_id;
    private String post_name;
    private String post_charges;

    public RecruitmentPost() {
    }

    public RecruitmentPost(String post_name, String post_charges) {
        this.post_name = post_name;
        this.post_charges = post_charges;
    }

    public RecruitmentPost(Integer post_id, String post_charges, String post_name) {
        this.post_id = post_id;
        this.post_charges = post_charges;
        this.post_name = post_name;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getPost_charges() {
        return post_charges;
    }

    public void setPost_charges(String post_charges) {
        this.post_charges = post_charges;
    }
}
