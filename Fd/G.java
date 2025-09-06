package Fd;

import H0.e;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.q;
import we.o;

public final class g implements o {
    public final int a;
    public final D b;

    public g(D d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        switch(this.a) {
            case 0: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    this.b.p(true, ((p)(((l)object1))), 54);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 1: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    String s1 = e.Y(((p)(((l)object1))), 0x7F1308F9);  // string:search_recent_keyword_close "최근 검색 닫기"
                    D d1 = this.b;
                    boolean z1 = ((p)(((l)object1))).i(d1);
                    f f1 = ((p)(((l)object1))).N();
                    if(z1 || f1 == k.a) {
                        f1 = new f(d1, 2);
                        ((p)(((l)object1))).l0(f1);
                    }
                    d1.q(s1, f1, ((p)(((l)object1))), 6);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 2: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    this.b.p(false, ((p)(((l)object1))), 54);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 3: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    this.b.n(((p)(((l)object1))), 6);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 4: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    D d2 = this.b;
                    d2.p(true, ((p)(((l)object1))), 54);
                    String s2 = e.Y(((p)(((l)object1))), 0x7F1308F9);  // string:search_recent_keyword_close "최근 검색 닫기"
                    boolean z2 = ((p)(((l)object1))).i(d2);
                    f f2 = ((p)(((l)object1))).N();
                    if(z2 || f2 == k.a) {
                        f2 = new f(d2, 1);
                        ((p)(((l)object1))).l0(f2);
                    }
                    d2.q(s2, f2, ((p)(((l)object1))), 6);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            default: {
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    String s = e.Y(((p)(((l)object1))), 0x7F1308E1);  // string:search_auto_complete_close "자동완성 닫기"
                    D d0 = this.b;
                    boolean z = ((p)(((l)object1))).i(d0);
                    f f0 = ((p)(((l)object1))).N();
                    if(z || f0 == k.a) {
                        f0 = new f(d0, 4);
                        ((p)(((l)object1))).l0(f0);
                    }
                    d0.q(s, f0, ((p)(((l)object1))), 6);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
        }
    }
}

