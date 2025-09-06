package com.google.gson.internal.sql;

import com.google.gson.F;
import java.sql.Date;
import java.sql.Timestamp;

public abstract class c {
    public static final boolean a;
    public static final b b;
    public static final b c;
    public static final F d;
    public static final F e;
    public static final F f;

    static {
        c.a = true;
        c.b = new b(Date.class, 0);
        c.c = new b(Timestamp.class, 1);
        c.d = SqlDateTypeAdapter.b;
        c.e = SqlTimeTypeAdapter.b;
        c.f = a.b;
    }
}

