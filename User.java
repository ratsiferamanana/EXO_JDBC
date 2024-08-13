package org.StudentPortail;

public class User {
    private String Id;
    private String userName;
    private String phone;
    private String email;
    private String address;

    public User(String id, String userName, String phone, String email, String address) {
        Id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
