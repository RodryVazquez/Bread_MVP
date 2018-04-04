package bread.example.com.bread_mvp.Model;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public class BreadModel {

    int id;
    String fullName;
    String mail;
    String phoneNumber;
    String token;
    int breadIndex;
    boolean isMyBreadTurn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getBreadIndex() {
        return breadIndex;
    }

    public void setBreadIndex(int breadIndex) {
        this.breadIndex = breadIndex;
    }

    public boolean isMyBreadTurn() {
        return isMyBreadTurn;
    }

    public void setMyBreadTurn(boolean myBreadTurn) {
        isMyBreadTurn = myBreadTurn;
    }
}
