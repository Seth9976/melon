package com.iloen.melon.playback.playlist.db;

import java.util.List;
import kotlin.coroutines.Continuation;
import we.k;

public final class a implements k {
    public final int a;
    public final PlaylistDao_Impl b;
    public final List c;

    public a(PlaylistDao_Impl playlistDao_Impl0, List list0, int v) {
        this.a = v;
        this.b = playlistDao_Impl0;
        this.c = list0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return PlaylistDao_Impl.e(this.b, this.c, ((Continuation)object0));
            }
            case 1: {
                return PlaylistDao_Impl.Q(this.b, this.c, ((G4.a)object0));
            }
            case 2: {
                return PlaylistDao_Impl.T(this.b, this.c, ((G4.a)object0));
            }
            case 3: {
                return PlaylistDao_Impl.O(this.b, this.c, ((Continuation)object0));
            }
            case 4: {
                return PlaylistDao_Impl.c(this.b, this.c, ((G4.a)object0));
            }
            case 5: {
                return PlaylistDao_Impl.y(this.b, this.c, ((Continuation)object0));
            }
            case 6: {
                return PlaylistDao_Impl.V(this.b, this.c, ((G4.a)object0));
            }
            case 7: {
                return PlaylistDao_Impl.i(this.b, this.c, ((Continuation)object0));
            }
            case 8: {
                return PlaylistDao_Impl.C(this.b, this.c, ((G4.a)object0));
            }
            case 9: {
                return PlaylistDao_Impl.b(this.b, this.c, ((G4.a)object0));
            }
            case 10: {
                return PlaylistDao_Impl.o(this.b, this.c, ((Continuation)object0));
            }
            case 11: {
                return PlaylistDao_Impl.l(this.b, this.c, ((G4.a)object0));
            }
            case 12: {
                return PlaylistDao_Impl.a0(this.b, this.c, ((Continuation)object0));
            }
            case 13: {
                return PlaylistDao_Impl.P(this.b, this.c, ((G4.a)object0));
            }
            case 14: {
                return PlaylistDao_Impl.t(this.b, this.c, ((Continuation)object0));
            }
            case 15: {
                return PlaylistDao_Impl.G(this.b, this.c, ((G4.a)object0));
            }
            case 16: {
                return PlaylistDao_Impl.F(this.b, this.c, ((Continuation)object0));
            }
            case 17: {
                return PlaylistDao_Impl.a(this.b, this.c, ((G4.a)object0));
            }
            case 18: {
                return PlaylistDao_Impl.g(this.b, this.c, ((Continuation)object0));
            }
            case 19: {
                return PlaylistDao_Impl.q(this.b, this.c, ((Continuation)object0));
            }
            case 20: {
                return PlaylistDao_Impl.s(this.b, this.c, ((Continuation)object0));
            }
            case 21: {
                return PlaylistDao_Impl.c0(this.b, this.c, ((Continuation)object0));
            }
            default: {
                return PlaylistDao_Impl.r(this.b, this.c, ((Continuation)object0));
            }
        }
    }
}

