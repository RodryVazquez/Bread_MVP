package bread.example.com.bread_mvp.Model;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public class StoreModel {

    int id;
    String name;
    String description;
    long longitude;
    long latitude;
    boolean satisfactionGuarantee;
    String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public boolean isSatisfactionGuarantee() {
        return satisfactionGuarantee;
    }

    public void setSatisfactionGuarantee(boolean satisfactionGuarantee) {
        this.satisfactionGuarantee = satisfactionGuarantee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
