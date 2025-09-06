package hd;

import A0.f;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;
import y0.s;

public final class l implements k {
    public final float a;
    public final ArrayList b;
    public final long c;
    public final ArrayList d;

    public l(float f, ArrayList arrayList0, long v, ArrayList arrayList1) {
        this.a = f;
        this.b = arrayList0;
        this.c = v;
        this.d = arrayList1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v5;
        int v4;
        q.g(((f)object0), "$this$Canvas");
        float f = ((f)object0).Y(this.a) / 2.0f - ((f)object0).Y(9.0f);
        ArrayList arrayList0 = this.b;
        int v = e.k.s(arrayList0);
        int v1 = arrayList0.size() - 1;
        int v2 = 0;
        while(v1 >= 0) {
            float f1 = ((Number)arrayList0.get(v1)).floatValue();
            ArrayList arrayList1 = this.d;
            if(v2 == v) {
                v4 = v2;
                v5 = v1;
                f.Z(((f)object0), ((s)arrayList1.get(0)).a, -90.0f, f1, true, 0L, 0L, 0.0f, null, 0x3F0);
            }
            else {
                long v3 = ((s)arrayList1.get(v - v2)).a;
                float f2 = Float.intBitsToFloat(((int)(((f)object0).g0() >> 0x20)));
                v4 = v2;
                v5 = v1;
                f.Z(((f)object0), v3, -90.0f, f1, true, ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(((f)object0).g0() & 0xFFFFFFFFL))) - f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f2 - f)) << 0x20, ((long)Float.floatToRawIntBits(f * 2.0f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f * 2.0f)) << 0x20, 0.0f, null, 960);
            }
            v2 = v4 + 1;
            v1 = v5 - 1;
        }
        float f3 = ((f)object0).Y(76.0f);
        f.Q(((f)object0), this.c, f3 / 2.0f, 0L, 0x7C);
        return H.a;
    }
}

