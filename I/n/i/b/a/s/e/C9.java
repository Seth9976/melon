package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class c9 {
    public Object[] a;
    public int b;
    public boolean c;

    public c9() {
        Ja.x(4, "initialCapacity");
        this.a = new Object[4];
        this.b = 0;
    }

    public static int a(int v, int v1) {
        if(v1 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int v2 = v + (v >> 1) + 1 >= v1 ? v + (v >> 1) + 1 : Integer.highestOneBit(v1 - 1) << 1;
        return v2 >= 0 ? v2 : 0x7FFFFFFF;
    }

    public final void b(Object object0) {
        int v = this.b + 1;
        Object[] arr_object = this.a;
        if(arr_object.length < v) {
            this.a = Arrays.copyOf(arr_object, c9.a(arr_object.length, v));
            this.c = false;
        }
        else if(this.c) {
            this.a = (Object[])arr_object.clone();
            this.c = false;
        }
        int v1 = this.b;
        this.b = v1 + 1;
        this.a[v1] = object0;
    }
}

