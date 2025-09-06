package com.gaa.sdk.iap;

import U4.x;

public final class l {
    public final int a;
    public String b;
    public String c;
    public int d;
    public String e;

    public l(int v) {
        this.a = v;
        super();
    }

    @Override
    public String toString() {
        if(this.a != 1) {
            return super.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder("{javascript:");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", pattern:");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", patternIndex:");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", originNumber:");
        return x.m(stringBuilder0, this.e, "}");
    }
}

