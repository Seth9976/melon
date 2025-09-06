package pb;

import M6.B;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import d5.n;
import ie.H;
import k8.Y;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.c;

public final class t {
    public final s2 a;

    public t(s2 s20) {
        q.g(s20, "playlistManager");
        super();
        this.a = s20;
    }

    public final Object a(int v, String s, c c0, boolean z) {
        String s13;
        Playable playable0;
        L0 l03;
        String s11;
        String s10;
        String s9;
        PlaylistId playlistId3;
        boolean z5;
        L0 l02;
        int v13;
        L0 l01;
        String s8;
        Object object4;
        s2 s22;
        PlaylistId playlistId2;
        String s7;
        L0 l00;
        String s6;
        boolean z4;
        int v12;
        int v11;
        int v10;
        int v8;
        int v7;
        boolean z2;
        Object object3;
        PlaylistId playlistId0;
        String s3;
        int v4;
        int v3;
        String s2;
        Object object1;
        int v2;
        boolean z1;
        s2 s21;
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v1 = s1.T;
            if((v1 & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.T = v1 ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.N;
        a a0 = a.a;
        H h0 = H.a;
        s2 s20 = this.a;
        switch(s1.T) {
            case 0: {
                s21 = s20;
                n.D(object0);
                B b0 = ((d3)s21).h();
                s1.r = s;
                s1.w = null;
                s1.B = null;
                z1 = z;
                s1.E = z1;
                s1.G = v;
                v2 = 0;
                s1.I = 0;
                s1.M = 0;
                s1.T = 1;
                object1 = ListenableFutureKt.await(b0, s1);
                if(object1 == a0) {
                    return a0;
                }
                s2 = s;
                v3 = v;
                v4 = 0;
                goto label_46;
            }
            case 1: {
                s21 = s20;
                int v5 = s1.M;
                int v6 = s1.I;
                v3 = s1.G;
                z1 = s1.E;
                s2 = s1.r;
                n.D(object0);
                v2 = v5;
                v4 = v6;
                object1 = object0;
            label_46:
                B b1 = ((d3)s21).e();
                s1.r = s2;
                s1.w = null;
                s1.B = null;
                s1.D = (PlaylistId)object1;
                s1.E = z1;
                s1.G = v3;
                s1.I = v4;
                s1.M = v2;
                s1.T = 2;
                Object object2 = ListenableFutureKt.await(b1, s1);
                if(object2 == a0) {
                    return a0;
                }
                s3 = s2;
                playlistId0 = (PlaylistId)object1;
                object3 = object2;
                z2 = z1;
                v7 = v3;
                v8 = v4;
                goto label_78;
            }
            case 2: {
                s21 = s20;
                int v9 = s1.M;
                v8 = s1.I;
                v7 = s1.G;
                boolean z3 = s1.E;
                PlaylistId playlistId1 = s1.D;
                String s4 = s1.r;
                n.D(object0);
                s3 = s4;
                z2 = z3;
                playlistId0 = playlistId1;
                v2 = v9;
                object3 = object0;
            label_78:
                String s5 = ((Playable)object3) == null ? null : "";
                if(q.b(s5, s3)) {
                    s1.r = null;
                    s1.w = null;
                    s1.B = null;
                    s1.D = null;
                    s1.E = z2;
                    s1.G = v7;
                    s1.I = v8;
                    s1.M = v2;
                    s1.T = 3;
                    H h1 = ((b)((d3)s21).a).g0(playlistId0, ((Playable)object3), v7, z2, s1);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 == a0) {
                        return a0;
                    }
                }
                else {
                    LogU.Companion.d("UpdateCurrentPlayableLikeByContentIdUseCase", "Current playable is not the target song. current:" + s5 + ", target:" + s3);
                }
                return h0;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            case 4: {
                try {
                    v10 = s1.M;
                    v11 = s1.I;
                    v12 = s1.G;
                    z4 = s1.E;
                    s6 = s1.B;
                    l00 = s1.w;
                    s7 = s1.r;
                    n.D(object0);
                    playlistId2 = (PlaylistId)object0;
                    s22 = s20;
                    B b2 = ((d3)s20).e();
                    s1.r = s7;
                    s1.w = l00;
                    s1.B = s6;
                    s1.D = playlistId2;
                    s1.E = z4;
                    s1.G = v12;
                    s1.I = v11;
                    s1.M = v10;
                    s1.T = 5;
                    object4 = ListenableFutureKt.await(b2, s1);
                }
                catch(Throwable throwable0) {
                    s8 = s6;
                    l01 = l00;
                    goto label_190;
                }
                if(object4 == a0) {
                    return a0;
                }
                v13 = v11;
                l02 = l00;
                z5 = z4;
                playlistId3 = playlistId2;
                s9 = s6;
                s10 = s7;
                goto label_152;
            }
            case 5: {
                try {
                    v10 = s1.M;
                    int v14 = s1.I;
                    v12 = s1.G;
                    boolean z6 = s1.E;
                    PlaylistId playlistId4 = s1.D;
                    s11 = s1.B;
                    l03 = s1.w;
                    String s12 = s1.r;
                    n.D(object0);
                    playlistId3 = playlistId4;
                    s9 = s11;
                    z5 = z6;
                    s22 = s20;
                    v13 = v14;
                    l02 = l03;
                    s10 = s12;
                    object4 = object0;
                }
                catch(Throwable throwable0) {
                    l01 = l03;
                    s8 = s11;
                    goto label_190;
                }
                try {
                label_152:
                    if(((Playable)object4) == null) {
                        playable0 = (Playable)object4;
                        s13 = null;
                    }
                    else {
                        playable0 = (Playable)object4;
                        s13 = "";
                    }
                    if(q.b(s13, s10)) {
                        s1.r = null;
                        s1.w = l02;
                        s1.B = s9;
                        s1.D = null;
                        s1.E = z5;
                        s1.G = v12;
                        s1.I = v13;
                        s1.M = v10;
                        s1.T = 6;
                        H h2 = ((b)((d3)s22).a).g0(playlistId3, playable0, v12, z5, s1);
                        if(h2 != a0) {
                            h2 = h0;
                        }
                        if(h2 == a0) {
                            return a0;
                        }
                        s8 = s9;
                        l01 = l02;
                    }
                    else {
                        LogU.Companion.d("UpdateCurrentPlayableLikeByContentIdUseCase", "Current playable is not the target song. current:" + s13 + ", target:" + s10);
                        goto label_192;
                        try {
                        label_178:
                            s8 = s1.B;
                            l01 = s1.w;
                            n.D(object0);
                        }
                        catch(Throwable throwable0) {
                            goto label_190;
                        }
                    }
                    s9 = s8;
                    l02 = l01;
                    goto label_192;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 6: {
                goto label_178;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        s8 = s9;
        l01 = l02;
    label_190:
        Y.v(s8, " false", l01, false);
        throw throwable0;
    label_192:
        Y.v(s9, " false", l02, false);
        return h0;
    }
}

