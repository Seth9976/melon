package e1;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.w;
import androidx.compose.ui.text.font.AndroidFontLoader;
import d5.n;
import ie.H;
import java.util.List;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldKt;
import ne.a;
import oe.c;
import we.k;
import y8.s;

public final class d implements b1 {
    public final List a;
    public final K b;
    public final k c;
    public final b0 d;
    public boolean e;

    public d(List list0, Object object0, K k0, s s0, k k1, AndroidFontLoader androidFontLoader0) {
        this.a = list0;
        this.b = k0;
        this.c = k1;
        this.d = w.s(object0);
        this.e = true;
    }

    public final Object a(c c0) {
        int v5;
        List list1;
        int v4;
        d d1;
        M m0;
        k k0;
        d d0;
        List list0;
        int v3;
        int v2;
        e1.c c1;
        if(c0 instanceof e1.c) {
            c1 = (e1.c)c0;
            int v = c1.M;
            if((v & 0x80000000) == 0) {
                c1 = new e1.c(this, c0);
            }
            else {
                c1.M = v ^ 0x80000000;
            }
        }
        else {
            c1 = new e1.c(this, c0);
        }
        Object object0 = c1.G;
        a a0 = a.a;
        int v1 = c1.M;
        H h0 = H.a;
        if(v1 == 0) {
            n.D(object0);
            try {
                d1 = this;
                v4 = this.a.size();
                d1 = this;
                list1 = this.a;
                v5 = 0;
                while(true) {
                label_59:
                    if(v5 >= v4) {
                        goto label_70;
                    }
                    ((e1.H)list1.get(v5)).getClass();
                    ++v5;
                }
            }
            catch(Throwable throwable0) {
            }
        label_63:
            boolean z1 = JobKt.isActive(c1.getContext());
            d1.e = false;
            M m1 = new M(((O0)d1.d).getValue(), z1);
            d1.c.invoke(m1);
            throw throwable0;
        label_70:
            boolean z2 = JobKt.isActive(c1.getContext());
            d1.e = false;
            k0 = d1.c;
            m0 = new M(((O0)d1.d).getValue(), z2);
        }
        else {
            switch(v1) {
                case 1: {
                    try {
                        v2 = c1.E;
                        v3 = c1.D;
                        e1.H h1 = c1.B;
                        list0 = c1.w;
                        d0 = c1.r;
                        n.D(object0);
                        if(object0 == null) {
                            goto label_30;
                        }
                        else {
                            Object object1 = u.U(d0.b.d, object0, h1, d0.b.b, d0.b.c);
                            ((O0)d0.d).setValue(object1);
                            goto label_25;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        d1 = d0;
                        goto label_63;
                    }
                label_25:
                    boolean z = JobKt.isActive(c1.getContext());
                    d0.e = false;
                    k0 = d0.c;
                    m0 = new M(((O0)d0.d).getValue(), z);
                    break;
                    try {
                    label_30:
                        c1.r = d0;
                        c1.w = list0;
                        c1.B = null;
                        c1.D = v3;
                        c1.E = v2;
                        c1.M = 2;
                        if(YieldKt.yield(c1) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        d1 = d0;
                        goto label_63;
                    }
                    v4 = v2;
                    list1 = list0;
                    d1 = d0;
                    v5 = v3 + 1;
                    goto label_59;
                }
                case 2: {
                    try {
                        v4 = c1.E;
                        v5 = c1.D;
                        list1 = c1.w;
                        d1 = c1.r;
                        n.D(object0);
                        ++v5;
                        goto label_59;
                    }
                    catch(Throwable throwable0) {
                        goto label_63;
                    }
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        k0.invoke(m0);
        return h0;
    }

    @Override  // androidx.compose.runtime.b1
    public final Object getValue() {
        return ((O0)this.d).getValue();
    }
}

