package com.android.volley;

import U4.x;
import android.text.TextUtils;

public final class Header {
    private final String mName;
    private final String mValue;

    public Header(String s, String s1) {
        this.mName = s;
        this.mValue = s1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return Header.class == class0 && TextUtils.equals(this.mName, ((Header)object0).mName) && TextUtils.equals(this.mValue, ((Header)object0).mValue);
        }
        return false;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    @Override
    public int hashCode() {
        return this.mValue.hashCode() + this.mName.hashCode() * 0x1F;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Header[name=");
        stringBuilder0.append(this.mName);
        stringBuilder0.append(",value=");
        return x.m(stringBuilder0, this.mValue, "]");
    }
}

