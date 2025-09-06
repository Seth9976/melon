package W;

import U.E;
import U.J0;
import X0.x;
import a1.g;
import a1.t;
import androidx.compose.runtime.O0;
import f1.C;
import f1.a;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class h extends r implements k {
    public final int f;
    public final i g;

    public h(i i0, int v) {
        this.f = v;
        this.g = i0;
        super(1);
    }

    public h(i i0, x x0) {
        this.f = 3;
        this.g = i0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        i i0 = this.g;
        switch(this.f) {
            case 0: {
                ((O0)i0.e.t).setValue(Boolean.TRUE);
                ((O0)i0.e.s).setValue(Boolean.TRUE);
                i.p0(i0, i0.e, ((g)object0).b, i0.f);
                return true;
            }
            case 1: {
                if(i0.e.d() != null) {
                    J0 j00 = i0.e.d();
                    q.d(j00);
                    ((List)object0).add(j00.a);
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 2: {
                i.p0(i0, i0.e, ((g)object0).b, i0.f);
                return true;
            }
            default: {
                if(!i0.f) {
                    return false;
                }
                C c0 = i0.e.e;
                H h0 = null;
                if(c0 != null) {
                    List list0 = e.k.A(new f1.g[]{new f1.h(), new a(((g)object0), 1)});  // 初始化器: Ljava/lang/Object;-><init>()V
                    E e0 = i0.e.v;
                    f1.x x0 = i0.e.d.f(list0);
                    c0.a(null, x0);
                    e0.invoke(x0);
                    h0 = H.a;
                }
                if(h0 == null) {
                    String s = i0.d.a.b;
                    int v = (int)(i0.d.b >> 0x20);
                    int v1 = (int)(i0.d.b & 0xFFFFFFFFL);
                    q.g(s, "<this>");
                    q.g(((g)object0), "replacement");
                    if(v1 < v) {
                        throw new IndexOutOfBoundsException("End index (" + v1 + ") is less than start index (" + v + ").");
                    }
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append(s, 0, v);
                    stringBuilder0.append(((g)object0));
                    stringBuilder0.append(s, v1, s.length());
                    int v2 = (int)(i0.d.b >> 0x20);
                    int v3 = ((g)object0).b.length();
                    long v4 = t.b(v3 + v2, v3 + v2);
                    i0.e.v.invoke(new f1.x(stringBuilder0.toString(), v4, 4));
                    return true;
                }
                return true;
            }
        }
    }
}

