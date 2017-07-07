package infectedart.avj;

/**
 * Created by Infected on 12-Jun-17.
 */

public class Training {
    private Integer training_id;
    private String training_name;
    private String training_duration;
    private String training_fee;
    private String training_desc;
    private String training_category;

    public Training() {}

    public Training(Integer training_id, String training_name, String training_duration, String training_fee, String training_desc, String training_category) {
        this.training_id = training_id;
        this.training_name = training_name;
        this.training_duration = training_duration;
        this.training_fee = training_fee;
        this.training_desc = training_desc;
        this.training_category = training_category;
    }

    public Training(String training_name, String training_duration, String training_fee, String training_desc, String training_category) {
        this.training_name = training_name;
        this.training_duration = training_duration;
        this.training_fee = training_fee;
        this.training_desc = training_desc;
        this.training_category = training_category;
    }

    public Integer getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Integer training_id) {
        this.training_id = training_id;
    }

    public String getTraining_name() {
        return training_name;
    }

    public void setTraining_name(String training_name) {
        this.training_name = training_name;
    }

    public String getTraining_duration() {
        return training_duration;
    }

    public void setTraining_duration(String training_duration) {
        this.training_duration = training_duration;
    }

    public String getTraining_fee() {
        return training_fee;
    }

    public void setTraining_fee(String training_fee) {
        this.training_fee = training_fee;
    }

    public String getTraining_desc() {
        return training_desc;
    }

    public void setTraining_desc(String training_desc) {
        this.training_desc = training_desc;
    }

    public String getTraining_category() {
        return training_category;
    }

    public void setTraining_category(String training_category) {
        this.training_category = training_category;
    }
}
