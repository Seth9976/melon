package com.gaa.sdk.auth;

import android.text.TextUtils;

public final class e {
    public int a;
    public String b;

    public e(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException();
        }
        this.b = s;
        this.a = 1;
    }

    public boolean a() {
        return this.a == 0;
    }
}

