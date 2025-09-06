package com.iloen.melon.fragments.artistchannel.viewholder;

import androidx.compose.runtime.l;
import d8.d;
import ie.H;
import java.util.List;
import we.n;

public final class j implements n {
    public final int a;
    public final List b;
    public final n c;
    public final int d;

    public j(List list0, n n0, int v, int v1) {
        this.a = v1;
        this.b = list0;
        this.c = n0;
        this.d = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return ArtistHiRisingHolderKt.ArtistHiRisingSlot$lambda$6(this.b, this.c, this.d, ((l)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                return ArtistSpotlightHolderKt.ArtistSpotlightSlot$lambda$6(this.b, this.c, this.d, ((l)object0), ((int)(((Integer)object1))));
            }
            default: {
                ((Integer)object1).intValue();
                d.i(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
        }
    }
}

