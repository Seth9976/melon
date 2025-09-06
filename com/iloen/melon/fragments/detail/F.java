package com.iloen.melon.fragments.detail;

import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import com.melon.ui.k2;
import we.k;
import xd.h;

public final class f implements k {
    public final int a;
    public final DetailSongMetaContentBaseFragment b;

    public f(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v) {
        this.a = v;
        this.b = detailSongMetaContentBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return ArtistPlaylistDetailFragment.showContextPopupPlaylistDetail$lambda$4$lambda$3(((ArtistPlaylistDetailFragment)this.b), ((k2)object0));
            }
            case 1: {
                return MixMakerPlaylistBySongIdsDetailFragment.showContextPopupDetail$lambda$15(((MixMakerPlaylistBySongIdsDetailFragment)this.b), ((k2)object0));
            }
            case 2: {
                return MixMakerPlaylistDetailFragment.showContextPopupDetail$lambda$16(((MixMakerPlaylistDetailFragment)this.b), ((k2)object0));
            }
            case 3: {
                return MixPlaylistDetailFragment.showContextPopupPlaylistDetail$lambda$6(((MixPlaylistDetailFragment)this.b), ((k2)object0));
            }
            default: {
                return SongDetailFragment.x0(((SongDetailFragment)this.b), ((h)object0));
            }
        }
    }
}

