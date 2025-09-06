package kc;

import Vb.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.MelonDebugUtils;
import com.melon.playlist.b;
import d5.n;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ne.a;
import oc.H;
import oc.Q;
import oc.w;
import oe.c;

public final class h {
    public final i a;

    public h(i i0) {
        q.g(i0, "melonInternalPlaylistManager");
        super();
        this.a = i0;
    }

    public final Object a(c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.D;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.D = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Enum enum0 = f0.w;
        a a0 = a.a;
        i i0 = this.a;
        switch(f0.D) {
            case 0: {
                n.D(enum0);
                f0.D = 1;
                enum0 = ((b)i0).s(f0);
                if(enum0 == a0) {
                    return a0;
                }
                goto label_23;
            }
            case 1: {
                n.D(enum0);
            label_23:
                f0.D = 2;
                enum0 = ((b)i0).G(((PlaylistId)enum0), f0);
                if(enum0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(enum0);
                break;
            }
            case 3: {
                H h0 = f0.r;
                n.D(enum0);
                return new d(((Q)enum0), h0.k());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        f0.r = (H)enum0;
        f0.D = 3;
        Object object0 = ((H)enum0).b(f0);
        return object0 == a0 ? a0 : new d(((Q)object0), ((H)enum0).k());
    }

    public final Object b(List list0, c c0) {
        i i1;
        List list1;
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.E;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.E = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Enum enum0 = g0.B;
        a a0 = a.a;
        switch(g0.E) {
            case 0: {
                n.D(enum0);
                g0.r = list0;
                i i0 = this.a;
                g0.w = i0;
                g0.E = 1;
                Enum enum1 = ((b)i0).s(g0);
                if(enum1 == a0) {
                    return a0;
                }
                list1 = list0;
                i1 = i0;
                enum0 = enum1;
                break;
            }
            case 1: {
                i1 = g0.w;
                list1 = g0.r;
                n.D(enum0);
                break;
            }
            case 2: {
                n.D(enum0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g0.r = null;
        g0.w = null;
        g0.E = 2;
        return ((b)i1).V(((PlaylistId)enum0), list1, g0) == a0 ? a0 : ie.H.a;
    }

    public final void c(long v) {
        b b0 = (b)this.a;
        LogU logU0 = b0.l;
        PlaylistId playlistId0 = b0.t();
        if(playlistId0 == null) {
            MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "saveTimePosition - playlistId is null");
            return;
        }
        w w0 = b0.H(playlistId0);
        if(w0 == null) {
            MelonDebugUtils.INSTANCE.errorLogOrException(logU0, "saveTimePosition - playlist is null");
            return;
        }
        L0 l00 = new L0(w0, v, b0, null);
        BuildersKt__Builders_commonKt.launch$default(b0.m, null, null, l00, 3, null);
    }
}

