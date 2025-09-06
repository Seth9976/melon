package com.iloen.melon.fragments.detail;

import androidx.fragment.app.I;
import we.a;

public final class b implements a {
    public final int a;
    public final I b;

    public b(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return AlbumDetailContentsPhotoFragment.filterList_delegate$lambda$0(((AlbumDetailContentsPhotoFragment)this.b));
            }
            case 1: {
                return DetailContentsAlbumInfoFragment.initUi$lambda$2$lambda$1(((DetailContentsAlbumInfoFragment)this.b));
            }
            case 2: {
                return MixMakerPlaylistBySongIdsDetailFragment.bottomBtnData_delegate$lambda$1(((MixMakerPlaylistBySongIdsDetailFragment)this.b));
            }
            case 3: {
                return MixMakerPlaylistDetailFragment.bottomBtnData_delegate$lambda$1(((MixMakerPlaylistDetailFragment)this.b));
            }
            case 4: {
                return MixPlaylistDetailFragment.bottomBtnData_delegate$lambda$2(((MixPlaylistDetailFragment)this.b));
            }
            case 5: {
                return PlaylistDetailBaseFragment.bottomBtnData_delegate$lambda$2(((PlaylistDetailBaseFragment)this.b));
            }
            case 6: {
                return SongDetailFragment.bottomBtnData_delegate$lambda$2(((SongDetailFragment)this.b));
            }
            default: {
                return StationEpisodeDetailFragment.t0(((StationEpisodeDetailFragment)this.b));
            }
        }
    }
}

