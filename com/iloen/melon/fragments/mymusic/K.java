package com.iloen.melon.fragments.mymusic;

import we.a;

public final class k implements a {
    public final int a;
    public final Object b;

    public k(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return LockerAdapter.items_delegate$lambda$1(((LockerAdapter)this.b));
            }
            case 1: {
                return MyMusicFanArtistFragment.filterTexts_delegate$lambda$0(((MyMusicFanArtistFragment)this.b));
            }
            case 2: {
                return ((MyMusicLikeEditFragment)this.b).lambda$onToolBarClick$1();
            }
            case 3: {
                return MyMusicPlayListEditFragment.deletePlaylist$lambda$14(((MyMusicPlayListEditFragment)this.b));
            }
            case 4: {
                return OtherMusicLikedPlaylistFragment.sortings_delegate$lambda$2(((OtherMusicLikedPlaylistFragment)this.b));
            }
            default: {
                return ProfileDjPickListFragment.sortingTexts_delegate$lambda$0(((ProfileDjPickListFragment)this.b));
            }
        }
    }
}

