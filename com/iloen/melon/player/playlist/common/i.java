package com.iloen.melon.player.playlist.common;

import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt;
import ed.Z.a;
import ie.H;
import java.util.List;
import r0.q;
import we.k;
import we.n;

public final class i implements n {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Object e;
    public final Object f;

    public i(Object object0, q q0, int v, int v1, int v2, int v3) {
        this.a = v3;
        this.e = object0;
        this.f = q0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        super();
    }

    public i(String s, int v, k k0, int v1, int v2) {
        this.a = 0;
        super();
        this.e = s;
        this.b = v;
        this.f = k0;
        this.c = v1;
        this.d = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                PlaylistCommonSongListComposableKt.GroupTitle(((String)this.e), this.b, ((k)this.f), ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.d);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter(((List)this.e), ((q)this.f), this.b, ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.d);
                return H.a;
            }
            default: {
                ((Integer)object1).intValue();
                ((a)this.e).D(((q)this.f), this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
        }
    }
}

