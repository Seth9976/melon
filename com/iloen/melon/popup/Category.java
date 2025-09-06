package com.iloen.melon.popup;

import org.json.JSONObject;

public class Category {
    public final String a;
    public final String b;
    public final String c;
    public JSONObject d;

    public Category(String s, String s1) {
        this.b = s;
        this.c = s1;
    }

    public Category(String s, String s1, String s2) {
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    public String getId() {
        return this.b;
    }

    public JSONObject getJSONObjectChild() {
        return this.d;
    }

    public String getName() {
        return this.c;
    }

    public String getNum() {
        return this.a;
    }

    public void setJSONObjectChild(JSONObject jSONObject0) {
        this.d = jSONObject0;
    }
}

