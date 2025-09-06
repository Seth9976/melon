package com.iloen.melon.player.playlist.drawernew.composable;

import E2.i;
import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytWrapper;
import ie.H;
import r0.q;
import w8.k0;
import we.a;
import we.n;

public final class c implements n {
    public final int a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;
    public final Object g;
    public final Object h;
    public final Object i;
    public final Object j;

    public c(q q0, DrawerPlytWrapper drawerPlytWrapper0, boolean z, boolean z1, int v, a a0, a a1, int v1, int v2) {
        this.a = 0;
        super();
        this.g = q0;
        this.h = drawerPlytWrapper0;
        this.c = z;
        this.d = z1;
        this.b = v;
        this.i = a0;
        this.j = a1;
        this.e = v1;
        this.f = v2;
    }

    public c(k0 k00, int v, B2.n n0, String s, boolean z, i i0, boolean z1, int v1, int v2) {
        this.a = 1;
        super();
        this.g = k00;
        this.b = v;
        this.h = n0;
        this.i = s;
        this.c = z;
        this.j = i0;
        this.d = z1;
        this.e = v1;
        this.f = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            ((k0)this.g).j(this.b, ((B2.n)this.h), ((String)this.i), this.c, ((i)this.j), this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)), this.f);
            return H.a;
        }
        ((Integer)object1).intValue();
        DrawerPlytListItemKt.DrawerPlytListItemDefault(((q)this.g), ((DrawerPlytWrapper)this.h), this.c, this.d, this.b, ((a)this.i), ((a)this.j), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)), this.f);
        return H.a;
    }
}

