package com.google.android.flexbox;

import androidx.appcompat.app.o;

public final class c implements Comparable {
    public int a;
    public int b;

    @Override
    public final int compareTo(Object object0) {
        int v = this.b;
        int v1 = ((c)object0).b;
        return v == v1 ? this.a - ((c)object0).a : v - v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Order{order=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", index=");
        return o.q(stringBuilder0, this.a, '}');
    }
}

