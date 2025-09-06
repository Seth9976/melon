package com.iloen.melon.player.playlist.common;

import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt;
import e1.x;
import ie.H;
import ie.f;
import java.util.List;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class b implements n {
    public final int a;
    public final Object b;
    public final String c;
    public final boolean d;
    public final int e;
    public final int f;
    public final Object g;
    public final f h;

    public b(String s, int v, String s1, String s2, boolean z, k k0, int v1) {
        this.a = 2;
        super();
        this.c = s;
        this.e = v;
        this.g = s1;
        this.b = s2;
        this.d = z;
        this.h = k0;
        this.f = v1;
    }

    public b(q q0, List list0, String s, boolean z, k k0, int v, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.g = list0;
        this.c = s;
        this.d = z;
        this.h = k0;
        this.e = v;
        this.f = v1;
    }

    public b(q q0, boolean z, String s, String s1, a a0, int v, int v1) {
        this.a = 0;
        super();
        this.b = q0;
        this.d = z;
        this.c = s;
        this.g = s1;
        this.h = a0;
        this.e = v;
        this.f = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                PlaylistCommonHeaderComposableKt.AllSelectButton(((q)this.b), this.d, this.c, ((String)this.g), ((a)this.h), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)), this.f);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                DrawerAlyacListKt.DrawerAlyacList(((q)this.b), ((List)this.g), this.c, this.d, ((k)this.h), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)), this.f);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                x.h(this.c, this.e, ((String)this.g), ((String)this.b), this.d, ((k)this.h), ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)));
                return H.a;
            }
        }
    }
}

