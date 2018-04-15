package com.r.seminarevent.Data;

/**
 * Created by Unknown on 3/25/2018.
 */

public class UserRegistration {

    private String user_id;
    private String user_fullname;
    private String user_email;
    private String user_password;
    private String user_phone;

    public UserRegistration(String user_fullname, String user_email, String user_password, String user_phone) {
        this.user_fullname = user_fullname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phone = user_phone;
    }

    public String getUser_id() {
        return user_id;
    }
}
