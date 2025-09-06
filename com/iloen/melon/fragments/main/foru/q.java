package com.iloen.melon.fragments.main.foru;

import com.iloen.melon.fragments.MetaContentBaseFragment;
import we.a;

public final class q implements a {
    public final int a;
    public final MetaContentBaseFragment b;

    public q(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ((ForUMusicSettingFragment)this.b).lambda$showExitPopup$0();
            }
            case 1: {
                return ForUTasteArtistFragment.showExitPopup$lambda$2(((ForUTasteArtistFragment)this.b));
            }
            default: {
                return ForUTasteSongFragment.showExitPopup$lambda$2(((ForUTasteSongFragment)this.b));
            }
        }
    }
}

