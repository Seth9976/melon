package Ke;

import Tf.v;
import e.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.q;
import qf.c;

public final class m {
    public final List a;
    public final LinkedHashMap b;
    public static final m c;

    static {
        m.c = new m(k.A(new Ke.k[]{g.c, j.c, h.c, i.c}));
    }

    public m(List list0) {
        this.a = list0;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object0: list0) {
            c c0 = ((Ke.k)object0).a;
            ArrayList arrayList0 = linkedHashMap0.get(c0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                linkedHashMap0.put(c0, arrayList0);
            }
            arrayList0.add(object0);
        }
        this.b = linkedHashMap0;
    }

    public final l a(String s, c c0) {
        Integer integer0;
        q.g(c0, "packageFqName");
        q.g(s, "className");
        List list0 = (List)this.b.get(c0);
        if(list0 != null) {
            for(Object object0: list0) {
                Ke.k k0 = (Ke.k)object0;
                int v = 0;
                if(v.r0(s, k0.b, false)) {
                    String s1 = s.substring(k0.b.length());
                    q.f(s1, "substring(...)");
                    if(s1.length() == 0) {
                    label_23:
                        integer0 = null;
                    }
                    else {
                        int v1 = s1.length();
                        int v2 = 0;
                        while(v < v1) {
                            int v3 = s1.charAt(v) - 0x30;
                            if(v3 < 0 || v3 >= 10) {
                                goto label_23;
                            }
                            v2 = v2 * 10 + v3;
                            ++v;
                        }
                        integer0 = v2;
                    }
                    if(integer0 != null) {
                        return new l(k0, ((int)integer0));
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return null;
    }
}

