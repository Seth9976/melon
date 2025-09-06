package com.iloen.melon.fragments.local;

import com.iloen.melon.fragments.OnBottomSheetItemClickListener;
import com.iloen.melon.popup.ContextListPopup.OnMenuItemClickListener;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import zd.M;

public final class i implements OnBottomSheetItemClickListener, OnMenuItemClickListener {
    public final int a;
    public final LocalContentListFragment b;
    public final int c;

    public i(LocalContentListFragment localContentListFragment0, int v, int v1) {
        this.a = v1;
        this.b = localContentListFragment0;
        this.c = v;
        super();
    }

    @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
    public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        LocalContentArtistListFragment.showArtistListPopup$lambda$3(((LocalContentArtistListFragment)this.b), this.c, contextItemInfo0, contextItemType0, contextItemInfo$Params0);
    }

    @Override  // com.iloen.melon.fragments.OnBottomSheetItemClickListener
    public void onItemClick(M m0) {
        if(this.a != 0) {
            LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup$lambda$4(((LocalContentAlbumListFragment)this.b), this.c, m0);
            return;
        }
        LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup$lambda$7$lambda$6(((LocalContentArtistListFragment)this.b), this.c, m0);
    }
}

