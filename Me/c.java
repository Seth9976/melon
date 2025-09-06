package me;

import java.io.Serializable;

public final class c implements Serializable {
    public final i[] a;
    private static final long serialVersionUID;

    public c(i[] arr_i) {
        this.a = arr_i;
    }

    private final Object readResolve() {
        i[] arr_i = this.a;
        i i0 = j.a;
        for(int v = 0; v < arr_i.length; ++v) {
            i0 = i0.plus(arr_i[v]);
        }
        return i0;
    }
}

