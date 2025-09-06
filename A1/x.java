package a1;

import A0.c;
import A0.d;
import A0.f;
import F.b0;
import P0.K;
import android.text.Layout;
import androidx.appcompat.app.o;
import androidx.compose.runtime.b1;
import androidx.media3.session.legacy.V;
import b1.i;
import d0.h;
import e1.m;
import ie.H;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.r;
import we.k;
import y0.L;
import y0.e;

public final class x extends r implements k {
    public final int f;
    public final long g;
    public final Object h;
    public final Object i;
    public final Object j;

    public x(long v, float[] arr_f, F f0, E e0) {
        this.f = 0;
        this.g = v;
        this.h = arr_f;
        this.i = f0;
        this.j = e0;
        super(1);
    }

    public x(Object object0, Object object1, long v, Object object2, int v1) {
        this.f = v1;
        this.h = object0;
        this.i = object1;
        this.g = v;
        this.j = object2;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f12;
        int v21;
        float f11;
        int v20;
        float[] arr_f1;
        switch(this.f) {
            case 0: {
                float[] arr_f = (float[])this.h;
                F f8 = (F)this.i;
                E e0 = (E)this.j;
                a a0 = ((A)object0).a;
                int v5 = ((A)object0).c;
                long v6 = this.g;
                int v7 = ((A)object0).b <= T.e(v6) ? T.e(v6) : ((A)object0).b;
                if(v5 >= T.d(v6)) {
                    v5 = T.d(v6);
                }
                long v8 = t.b(((A)object0).d(v7), ((A)object0).d(v5));
                int v9 = f8.a;
                i i1 = a0.d;
                int v10 = T.e(v8);
                int v11 = T.d(v8);
                Layout layout0 = i1.f;
                int v12 = layout0.getText().length();
                if(v10 < 0) {
                    g1.a.a("startOffset must be > 0");
                }
                if(v10 >= v12) {
                    g1.a.a("startOffset must be less than text length");
                }
                if(v11 <= v10) {
                    g1.a.a("endOffset must be greater than startOffset");
                }
                if(v11 > v12) {
                    g1.a.a("endOffset must be smaller or equal to text length");
                }
                if(arr_f.length - v9 < (v11 - v10) * 4) {
                    g1.a.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
                }
                int v13 = layout0.getLineForOffset(v10);
                int v14 = layout0.getLineForOffset(v11 - 1);
                W0.i i2 = new W0.i(i1);
                if(v13 <= v14) {
                    while(true) {
                        int v15 = Math.max(v10, layout0.getLineStart(v13));
                        int v16 = Math.min(v11, i1.f(v13));
                        float f9 = i1.g(v13);
                        float f10 = i1.e(v13);
                        arr_f1 = arr_f;
                        int v17 = layout0.getParagraphDirection(v13) == 1 ? 1 : 0;
                        int v18 = v15;
                        int v19 = v9;
                        while(v18 < v16) {
                            boolean z = layout0.isRtlCharAt(v18);
                            if(v17 == 0 || z) {
                                v20 = v16;
                                if(v17 == 0 || !z) {
                                    v21 = v17;
                                    if(v21 != 0 || !z) {
                                        f11 = i2.a(false, false, false, v18);
                                        f12 = i2.a(true, true, false, v18 + 1);
                                    }
                                    else {
                                        f12 = i2.a(false, false, true, v18);
                                        f11 = i2.a(true, true, true, v18 + 1);
                                    }
                                }
                                else {
                                    float f13 = i2.a(false, false, false, v18);
                                    v21 = v17;
                                    f11 = i2.a(true, true, false, v18 + 1);
                                    f12 = f13;
                                }
                            }
                            else {
                                v20 = v16;
                                f11 = i2.a(false, false, true, v18);
                                v21 = v17;
                                f12 = i2.a(true, true, true, v18 + 1);
                            }
                            arr_f1[v19] = f11;
                            arr_f1[v19 + 1] = f9;
                            arr_f1[v19 + 2] = f12;
                            arr_f1[v19 + 3] = f10;
                            v19 += 4;
                            ++v18;
                            v17 = v21;
                            v16 = v20;
                        }
                        if(v13 == v14) {
                            break;
                        }
                        ++v13;
                        v9 = v19;
                        arr_f = arr_f1;
                    }
                }
                else {
                    arr_f1 = arr_f;
                }
                int v22 = T.c(v8) * 4 + f8.a;
                for(int v23 = f8.a; v23 < v22; v23 += 4) {
                    float f14 = e0.a;
                    arr_f1[v23 + 1] += f14;
                    arr_f1[v23 + 3] += f14;
                }
                f8.a = v22;
                float f15 = e0.a;
                e0.a = a0.b() + f15;
                return H.a;
            }
            case 1: {
                ((K)(((d)object0))).a();
                ((c)((K)(((d)object0))).a.b.a).M(((x0.c)this.h).a, ((x0.c)this.h).b);
                try {
                    f.v(((K)(((d)object0))), ((e)((kotlin.jvm.internal.H)this.i).a), this.g, 0L, 0.0f, ((y0.t)this.j), 0, 890);
                    return H.a;
                }
                finally {
                    ((c)((K)(((d)object0))).a.b.a).M(-((x0.c)this.h).a, -((x0.c)this.h).b);
                }
            }
            default: {
                float f = ((Number)((we.a)this.h).invoke()).floatValue();
                float f1 = Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5.0f / 3.0f;
                float f2 = P4.a.i(Math.abs(f) - 1.0f, 0.0f, 2.0f);
                float f3 = (0.4f * f1 - 0.25f + (f2 - ((float)Math.pow(f2, 2.0)) / 4.0f)) * 0.5f;
                float f4 = (0.8f * f1 + f3) * 360.0f;
                b0 b00 = new b0();  // 初始化器: Ljava/lang/Object;-><init>()V
                b00.a = f4;
                b00.b = Math.min(1.0f, f1);
                float f5 = ((Number)((b1)this.i).getValue()).floatValue();
                long v = ((f)object0).g0();
                V v1 = ((f)object0).a0();
                long v2 = v1.l();
                v1.h().q();
                try {
                    ((c)v1.a).I(v, f3);
                    float f6 = ((f)object0).Y(h.b);
                    float f7 = ((f)object0).Y(h.a) / 2.0f + f6;
                    long v4 = m.r(((f)object0).c());
                    x0.c c0 = new x0.c(Float.intBitsToFloat(((int)(v4 >> 0x20))) - f7, Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL))) - f7, Float.intBitsToFloat(((int)(v4 >> 0x20))) + f7, Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL))) + f7);
                    A0.i i0 = new A0.i(0, 0, ((f)object0).Y(h.a), 0.0f, 26);
                    f.Z(((f)object0), this.g, f3 * 360.0f, f4 - f3 * 360.0f, false, c0.c(), c0.b(), f5, i0, 0x300);
                    h.b(((f)object0), ((L)this.j), c0, this.g, f5, b00);
                    return H.a;
                }
                finally {
                    o.y(v1, v2);
                }
            }
        }
    }
}

