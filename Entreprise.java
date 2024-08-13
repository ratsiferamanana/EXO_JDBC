package org.StudentPortail;

import java.util.Date;

public class Entreprise extends User{
    private String nifStat;
    private Date dateCreation;
    private String description;
    public Entreprise(String id, String userName, String phone, String email, String address) {
        super(id, userName, phone, email, address);
    }
}

