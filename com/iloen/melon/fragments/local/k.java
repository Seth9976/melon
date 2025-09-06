package com.iloen.melon.fragments.local;

import we.a;

public final class k implements a {
    public final int a;
    public final LocalContentListFragment b;
    public final int c;

    public k(LocalContentListFragment localContentListFragment0, int v, int v1) {
        this.a = v1;
        this.b = localContentListFragment0;
        this.c = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.invokeSuspend$lambda$0(((LocalContentArtistListFragment)this.b), this.c);
            }
            case 1: {
                return LocalContentArtistListFragment.deleteArtist$lambda$5$lambda$4(((LocalContentArtistListFragment)this.b), this.c);
            }
            default: {
                return com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.invokeSuspend$lambda$0(((LocalContentAlbumListFragment)this.b), this.c);
            }
        }
    }
}

