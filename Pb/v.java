package pb;

import M6.B;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import k8.Y;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.c;

public final class v {
    public final s2 a;

    public v(s2 s20) {
        q.g(s20, "playlistManager");
        super();
        this.a = s20;
    }

    public final Object a(c c0) {
        String s2;
        L0 l02;
        PlaylistId playlistId2;
        L0 l01;
        String s1;
        Object object2;
        PlaylistId playlistId1;
        L0 l00;
        String s;
        int v7;
        int v6;
        int v5;
        PlaylistId playlistId0;
        int v2;
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v = u0.M;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.M = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.G;
        a a0 = a.a;
        int v1 = 0;
        s2 s20 = this.a;
        switch(u0.M) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)s20).h();
                u0.r = null;
                u0.w = null;
                u0.D = 0;
                u0.E = 0;
                u0.M = 1;
                object0 = ListenableFutureKt.await(b0, u0);
                if(object0 == a0) {
                    return a0;
                }
                v2 = 0;
                goto label_33;
            }
            case 1: {
                int v3 = u0.E;
                int v4 = u0.D;
                n.D(object0);
                v1 = v4;
                v2 = v3;
            label_33:
                B b1 = ((d3)s20).e();
                u0.r = null;
                u0.w = null;
                u0.B = (PlaylistId)object0;
                u0.D = v1;
                u0.E = v2;
                u0.M = 2;
                Object object1 = ListenableFutureKt.await(b1, u0);
                if(object1 == a0) {
                    return a0;
                }
                playlistId0 = (PlaylistId)object0;
                object0 = object1;
                v5 = v1;
                goto label_50;
            }
            case 2: {
                v2 = u0.E;
                v5 = u0.D;
                playlistId0 = u0.B;
                n.D(object0);
            label_50:
                if(((Playable)object0) == null) {
                    LogU.Companion.d("UpdateCurrentPlayableLikeUseCase", "Current playable is null.");
                }
                else {
                    u0.r = null;
                    u0.w = null;
                    u0.B = null;
                    u0.D = v5;
                    u0.E = v2;
                    u0.M = 3;
                    if(((d3)s20).B(playlistId0, ((Playable)object0), u0) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 3: {
                n.D(object0);
                return H.a;
            }
            case 4: {
                try {
                    v6 = u0.E;
                    v7 = u0.D;
                    s = u0.w;
                    l00 = u0.r;
                    n.D(object0);
                    playlistId1 = (PlaylistId)object0;
                    B b2 = ((d3)s20).e();
                    u0.r = l00;
                    u0.w = s;
                    u0.B = playlistId1;
                    u0.D = v7;
                    u0.E = v6;
                    u0.M = 5;
                    object2 = ListenableFutureKt.await(b2, u0);
                }
                catch(Throwable throwable0) {
                    s1 = s;
                    l01 = l00;
                    goto label_120;
                }
                if(object2 == a0) {
                    return a0;
                }
                playlistId2 = playlistId1;
                object0 = object2;
                l02 = l00;
                goto label_97;
            }
            case 5: {
                try {
                    v6 = u0.E;
                    v7 = u0.D;
                    PlaylistId playlistId3 = u0.B;
                    s2 = u0.w;
                    l02 = u0.r;
                    n.D(object0);
                    playlistId2 = playlistId3;
                    s = s2;
                }
                catch(Throwable throwable0) {
                    s1 = s2;
                    l01 = l02;
                    Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_97:
                    if(((Playable)object0) == null) {
                        LogU.Companion.d("UpdateCurrentPlayableLikeUseCase", "Current playable is null.");
                        break;
                        try {
                        label_108:
                            s1 = u0.w;
                            l01 = u0.r;
                            n.D(object0);
                        }
                        catch(Throwable throwable0) {
                            goto label_120;
                        }
                        l02 = l01;
                        s = s1;
                    }
                    else {
                        u0.r = l02;
                        u0.w = s;
                        u0.B = null;
                        u0.D = v7;
                        u0.E = v6;
                        u0.M = 6;
                        if(((d3)s20).B(playlistId2, ((Playable)object0), u0) == a0) {
                            return a0;
                        }
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    s1 = s;
                    l01 = l02;
                    Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
            }
            case 6: {
                goto label_108;
            label_120:
                Y.v(s1, " false", l01, false);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Y.v(s, " false", l02, false);
        return H.a;
    }
}

