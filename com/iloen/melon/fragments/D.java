package com.iloen.melon.fragments;

import com.iloen.melon.fragments.comments.CommentData;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import we.k;

public final class d implements k {
    public final int a;
    public final DetailSongMetaContentBaseFragment b;

    public d(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v) {
        this.a = v;
        this.b = detailSongMetaContentBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? DetailSongMetaContentBaseFragment.registerCommentViewModelObserver$lambda$2(this.b, ((InformCmtContsSummRes)object0)) : DetailSongMetaContentBaseFragment.registerCommentViewModelObserver$lambda$3(this.b, ((CommentData)object0));
    }
}

