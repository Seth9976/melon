package com.iloen.melon.fragments;

import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.sns.model.Sharable;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.k2;
import we.k;
import zd.q;

public final class s implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public s(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.25)this.b).lambda$run$1(((OnSNSLinkClickListener)this.c), ((Sharable)this.d), ((k2)object0));
            }
            case 1: {
                return ((MetaContentBaseFragment)this.b).lambda$showContextPopupDjPlaylist$6(((DjPlayListInfoBase)this.c), ((q)this.d), ((k2)object0));
            }
            default: {
                return ((MetaContentBaseFragment)this.b).lambda$showContextPopupArtistPlaylist$8(((ArtistPlayListInfoBase)this.c), ((String)this.d), ((k2)object0));
            }
        }
    }
}

