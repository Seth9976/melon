package com.iloen.melon.fragments.artistchannel.viewholder;

import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIRISINGLIST;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.SPOTLIGHTLIST;
import we.n;

public final class h implements n {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return ArtistHiRisingHolder.onBindView$lambda$3$lambda$2$lambda$1(((ArtistHiRisingHolder)this.b), ((HIRISINGLIST)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                return ArtistHiRisingHolderKt.ArtistHiRisingSlotPreView$lambda$14(((HIRISINGLIST)this.b), ((l)object0), ((int)(((Integer)object1))));
            }
            case 2: {
                return ArtistSpotlightHolder.onBindView$lambda$3$lambda$2$lambda$1(((ArtistSpotlightHolder)this.b), ((SPOTLIGHTLIST)object0), ((int)(((Integer)object1))));
            }
            default: {
                return ArtistSpotlightHolderKt.ArtistSpotlightSlotPreView$lambda$14(((SPOTLIGHTLIST)this.b), ((l)object0), ((int)(((Integer)object1))));
            }
        }
    }
}

