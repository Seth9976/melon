package com.iloen.melon.fragments.mymusic.playlist;

import androidx.compose.runtime.l;
import we.n;

public final class c implements n {
    public final int a;
    public final ImageToPlaylistFragment b;
    public final int c;

    public c(ImageToPlaylistFragment imageToPlaylistFragment0, int v, int v1) {
        this.a = v1;
        this.b = imageToPlaylistFragment0;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        switch(this.a) {
            case 0: {
                return ImageToPlaylistFragment.errorView$lambda$55(this.b, this.c, ((l)object0), v);
            }
            case 1: {
                return ImageToPlaylistFragment.v(this.b, this.c, ((l)object0), v);
            }
            default: {
                return ImageToPlaylistFragment.LoadingPreview$lambda$51(this.b, this.c, ((l)object0), v);
            }
        }
    }
}

