package df;

import Re.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import je.w;
import we.a;
import yf.b;

public final class p implements a {
    public final int a;
    public final q b;

    public p(q q0, int v) {
        this.a = v;
        this.b = q0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s1;
        switch(this.a) {
            case 0: {
                ((cf.a)this.b.h.a).l.getClass();
                kotlin.jvm.internal.q.g(this.b.e.a.a, "packageFqName");
                return C.Y(new ArrayList());
            }
            case 1: {
                this.b.g.getClass();
                return new ArrayList(je.q.Q(10, w.a));
            }
            default: {
                HashMap hashMap0 = new HashMap();
                for(Object object0: ((Map)P4.a.r(this.b.i, q.m[0])).entrySet()) {
                    String s = (String)((Map.Entry)object0).getKey();
                    c c0 = (c)((Map.Entry)object0).getValue();
                    b b0 = b.c(s);
                    A7.a a0 = c0.b;
                    kf.a a1 = (kf.a)a0.d;
                    switch(a1.ordinal()) {
                        case 2: {
                            hashMap0.put(b0, b0);
                            continue;
                        }
                        case 5: {
                            s1 = a1 == kf.a.i ? a0.b : null;
                            if(s1 != null) {
                                break;
                            }
                            continue;
                        }
                        default: {
                            continue;
                        }
                    }
                    hashMap0.put(b0, b.c(s1));
                }
                return hashMap0;
            }
        }
    }
}

