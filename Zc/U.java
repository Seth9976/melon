package zc;

import A0.f;
import Cb.i;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import e1.b;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;
import x0.c;
import y0.L;
import y0.g;
import y0.j;

public final class u implements k {
    public final List a;
    public final List b;
    public final float c;
    public final float d;
    public final a e;
    public final List f;
    public final List g;

    public u(List list0, List list1, float f, float f1, a a0, List list2, List list3) {
        this.a = list0;
        this.b = list1;
        this.c = f;
        this.d = f1;
        this.e = a0;
        this.f = list2;
        this.g = list3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((f)object0), "$this$Canvas");
        int v = 0;
        for(Object object1: this.a) {
            Float float0 = null;
            if(v >= 0) {
                String s = (String)object1;
                for(Object object2: this.b) {
                    if(((GRAPHDATA)object2).xIndex != v) {
                        continue;
                    }
                    goto label_14;
                }
                object2 = null;
            label_14:
                if(i.l(((GRAPHDATA)object2))) {
                    if(((GRAPHDATA)object2) != null) {
                        String s1 = ((GRAPHDATA)object2).value;
                        if(s1 != null) {
                            float0 = Tf.u.g0(s1);
                        }
                    }
                    if(float0 != null) {
                        String s2 = ((GRAPHDATA)object2).value;
                        q.f(s2, "value");
                        float f = Float.parseFloat(s2) / this.c * this.d;
                        float f1 = ((f)object0).Y(this.e.b);
                        float f2 = ((f)object0).Y(this.e.d);
                        float f3 = ((f)object0).Y(this.e.e);
                        float f4 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL))) - f;
                        g g0 = j.a();
                        c c0 = e.k.d(((long)Float.floatToRawIntBits(f3 * ((float)v) + (f2 * ((float)v) + f1))) << 0x20 | ((long)Float.floatToRawIntBits(f4)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((f)object0).Y(22.0f))) << 0x20);
                        float f5 = this.e.d / 2.0f;
                        float f6 = ((f)object0).Y(f5);
                        float f7 = ((f)object0).Y(f5);
                        L.a(g0, b.k(c0, ((long)Float.floatToRawIntBits(f6)) << 0x20 | ((long)Float.floatToRawIntBits(f6)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f7)) << 0x20 | ((long)Float.floatToRawIntBits(f7)) & 0xFFFFFFFFL));
                        f.M(((f)object0), g0, wc.u.f((((GRAPHDATA)object2).topCntYn == null || true ? this.g : this.f), f4, 0.0f, 12), 0.0f, null, 60);
                    }
                }
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
        return H.a;
    }
}

