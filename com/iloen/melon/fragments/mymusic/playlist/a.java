package com.iloen.melon.fragments.mymusic.playlist;

import androidx.compose.runtime.l;
import com.melon.ui.K4;
import we.n;

public final class a implements n {
    public final int a;
    public final ImageToPlaylistFragment b;
    public final K4 c;

    public a(ImageToPlaylistFragment imageToPlaylistFragment0, K4 k40, int v) {
        this.a = v;
        this.b = imageToPlaylistFragment0;
        this.c = k40;
        super();
    }

    public a(Success imageToPlaylistUiState$Success0, ImageToPlaylistFragment imageToPlaylistFragment0) {
        this.a = 0;
        super();
        this.c = imageToPlaylistUiState$Success0;
        this.b = imageToPlaylistFragment0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return ImageToPlaylistFragment.m(this.b, ((Success)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                return ImageToPlaylistFragment.w(this.b, ((Success)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            default: {
                return ImageToPlaylistFragment.t(this.b, this.c, ((l)object0), ((int)(((Integer)object1))));
            }
        }
    }
}

