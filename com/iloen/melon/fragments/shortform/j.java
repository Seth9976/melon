package com.iloen.melon.fragments.shortform;

import android.os.Bundle;
import androidx.fragment.app.r0;
import m4.f;
import m4.h;

public final class j implements r0, f {
    public final TrendShortBaseFragment a;

    public j(TrendShortBaseFragment trendShortBaseFragment0) {
        this.a = trendShortBaseFragment0;
        super();
    }

    @Override  // m4.f
    public void a(h h0) {
        TrendShortVideoEmphasisFragment.setFirstFrameToBackground$lambda$4$lambda$3$lambda$2(((TrendShortVideoEmphasisFragment)this.a), h0);
    }

    @Override  // androidx.fragment.app.r0
    public void b(Bundle bundle0, String s) {
        com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1.1.invokeSuspend$lambda$0(this.a, s, bundle0);
    }
}

