package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.util.Calendar;
import java.util.GregorianCalendar;

class TypeAdapters.31 implements F {
    public final L a;

    public TypeAdapters.31(L l0) {
        this.a = l0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Class class0 = typeToken0.getRawType();
        return class0 != Calendar.class && class0 != GregorianCalendar.class ? null : this.a;
    }

    // 去混淆评级： 中等(120)
    @Override
    public final String toString() {
        return "Factory[type=java.util.Calendar+java.util.GregorianCalendar,adapter=" + this.a + "]";
    }
}

