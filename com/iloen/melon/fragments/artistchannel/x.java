package com.iloen.melon.fragments.artistchannel;

import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class x implements Runnable {
    public final int a;
    public final MetaContentBaseFragment b;

    public x(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ((NowPlayingDetailTabFragment)this.b).lambda$updateHeaderView$0();
            return;
        }
        ArtistDetailHomeFragment.showCreateShortcutPopup$lambda$30(((ArtistDetailHomeFragment)this.b));
    }
}

