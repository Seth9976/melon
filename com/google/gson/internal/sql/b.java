package com.google.gson.internal.sql;

import com.google.gson.internal.bind.c;
import java.sql.Timestamp;
import java.util.Date;

public final class b extends c {
    public final int c;

    public b(Class class0, int v) {
        this.c = v;
        super(class0);
    }

    @Override  // com.google.gson.internal.bind.c
    public final Date b(Date date0) {
        return this.c != 0 ? new Timestamp(date0.getTime()) : new java.sql.Date(date0.getTime());
    }
}

