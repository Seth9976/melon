package V4;

import H0.e;
import Nc.f;
import P4.a;
import U4.B;
import U4.k;
import U4.w;
import U4.y;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.q;

public final class p extends a {
    public final s i;
    public final String j;
    public final int k;
    public final List l;
    public final ArrayList m;
    public final ArrayList n;
    public boolean o;
    public B p;
    public static final String q;

    static {
        p.q = "WM-WorkContinuationImpl";
    }

    public p(s s0, String s1, int v, List list0) {
        this.i = s0;
        this.j = s1;
        this.k = v;
        this.l = list0;
        this.m = new ArrayList(list0.size());
        this.n = new ArrayList();
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            if(v == 1 && ((y)list0.get(v1)).b.u != 0x7FFFFFFFFFFFFFFFL) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String s2 = ((y)list0.get(v1)).a.toString();
            q.f(s2, "id.toString()");
            this.m.add(s2);
            this.n.add(s2);
        }
    }

    public final B L() {
        String s1;
        if(!this.o) {
            s s0 = this.i;
            k k0 = s0.i.m;
            switch(this.k) {
                case 1: {
                    s1 = "REPLACE";
                    break;
                }
                case 2: {
                    s1 = "KEEP";
                    break;
                }
                case 3: {
                    s1 = "APPEND";
                    break;
                }
                case 4: {
                    s1 = "APPEND_OR_REPLACE";
                    break;
                }
                default: {
                    throw null;
                }
            }
            f f0 = new f(this, 18);
            this.p = e.O(k0, "EnqueueRunnable_" + s1, s0.k.a, f0);
            return this.p;
        }
        w.e().h("WM-WorkContinuationImpl", "Already enqueued work ids (" + TextUtils.join(", ", this.m) + ")");
        return this.p;
    }

    public static HashSet M(p p0) {
        HashSet hashSet0 = new HashSet();
        p0.getClass();
        return hashSet0;
    }
}

