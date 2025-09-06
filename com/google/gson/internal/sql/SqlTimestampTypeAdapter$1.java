package com.google.gson.internal.sql;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter.1 implements F {
    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        if(typeToken0.getRawType() == Timestamp.class) {
            n0.getClass();
            return new a(n0.g(TypeToken.get(Date.class)));
        }
        return null;
    }
}

