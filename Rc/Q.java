package Rc;

import Yc.m;
import androidx.compose.runtime.l;
import com.melon.net.res.common.SongInfoBase;
import e2.a;
import ie.H;
import jd.U2;
import we.k;
import we.n;
import yc.s;
import yc.t;

public final class q implements n {
    public final int a;
    public final k b;

    public q(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    public q(k k0, int v, int v1) {
        this.a = v1;
        this.b = k0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                a0 a00 = new a0(((int)(((Integer)object1))), ((long)(((Long)object0))));
                this.b.invoke(a00);
                return H.a;
            }
            case 1: {
                V v1 = new V(((int)(((Integer)object1))), ((long)(((Long)object0))));
                this.b.invoke(v1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                m.d(this.b, ((l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                d5.n.j(this.b, ((l)object0), 1);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                a.i(this.b, ((l)object0), 1);
                return H.a;
            }
            case 5: {
                ((Integer)object1).getClass();
                e1.n.f(this.b, ((l)object0), 1);
                return H.a;
            }
            case 6: {
                ((Integer)object1).getClass();
                U2.a(this.b, ((l)object0), 1);
                return H.a;
            }
            case 7: {
                int v2 = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "songInfoBase");
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(new t(v2, ((SongInfoBase)object1), true));
                }
                return H.a;
            }
            case 8: {
                int v3 = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "songInfoBase");
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(new t(v3, ((SongInfoBase)object1), true));
                }
                return H.a;
            }
            case 9: {
                int v4 = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "songInfoBase");
                k k3 = this.b;
                if(k3 != null) {
                    k3.invoke(new t(v4, ((SongInfoBase)object1), false));
                }
                return H.a;
            }
            case 10: {
                int v5 = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "albumInfo");
                k k4 = this.b;
                if(k4 != null) {
                    k4.invoke(new yc.n(v5, ((SongInfoBase)object1), false));
                }
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "songInfoBase");
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(new s(((SongInfoBase)object1), v));
                }
                return H.a;
            }
        }
    }
}

