package F;

import N0.Z;
import N0.a0;
import a1.A;
import a1.a;
import android.graphics.Matrix;
import android.graphics.Path;
import androidx.appcompat.app.o;
import ie.H;
import kotlin.jvm.internal.r;
import y0.g;

public final class k extends r implements we.k {
    public final int f;
    public final int g;
    public final int h;
    public final Object i;

    public k(g g0, int v, int v1) {
        this.f = 1;
        this.i = g0;
        this.g = v;
        this.h = v1;
        super(1);
    }

    public k(a0[] arr_a0, l l0, int v, int v1) {
        this.f = 0;
        this.i = arr_a0;
        this.g = v;
        this.h = v1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        int v = this.h;
        int v1 = this.g;
        Object object1 = this.i;
        if(this.f != 0) {
            a a0 = ((A)object0).a;
            int v2 = ((A)object0).d(v1);
            int v3 = ((A)object0).d(v);
            CharSequence charSequence0 = a0.e;
            if(v2 < 0 || v2 > v3 || v3 > charSequence0.length()) {
                StringBuilder stringBuilder0 = o.t(v2, v3, "start(", ") or end(", ") is out of range [0..");
                stringBuilder0.append(charSequence0.length());
                stringBuilder0.append("], or start > end!");
                g1.a.a(stringBuilder0.toString());
            }
            Path path0 = new Path();
            a0.d.f.getSelectionPath(v2, v3, path0);
            int v4 = a0.d.h;
            if(v4 != 0 && !path0.isEmpty()) {
                path0.offset(0.0f, ((float)v4));
            }
            long v5 = ((long)Float.floatToRawIntBits(((A)object0).f)) & 0xFFFFFFFFL;
            Matrix matrix0 = new Matrix();
            matrix0.setTranslate(Float.intBitsToFloat(((int)(v5 >> 0x20))), Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL))));
            path0.transform(matrix0);
            ((g)object1).a.addPath(path0, 0.0f, 0.0f);
            return h0;
        }
        for(int v6 = 0; v6 < ((a0[])object1).length; ++v6) {
            a0 a00 = ((a0[])object1)[v6];
            if(a00 != null) {
                long v7 = ((long)a00.b) & 0xFFFFFFFFL | ((long)a00.a) << 0x20;
                long v8 = ((long)v) & 0xFFFFFFFFL | ((long)v1) << 0x20;
                long v9 = ((long)Math.round(0.0f * (((float)(((int)(v8 & 0xFFFFFFFFL)) - ((int)(v7 & 0xFFFFFFFFL)))) / 2.0f))) & 0xFFFFFFFFL | ((long)Math.round(0.0f * (((float)(((int)(v8 >> 0x20)) - ((int)(v7 >> 0x20)))) / 2.0f))) << 0x20;
                Z.e(((Z)object0), a00, ((int)(v9 >> 0x20)), ((int)(v9 & 0xFFFFFFFFL)));
            }
        }
        return h0;
    }
}

