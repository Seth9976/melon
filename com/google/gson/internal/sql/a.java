package com.google.gson.internal.sql;

import W7.b;
import com.google.gson.E;
import com.google.gson.F;
import java.sql.Timestamp;
import java.util.Date;

public final class a extends E {
    public final E a;
    public static final F b;

    static {
        a.b = new SqlTimestampTypeAdapter.1();
    }

    public a(E e0) {
        this.a = e0;
    }

    @Override  // com.google.gson.E
    public final Object b(W7.a a0) {
        Date date0 = (Date)this.a.b(a0);
        return date0 != null ? new Timestamp(date0.getTime()) : null;
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        this.a.c(b0, ((Timestamp)object0));
    }
}

