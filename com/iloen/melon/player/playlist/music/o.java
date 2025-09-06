package com.iloen.melon.player.playlist.music;

import androidx.lifecycle.f0;
import com.melon.ui.I4;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oe.i;
import we.a;
import we.k;

public final class o implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public o(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, k k0) {
        this.a = 0;
        super();
        this.b = musicPlaylistBaseViewModel0;
        this.c = (i)k0;
    }

    public o(I4 i40, MusicPlaylistBaseFragment musicPlaylistBaseFragment0) {
        this.a = 1;
        super();
        this.b = i40;
        this.c = musicPlaylistBaseFragment0;
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.c;
        Object object1 = this.b;
        if(this.a != 0) {
            if(q.b(((ShowContextMenuAddToPopup)(((I4)object1))).getFrom(), "toolbar")) {
                ((MusicPlaylistBaseViewModel)((MusicPlaylistBaseFragment)object0).getViewModel()).unSelectAll();
            }
            return h0;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(((MusicPlaylistBaseViewModel)object1)), null, null, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2.1.1(((MusicPlaylistBaseViewModel)object1), ((k)(((i)object0))), null), 3, null);
        return h0;
    }
}

