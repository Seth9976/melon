package com.iloen.melon.fragments.artistchannel;

import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class a implements we.a {
    public final int a;
    public final MetaContentBaseFragment b;

    public a(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ArtistDetailContentsAlbumFragment.filterLevel2List_delegate$lambda$0(((ArtistDetailContentsAlbumFragment)this.b));
            }
            case 1: {
                return ArtistDetailContentsMagazineFragment.filterList_delegate$lambda$0(((ArtistDetailContentsMagazineFragment)this.b));
            }
            case 2: {
                return ArtistDetailContentsPhotoFragment.filterList_delegate$lambda$0(((ArtistDetailContentsPhotoFragment)this.b));
            }
            case 3: {
                return ArtistDetailContentsTopicFragment.orderList_delegate$lambda$0(((ArtistDetailContentsTopicFragment)this.b));
            }
            case 4: {
                return ArtistDetailHomeFragment.showCreateShortcutPopup$lambda$30$lambda$29(((ArtistDetailHomeFragment)this.b));
            }
            default: {
                return ((NowPlayingDetailTabFragment)this.b).lambda$showDeletePopup$1();
            }
        }
    }
}

