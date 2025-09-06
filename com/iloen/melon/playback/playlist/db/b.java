package com.iloen.melon.playback.playlist.db;

import java.util.List;
import kotlin.coroutines.Continuation;
import we.k;

public final class b implements k {
    public final int a;
    public final PlaylistDao_Impl b;
    public final List c;
    public final List d;

    public b(PlaylistDao_Impl playlistDao_Impl0, List list0, List list1, int v) {
        this.a = v;
        this.b = playlistDao_Impl0;
        this.c = list0;
        this.d = list1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return PlaylistDao_Impl.n(this.b, this.c, this.d, ((Continuation)object0));
            }
            case 1: {
                return PlaylistDao_Impl.D(this.b, this.c, this.d, ((Continuation)object0));
            }
            case 2: {
                return PlaylistDao_Impl.E(this.b, this.c, this.d, ((Continuation)object0));
            }
            default: {
                return PlaylistDao_Impl.L(this.b, this.c, this.d, ((Continuation)object0));
            }
        }
    }
}

