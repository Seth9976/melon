package Q5;

import R6.d;
import S5.b;
import W5.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;

public final class p implements b {
    public final int a;

    public p(int v) {
        this.a = v;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        if(this.a != 0) {
            d d0 = new d(11);
            HashMap hashMap0 = new HashMap();
            Set set0 = Collections.EMPTY_SET;
            if(set0 == null) {
                throw new NullPointerException("Null flags");
            }
            W5.b b0 = new W5.b(30000L, 86400000L, set0);
            hashMap0.put(N5.d.a, b0);
            if(set0 == null) {
                throw new NullPointerException("Null flags");
            }
            W5.b b1 = new W5.b(1000L, 86400000L, set0);
            hashMap0.put(N5.d.c, b1);
            if(set0 == null) {
                throw new NullPointerException("Null flags");
            }
            Set set1 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new W5.d[]{W5.d.b})));
            if(set1 == null) {
                throw new NullPointerException("Null flags");
            }
            W5.b b2 = new W5.b(86400000L, 86400000L, set1);
            hashMap0.put(N5.d.b, b2);
            if(hashMap0.keySet().size() < N5.d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            new HashMap();
            return new a(d0, hashMap0);
        }
        return new s(Executors.newSingleThreadExecutor(), 0);
    }
}

