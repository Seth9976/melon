package com.iloen.melon.fragments.local;

import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;
import com.iloen.melon.fragments.OnBottomSheetItemClickListener;
import com.iloen.melon.playback.Playable;
import zd.M;

public final class q implements J, OnBottomSheetItemClickListener {
    public final LocalContentNewDbBaseFragment a;
    public final Object b;

    public q(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, Object object0) {
        this.a = localContentNewDbBaseFragment0;
        this.b = object0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        LocalPlaylistDetailFragment.setAllCheckButtonVisibility$lambda$8$lambda$7(((LocalPlaylistDetailFragment)this.a), ((FilterLayout)this.b), s0, z);
    }

    @Override  // com.iloen.melon.fragments.OnBottomSheetItemClickListener
    public void onItemClick(M m0) {
        LocalContentNewDbBaseFragment.showTrackAddToLocalPlaylistPopup$lambda$2(this.a, ((Playable)this.b), m0);
    }
}

