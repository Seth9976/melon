package com.iloen.melon.fragments;

import androidx.compose.runtime.l;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import we.n;

public final class i implements n {
    public final FooterHolder a;
    public final FOOTER b;

    public i(FooterHolder detailSongMetaContentBaseFragment$FooterHolder0, FOOTER mainMusicRes$RESPONSE$FOOTER0) {
        this.a = detailSongMetaContentBaseFragment$FooterHolder0;
        this.b = mainMusicRes$RESPONSE$FOOTER0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return FooterHolder.onBindView$lambda$2$lambda$1$lambda$0(this.a, this.b, ((l)object0), ((int)(((Integer)object1))));
    }
}

