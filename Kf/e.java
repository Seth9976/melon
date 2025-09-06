package kf;

import Ze.v;
import d3.g;
import java.security.AccessControlException;
import java.util.HashMap;
import jf.l;
import jf.n;
import qf.b;
import qf.c;

public final class e implements n {
    public int[] a;
    public String b;
    public int c;
    public String[] d;
    public String[] e;
    public String[] f;
    public a g;
    public String[] h;
    public static final boolean i;
    public static final HashMap j;

    static {
        try {
            e.i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        }
        catch(AccessControlException unused_ex) {
            e.i = false;
        }
        HashMap hashMap0 = new HashMap();
        e.j = hashMap0;
        hashMap0.put(g.i0(new c("kotlin.jvm.internal.KotlinClass")), a.e);
        hashMap0.put(g.i0(new c("kotlin.jvm.internal.KotlinFileFacade")), a.f);
        hashMap0.put(g.i0(new c("kotlin.jvm.internal.KotlinMultifileClass")), a.h);
        hashMap0.put(g.i0(new c("kotlin.jvm.internal.KotlinMultifileClassPart")), a.i);
        hashMap0.put(g.i0(new c("kotlin.jvm.internal.KotlinSyntheticClass")), a.g);
    }

    @Override  // jf.n
    public final l a(b b0, Re.a a0) {
        c c0 = b0.a();
        if(c0.equals(v.a)) {
            return new kf.c(this, 0);
        }
        if(c0.equals(v.o)) {
            return new kf.c(this, 1);
        }
        if(!e.i && this.g == null) {
            a a1 = (a)e.j.get(b0);
            if(a1 != null) {
                this.g = a1;
                return new kf.c(this, 2);
            }
        }
        return null;
    }
}

