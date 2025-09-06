package com.google.gson;

import W7.a;
import W7.b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class l extends E {
    public final int a;
    public final E b;

    public l(E e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(this.a != 0) {
            ArrayList arrayList0 = new ArrayList();
            a0.h();
            while(a0.E()) {
                arrayList0.add(((Number)this.b.b(a0)).longValue());
            }
            a0.q();
            int v = arrayList0.size();
            AtomicLongArray atomicLongArray0 = new AtomicLongArray(v);
            for(int v1 = 0; v1 < v; ++v1) {
                atomicLongArray0.set(v1, ((long)(((Long)arrayList0.get(v1)))));
            }
            return atomicLongArray0;
        }
        return new AtomicLong(((Number)this.b.b(a0)).longValue());
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(this.a != 0) {
            b0.m();
            int v = ((AtomicLongArray)object0).length();
            for(int v1 = 0; v1 < v; ++v1) {
                Long long0 = ((AtomicLongArray)object0).get(v1);
                this.b.c(b0, long0);
            }
            b0.q();
            return;
        }
        Long long1 = ((AtomicLong)object0).get();
        this.b.c(b0, long1);
    }
}

