package com.google.protobuf;

public final class f1 {
    public final Object a;
    public final int b;

    public f1(int v, l2 l20) {
        this.a = l20;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof f1 ? this.a == ((f1)object0).a && this.b == ((f1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.a) * 0xFFFF + this.b;
    }
}

