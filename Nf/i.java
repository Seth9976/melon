package Nf;

import Tf.n;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class i {
    public final e a;
    public final n b;
    public final Collection c;
    public final k d;
    public final Nf.e[] e;

    public i(Collection collection0, Nf.e[] arr_e) {
        this(collection0, arr_e, h.d);
    }

    public i(Collection collection0, Nf.e[] arr_e, k k0) {
        q.g(collection0, "nameList");
        this(null, null, collection0, k0, ((Nf.e[])Arrays.copyOf(arr_e, arr_e.length)));
    }

    public i(e e0, n n0, Collection collection0, k k0, Nf.e[] arr_e) {
        this.a = e0;
        this.b = n0;
        this.c = collection0;
        this.d = k0;
        this.e = arr_e;
    }

    public i(e e0, Nf.e[] arr_e) {
        this(e0, arr_e, h.b);
    }

    public i(e e0, Nf.e[] arr_e, k k0) {
        q.g(e0, "name");
        this(e0, null, null, k0, ((Nf.e[])Arrays.copyOf(arr_e, arr_e.length)));
    }
}

