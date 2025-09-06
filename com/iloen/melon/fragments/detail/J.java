package com.iloen.melon.fragments.detail;

import com.iloen.melon.popup.DjSelectionPopup.DjSelectionPopupData;
import com.melon.ui.k2;
import we.k;

public final class j implements k {
    public final int a;
    public final DjPlaylistDetailFragment b;

    public j(DjPlaylistDetailFragment djPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = djPlaylistDetailFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$18$lambda$16(this.b, ((DjSelectionPopupData)object0)) : DjPlaylistDetailFragment.showContextPopupPlaylistDetail$lambda$28$lambda$27(this.b, ((k2)object0));
    }
}

