package com.google.gson.internal;

import H0.b;
import T7.d;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements F, Cloneable {
    public final List a;
    public final List b;
    public static final Excluder c;

    static {
        Excluder.c = new Excluder();
    }

    public Excluder() {
        this.a = Collections.EMPTY_LIST;
        this.b = Collections.EMPTY_LIST;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Class class0 = typeToken0.getRawType();
        boolean z = this.b(class0, true);
        boolean z1 = this.b(class0, false);
        return !z && !z1 ? null : new d(this, z1, z, n0, typeToken0);
    }

    public final boolean b(Class class0, boolean z) {
        if(!z && !Enum.class.isAssignableFrom(class0) && !Modifier.isStatic(class0.getModifiers()) && (class0.isAnonymousClass() || class0.isLocalClass())) {
            return true;
        }
        Iterator iterator0 = (z ? this.a : this.b).iterator();
        if(iterator0.hasNext()) {
            throw b.b(iterator0);
        }
        return false;
    }

    @Override
    public final Object clone() {
        try {
            return (Excluder)super.clone();
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new AssertionError(cloneNotSupportedException0);
        }
    }
}

