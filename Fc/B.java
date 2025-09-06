package Fc;

import Ce.g;
import E9.h;
import Tf.o;
import Tf.v;
import androidx.compose.runtime.l;
import ie.H;
import ie.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import we.n;

public final class b implements n {
    public final int a;
    public final List b;

    public b(List list0) {
        this.a = 1;
        super();
        this.b = list0;
    }

    public b(List list0, int v) {
        this.a = 0;
        super();
        this.b = list0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v7;
        int v6;
        Object object3;
        m m0;
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            q.g(((CharSequence)object0), "$this$DelimitedRangesSequence");
            Collection collection0 = this.b;
            if(collection0.size() == 1) {
                String s = (String)p.D0(collection0);
                int v1 = o.F0(((CharSequence)object0), s, v, false, 4);
                if(v1 >= 0) {
                    m0 = new m(v1, s);
                    return m0 == null ? null : new m(m0.a, ((String)m0.b).length());
                }
            }
            else {
                if(v < 0) {
                    v = 0;
                }
                g g0 = new g(v, ((CharSequence)object0).length(), 1);  // 初始化器: LCe/e;-><init>(III)V
                int v2 = g0.c;
                int v3 = g0.b;
                if(!(((CharSequence)object0) instanceof String)) {
                    if(v2 > 0 && v <= v3 || v2 < 0 && v3 <= v) {
                        int v5 = v;
                        while(true) {
                            Iterator iterator1 = collection0.iterator();
                            while(true) {
                                if(iterator1.hasNext()) {
                                    object3 = iterator1.next();
                                    v6 = v2;
                                    v7 = v3;
                                    if(o.M0(((String)object3), false, 0, ((CharSequence)object0), v5, ((String)object3).length())) {
                                        break;
                                    }
                                    else {
                                        v2 = v6;
                                        v3 = v7;
                                        continue;
                                    }
                                }
                                v7 = v3;
                                v6 = v2;
                                object3 = null;
                                break;
                            }
                            if(((String)object3) != null) {
                                m0 = new m(v5, ((String)object3));
                                return m0 == null ? null : new m(m0.a, ((String)m0.b).length());
                            }
                            if(v5 == v7) {
                                break;
                            }
                            v5 += v6;
                            v2 = v6;
                            v3 = v7;
                        }
                    }
                }
                else if(v2 > 0 && v <= v3 || v2 < 0 && v3 <= v) {
                    int v4 = v;
                    while(true) {
                        for(Object object2: collection0) {
                            if(!v.m0(0, v4, ((String)object2).length(), ((String)object2), ((String)(((CharSequence)object0))), false)) {
                                continue;
                            }
                            goto label_24;
                        }
                        object2 = null;
                    label_24:
                        if(((String)object2) != null) {
                            m0 = new m(v4, ((String)object2));
                            return m0 == null ? null : new m(m0.a, ((String)m0.b).length());
                        }
                        if(v4 == v3) {
                            break;
                        }
                        v4 += v2;
                    }
                }
            }
            throw new NullPointerException();
        }
        ((Integer)object1).getClass();
        h.e(this.b, ((l)object0), 1);
        return H.a;
    }
}

