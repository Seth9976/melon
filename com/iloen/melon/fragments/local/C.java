package com.iloen.melon.fragments.local;

import com.iloen.melon.fragments.MetaContentBaseFragment;
import we.a;

public final class c implements a {
    public final int a;
    public final MetaContentBaseFragment b;

    public c(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.local.LocalContentAlbumListFragment.deleteAlbum.1.1.invokeSuspend$lambda$0(((LocalContentAlbumListFragment)this.b));
            }
            case 1: {
                return com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.invokeSuspend$lambda$0(((LocalContentAllSongFragment)this.b));
            }
            case 2: {
                return com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.invokeSuspend$lambda$0(((LocalContentBaseUIFragment)this.b));
            }
            case 3: {
                return com.iloen.melon.fragments.local.LocalPlaylistDetailFragment.onToolBarClick.1.invokeSuspend$lambda$0(((LocalPlaylistDetailFragment)this.b));
            }
            default: {
                return LocalContentNewDbBaseFragment.showDeleteConfirmPopupReal$lambda$4(((LocalContentNewDbBaseFragment)this.b));
            }
        }
    }
}

