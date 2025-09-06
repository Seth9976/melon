package com.iloen.melon.player.playlist.music;

import Mb.v;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.c0;
import we.k;

public final class j implements k {
    public final int a;
    public final MusicPlaylistBaseViewModel b;

    public j(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, int v) {
        this.a = v;
        this.b = musicPlaylistBaseViewModel0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((c0)object0), "state");
                musicPlaylistBaseViewModel0.f(new com.iloen.melon.player.playlist.music.k(((c0)object0), 0));
                return h0;
            }
            case 1: {
                q.g(((c0)object0), "state");
                musicPlaylistBaseViewModel0.f(new com.iloen.melon.player.playlist.music.k(((c0)object0), 1));
                return h0;
            }
            case 2: {
                q.g(((Success)object0), "prevState");
                List list0 = ((Success)object0).getSongList();
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object2: list0) {
                        if(((SongUiState)object2).isSelected()) {
                            return Success.copy$default(((Success)object0), null, false, false, null, null, musicPlaylistBaseViewModel0.t.a(list0, false), 0, null, 0xDF, null);
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                List list1 = musicPlaylistBaseViewModel0.t.a(list0, true);
                return list0.size() >= 2 ? Success.copy$default(((Success)object0), null, false, false, null, null, list1, 0, c0.b, 0x5F, null) : Success.copy$default(((Success)object0), null, false, false, null, null, list1, 0, c0.c, 0x5F, null);
            }
            case 3: {
                q.g(((Success)object0), "prevState");
                return Success.copy$default(((Success)object0), null, false, false, null, null, musicPlaylistBaseViewModel0.t.a(((Success)object0).getSongList(), false), 0, c0.b, 0x5F, null);
            }
            default: {
                Iterable iterable0 = ((Success)object0).getSongList();
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object1: iterable0) {
                    v v0 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                    q.f("", "getContentId(...)");
                    v0.getClass();
                    arrayList0.add(SongUiState.copy$default(((SongUiState)object1), null, null, null, null, null, false, false, false, v.b(""), null, 0x2FF, null));
                }
                return Success.copy$default(((Success)object0), null, false, false, null, null, arrayList0, 0, null, 0xDF, null);
            }
        }
    }
}

