package com.iloen.melon.fragments.mymusic.playlist;

import com.melon.ui.K4;
import we.k;

public final class e implements k {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.uploadImages.2.invokeSuspend$lambda$0(((K4)object0));
            }
            case 1: {
                return ImageToPlaylistViewModel.onFetchStart$lambda$3(((K4)object0));
            }
            default: {
                return ImageToPlaylistViewModel.onFetchStart$lambda$4(((K4)object0));
            }
        }
    }
}

