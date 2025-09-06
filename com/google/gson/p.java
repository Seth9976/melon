package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class p extends q implements Iterable {
    public final ArrayList a;

    public p() {
        this.a = new ArrayList();
    }

    @Override  // com.google.gson.q
    public final String b() {
        ArrayList arrayList0 = this.a;
        int v = arrayList0.size();
        if(v != 1) {
            throw new IllegalStateException("Array must have size 1, but has size " + v);
        }
        return ((q)arrayList0.get(0)).b();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof p && ((p)object0).a.equals(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final Iterator iterator() {
        return this.a.iterator();
    }
}

