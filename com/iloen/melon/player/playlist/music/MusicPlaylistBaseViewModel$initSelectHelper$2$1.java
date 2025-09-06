package com.iloen.melon.player.playlist.music;

import Ud.f;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import oc.c0;
import we.k;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0007\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"com/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$initSelectHelper$2$1", "LUd/f;", "Lcom/iloen/melon/player/playlist/music/SongUiState;", "Lkotlin/Function1;", "Loc/c0;", "Lie/H;", "callback", "onStart", "(Lwe/k;)V", "onEnd", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistBaseViewModel.initSelectHelper.2.1 implements f {
    @Override  // Ud.f
    public void onEnd(k k0) {
        q.g(k0, "callback");
        k0.invoke(c0.b);
    }

    @Override  // Ud.f
    public void onStart(k k0) {
        q.g(k0, "callback");
        k0.invoke(c0.e);
    }
}

