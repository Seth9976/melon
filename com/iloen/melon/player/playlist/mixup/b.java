package com.iloen.melon.player.playlist.mixup;

import androidx.compose.runtime.l;
import com.melon.playlist.mixup.DjMalrangInfo;
import df.v;
import gd.B2;
import ie.H;
import ie.f;
import java.util.ArrayList;
import java.util.List;
import jd.m3;
import jd.n2;
import kd.G;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class b implements n {
    public final int a;
    public final Object b;
    public final boolean c;
    public final Object d;
    public final Object e;
    public final f f;
    public final int g;
    public final int h;
    public final Object i;

    public b(DjMalrangInfo djMalrangInfo0, boolean z, a a0, a a1, a a2, Object object0, int v, int v1, int v2) {
        this.a = v2;
        this.b = djMalrangInfo0;
        this.c = z;
        this.d = a0;
        this.e = a1;
        this.f = a2;
        this.i = object0;
        this.g = v;
        this.h = v1;
        super();
    }

    public b(String s, String s1, ArrayList arrayList0, boolean z, k k0, a a0, int v, int v1) {
        this.a = 3;
        super();
        this.i = s;
        this.b = s1;
        this.e = arrayList0;
        this.c = z;
        this.f = k0;
        this.d = a0;
        this.g = v;
        this.h = v1;
    }

    public b(String s, List list0, int v, m3 m30, boolean z, String s1, k k0, int v1) {
        this.a = 5;
        super();
        this.i = s;
        this.b = list0;
        this.g = v;
        this.d = m30;
        this.c = z;
        this.e = s1;
        this.f = k0;
        this.h = v1;
    }

    public b(String s, q q0, String s1, boolean z, B2 b20, k k0, int v, int v1) {
        this.a = 2;
        super();
        this.i = s;
        this.b = q0;
        this.d = s1;
        this.c = z;
        this.e = b20;
        this.f = k0;
        this.g = v;
        this.h = v1;
    }

    public b(boolean z, String s, int v, List list0, k k0, k k1, a a0, int v1) {
        this.a = 4;
        super();
        this.c = z;
        this.i = s;
        this.g = v;
        this.b = list0;
        this.e = k0;
        this.f = k1;
        this.d = a0;
        this.h = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                MixUpComposablesKt.SourceTitleForDjMalrangDebug(((DjMalrangInfo)this.b), this.c, ((a)this.d), ((a)this.e), ((a)this.f), ((String)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                MixUpComposablesKt.SourceTitleForDjMalrang(((DjMalrangInfo)this.b), this.c, ((a)this.d), ((a)this.e), ((a)this.f), ((a)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                v.d(((String)this.i), ((q)this.b), ((String)this.d), this.c, ((B2)this.e), ((k)this.f), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                hd.H.z(((String)this.i), ((String)this.b), ((ArrayList)this.e), this.c, ((k)this.f), ((a)this.d), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                n2.h(this.c, ((String)this.i), this.g, ((List)this.b), ((k)this.e), ((k)this.f), ((a)this.d), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).intValue();
                G.g(((String)this.i), ((List)this.b), this.g, ((m3)this.d), this.c, ((String)this.e), ((k)this.f), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
        }
    }
}

