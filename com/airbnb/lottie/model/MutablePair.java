package com.airbnb.lottie.model;

import b2.b;
import va.e;

public class MutablePair {
    Object first;
    Object second;

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof b ? MutablePair.objectsEqual(((b)object0).a, this.first) && MutablePair.objectsEqual(((b)object0).b, this.second) : false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.first == null ? 0 : this.first.hashCode();
        Object object0 = this.second;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 ^ v;
    }

    // 去混淆评级： 低(20)
    private static boolean objectsEqual(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public void set(Object object0, Object object1) {
        this.first = object0;
        this.second = object1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Pair{");
        stringBuilder0.append(this.first);
        stringBuilder0.append(" ");
        return e.d(stringBuilder0, this.second, "}");
    }
}

