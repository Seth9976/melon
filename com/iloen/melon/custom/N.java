package com.iloen.melon.custom;

public final class n {
    public final t a;

    public n(t t0) {
        this.a = t0;
    }

    public final int a() {
        return this.a.getCount() <= 1 ? this.a.getCount() : (6000 - 6000 % (this.a.getCount() * 3)) * 2;
    }

    public final int b(int v, int v1) {
        t t0 = this.a;
        if(t0.getCount() > 1) {
            int v2 = this.a();
            int v3 = this.c(v1);
            if(t0.getCount() > 1) {
                v1 %= t0.getCount() * 3;
            }
            int v4 = v1 / t0.getCount();
            int v5 = (t0.getCount() <= 1 ? v2 / 2 : v2 / 2 % (t0.getCount() * 3)) / t0.getCount();
            int v6 = 0;
            if(v > v3) {
                int v7 = this.c(v);
                if(v4 == v5) {
                    v6 = t0.getCount();
                }
                return v7 + v2 / 2 + v6;
            }
            int v8 = this.c(v);
            if(v4 == v5) {
                v6 = t0.getCount();
            }
            return v8 + v2 / 2 - v6;
        }
        return v;
    }

    public final int c(int v) {
        return this.a.getCount() <= 1 ? v : v % this.a.getCount();
    }
}

