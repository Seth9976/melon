package com.iloen.melon.fragments.artistchannel.viewholder;

import O.w;
import java.util.List;
import we.k;
import we.n;

public final class i implements k {
    public final int a;
    public final List b;
    public final n c;

    public i(List list0, n n0, int v) {
        this.a = v;
        this.b = list0;
        this.c = n0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? ArtistHiRisingHolderKt.ArtistHiRisingSlot$lambda$5$lambda$4$lambda$3(this.b, this.c, ((w)object0)) : ArtistSpotlightHolderKt.ArtistSpotlightSlot$lambda$5$lambda$4$lambda$3(this.b, this.c, ((w)object0));
    }
}

