package com.iloen.melon.utils.contacts;

public class ContactInfo {
    public String a;
    public String b;

    public String getDisplayName() {
        return this.a;
    }

    public String getPhoneNumber() {
        return this.b;
    }

    public void setDisplayName(String s) {
        this.a = s;
    }

    public void setPhoneNumber(String s) {
        this.b = s;
    }
}

