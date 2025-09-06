package com.iloen.melon.fragments;

import android.os.Bundle;
import we.n;

public final class e implements n {
    public final DetailSongMetaContentBaseFragment a;

    public e(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0) {
        this.a = detailSongMetaContentBaseFragment0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return DetailSongMetaContentBaseFragment.registerCommentViewModelObserver$lambda$4(this.a, ((String)object0), ((Bundle)object1));
    }
}

