package com.iloen.melon.player.playlist.music;

import Ce.g;
import com.iloen.melon.utils.log.LogU;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import oc.c0;
import we.k;

public final class h implements k {
    public final int a;
    public final int b;
    public final MusicPlaylistBaseViewModel c;

    public h(int v, MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        this.a = 1;
        super();
        this.b = v;
        this.c = musicPlaylistBaseViewModel0;
    }

    public h(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, int v) {
        this.a = 0;
        super();
        this.c = musicPlaylistBaseViewModel0;
        this.b = v;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.c;
        int v = this.b;
        if(this.a != 0) {
            q.g(((Success)object0), "prevState");
            List list0 = ((Success)object0).getSongList();
            SongUiState songUiState0 = (SongUiState)p.n0(v, list0);
            if(songUiState0 == null) {
                LogU.error$default(musicPlaylistBaseViewModel0.q, "select() Invalid index: " + v, null, false, 6, null);
                return (Success)object0;
            }
            List list1 = musicPlaylistBaseViewModel0.t.b(list0, songUiState0);
            return list0.size() >= 2 ? Success.copy$default(((Success)object0), null, false, false, null, null, list1, 0, c0.b, 0x5F, null) : Success.copy$default(((Success)object0), null, false, false, null, null, list1, 0, c0.c, 0x5F, null);
        }
        q.g(((Success)object0), "prevState");
        List list2 = ((Success)object0).getSongList();
        j j0 = new j(musicPlaylistBaseViewModel0, 0);
        musicPlaylistBaseViewModel0.t.getClass();
        q.g(list2, "itemList");
        g g0 = new g(v, v, 1);  // 初始化器: LCe/e;-><init>(III)V
        return Success.copy$default(((Success)object0), null, false, false, null, null, musicPlaylistBaseViewModel0.t.c(g0, list2, j0), 0, null, 0xDF, null);
    }
}

