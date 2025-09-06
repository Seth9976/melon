package com.iloen.melon.fragments.local;

import com.iloen.melon.fragments.OnBottomSheetItemClickListener;
import com.iloen.melon.popup.ContextListPopup.OnMenuItemClickListener;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import zd.M;

public final class n implements OnBottomSheetItemClickListener, OnMenuItemClickListener {
    public final LocalContentGenreListFragment a;
    public final int b;

    public n(LocalContentGenreListFragment localContentGenreListFragment0, int v) {
        this.a = localContentGenreListFragment0;
        this.b = v;
        super();
    }

    @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
    public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        LocalContentGenreListFragment.showContextListPopup$lambda$1(this.a, this.b, contextItemInfo0, contextItemType0, contextItemInfo$Params0);
    }

    @Override  // com.iloen.melon.fragments.OnBottomSheetItemClickListener
    public void onItemClick(M m0) {
        LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup$lambda$5(this.a, this.b, m0);
    }
}

