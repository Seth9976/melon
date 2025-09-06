package com.iloen.melon.fragments.main.foru;

import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;

public final class j implements Runnable {
    public final ForUMixMakerKeywordSelectFragment a;
    public final BottomTabBaseFragment b;

    public j(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, BottomTabBaseFragment bottomTabBaseFragment0) {
        this.a = forUMixMakerKeywordSelectFragment0;
        this.b = bottomTabBaseFragment0;
    }

    @Override
    public final void run() {
        com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.MixMakerKeywordSelectAdapter.LoadingHolder.1.onResourceReady$lambda$0(this.a, this.b);
    }
}

