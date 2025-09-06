package com.gaa.sdk.iap;

import android.text.TextUtils;
import org.json.JSONObject;

public final class k {
    public final String a;
    public final JSONObject b;
    public final String c;
    public final String d;

    public k(String s, String s1, String s2) {
        this.a = s;
        this.c = s1;
        this.d = s2;
        this.b = new JSONObject(s);
    }

    public final boolean a() {
        return this.b.optInt("acknowledgeState", 0) == 1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? TextUtils.equals(this.a, ((k)object0).a) && TextUtils.equals(this.c, ((k)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "PurchaseData. Json: " + this.a;
    }
}

