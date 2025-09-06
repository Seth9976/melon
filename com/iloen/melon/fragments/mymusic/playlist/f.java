package com.iloen.melon.fragments.mymusic.playlist;

import Cc.W3;
import O.w;
import com.melon.ui.K4;
import com.melon.ui.d1;
import java.util.List;
import we.k;

public final class f implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public f(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public f(ImageToPlaylistViewModel imageToPlaylistViewModel0, String s) {
        this.a = 4;
        super();
        this.c = imageToPlaylistViewModel0;
        this.b = s;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.uploadImages.2.invokeSuspend$lambda$2(((Na.f)this.b), ((ImageToPlaylistViewModel)this.c), ((d1)object0));
            }
            case 1: {
                return ImageToPlaylistFragment.MainContent$lambda$36$lambda$35(((Success)this.b), ((ImageToPlaylistFragment)this.c), ((w)object0));
            }
            case 2: {
                return ImageToPlaylistViewModel.selectItem$lambda$15$lambda$14(((List)this.b), ((Success)this.c), ((K4)object0));
            }
            case 3: {
                return ImageToPlaylistViewModel.selectAll$lambda$12$lambda$11(((List)this.b), ((Success)this.c), ((K4)object0));
            }
            default: {
                return ImageToPlaylistViewModel.getSuccessUiState$lambda$9(((ImageToPlaylistViewModel)this.c), ((String)this.b), ((W3)object0));
            }
        }
    }
}

