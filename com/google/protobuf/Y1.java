package com.google.protobuf;

public final class y1 extends d1 {
    public final l2 a;
    public final Object b;
    public final l2 c;
    public final x1 d;

    public y1(l2 l20, Object object0, l2 l21, x1 x10) {
        if(l20 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if(x10.b == j3.f && l21 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.a = l20;
        this.b = object0;
        this.c = l21;
        this.d = x10;
    }

    public final Object a(Object object0) {
        if(this.d.b.a != k3.i) {
            return object0;
        }
        ((Integer)object0).intValue();
        throw null;
    }

    public final Object b(Object object0) {
        return this.d.b.a == k3.i ? ((G1)object0).a() : object0;
    }
}

