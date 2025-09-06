package com.iloen.melon.types;

import U4.x;

public class Range {
    public final int a;

    public Range(int v) {
        this.a = v;
    }

    public final boolean a(int v) {
        return v >= 0 && v < this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof Range) {
            if(this != ((Range)object0)) {
                ((Range)object0).getClass();
                return this.a == ((Range)object0).a;
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Range {start=0, end=");
        int v = this.a;
        stringBuilder0.append(v);
        stringBuilder0.append(", size:");
        if(v <= 0) {
            v = 0;
        }
        return x.g(v, "}", stringBuilder0);
    }
}

