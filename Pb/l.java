package pb;

import Ad.x;
import Ad.y;
import M6.B;
import Na.e;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import d5.n;
import ie.H;
import java.util.List;
import k8.b;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.Q;
import oe.c;
import qb.g;

public final class l {
    public final s2 a;

    public l(s2 s20, int v) {
        switch(v) {
            case 1: {
                q.g(s20, "playlistManager");
                super();
                this.a = s20;
                return;
            }
            case 2: {
                q.g(s20, "playlistManager");
                super();
                this.a = s20;
                return;
            }
            default: {
                q.g(s20, "playlistManager");
                super();
                this.a = s20;
            }
        }
    }

    public static e a(y y0) {
        q.g(y0, "type");
        List list0 = y0.a();
        return y0 instanceof x ? new e(new g(list0, MelonSettingInfo.getPlayListAddPosition(), MelonSettingInfo.getNormalPlayListAddPosition(), MelonSettingInfo.getDjPlayListAddPosition())) : new e(new g(list0, null, null, null));
    }

    public Object b(PlaylistId playlistId0, Playable playable0, c c0) {
        String s;
        pb.y y0;
        if(c0 instanceof pb.y) {
            y0 = (pb.y)c0;
            int v = y0.D;
            if((v & 0x80000000) == 0) {
                y0 = new pb.y(this, c0);
            }
            else {
                y0.D = v ^ 0x80000000;
            }
        }
        else {
            y0 = new pb.y(this, c0);
        }
        Object object0 = y0.w;
        a a0 = a.a;
        int v1 = y0.D;
        switch(v1) {
            case 0: {
                n.D(object0);
                y0.r = null;
                y0.D = 1;
                return ((d3)this.a).B(playlistId0, playable0, y0) == a0 ? a0 : H.a;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                try {
                    s = y0.r;
                    n.D(object0);
                }
                catch(Throwable unused_ex) {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append(s);
                    stringBuilder0.append(" false");
                    throw null;
                }
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(s);
                stringBuilder1.append(" false");
                throw null;
            }
        }
    }

    public Object c(k8.a a0, c c0) {
        String s;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.E;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.E = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.B;
        a a1 = a.a;
        H h0 = H.a;
        switch(i0.E) {
            case 0: {
                n.D(object0);
                if(a0 != null) {
                    s = "RemoveCurrentPlayableWhenIsAdultUseCase";
                    ((b)a0).a("RemoveCurrentPlayableWhenIsAdultUseCase true", true);
                    try {
                        i0.r = a0;
                        i0.w = "RemoveCurrentPlayableWhenIsAdultUseCase";
                        i0.E = 2;
                        if(this.d(i0) == a1) {
                            return a1;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        a0.a(s + " false", false);
                        throw throwable0;
                    }
                }
                i0.E = 3;
                return this.d(i0) == a1 ? a1 : h0;
            }
            case 1: {
                n.D(object0);
                return h0;
            }
            case 2: {
                try {
                    String s1 = i0.w;
                    k8.a a2 = i0.r;
                    s = s1;
                    a0 = a2;
                    n.D(object0);
                    s = s1;
                    a0 = a2;
                    break;
                }
                catch(Throwable throwable1) {
                    throwable0 = throwable1;
                }
                a0.a(s + " false", false);
                throw throwable0;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a0.a(s + " false", false);
        return h0;
    }

    public Object d(c c0) {
        PlaylistId playlistId0;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.w;
        a a0 = a.a;
        H h0 = H.a;
        s2 s20 = this.a;
        switch(k0.D) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)s20).h();
                k0.D = 1;
                object0 = ListenableFutureKt.await(b0, k0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_24;
            }
            case 1: {
                n.D(object0);
            label_24:
                playlistId0 = (PlaylistId)object0;
                B b1 = ((d3)s20).p(playlistId0);
                k0.r = playlistId0;
                k0.D = 2;
                object0 = ListenableFutureKt.await(b1, k0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                playlistId0 = k0.r;
                n.D(object0);
                break;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Q q0 = ((oc.H)object0).getState();
        int v1 = q0.b();
        Playable playable0 = e1.b.y(q0);
        if(playable0 != null && playable0.isAdult()) {
            B b2 = ((d3)s20).w(playlistId0, e.k.z(new Integer(v1)));
            k0.r = null;
            k0.D = 3;
            if(ListenableFutureKt.await(b2, k0) == a0) {
                return a0;
            }
        }
        return h0;
    }
}

