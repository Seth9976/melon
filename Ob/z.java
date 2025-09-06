package ob;

import Ac.F2;
import M6.B;
import Pb.p;
import Qb.k;
import U4.F;
import Ub.q;
import ac.d;
import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playback.command.SetABRangeRepeatResult.SetRangeBResult;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.n;
import ea.b;
import fc.a;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import kc.O2;
import kc.X2;
import kc.d3;
import kc.s2;
import kc.x2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import oc.H;
import oc.M;
import oc.O;
import oc.Q;
import oc.e;
import oc.k0;
import oc.l0;
import oe.c;
import oe.i;
import uc.l;

public final class z {
    public final b a;
    public final StringProviderImpl b;
    public final q c;
    public final s2 d;
    public final Qb.z e;
    public final LogU f;

    public z(b b0, StringProviderImpl stringProviderImpl0, q q0, s2 s20, Qb.z z0) {
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        kotlin.jvm.internal.q.g(s20, "playlistManager");
        kotlin.jvm.internal.q.g(z0, "playerController");
        super();
        this.a = b0;
        this.b = stringProviderImpl0;
        this.c = q0;
        this.d = s20;
        this.e = z0;
        this.f = Companion.create$default(LogU.Companion, "PlayerUseCase", false, null, 6, null);
    }

    public static void A(z z0) {
        z0.getClass();
        q q0 = z0.c;
        long v = q0.a().d - 15000L;
        if(v < 0L) {
            v = 0L;
        }
        q0.a();
        z0.e.v(v);
    }

    public static void B(z z0, int v) {
        z0.getClass();
        q q0 = z0.c;
        long v1 = q0.a().d;
        long v2 = q0.a().e;
        if(v1 != 0x8000000000000001L && v2 != 0x8000000000000001L) {
            q0.a();
            z0.e.v(v1 - ((long)(((float)v2) * 0.2f)));
        }
    }

    public static void C(z z0) {
        z0.getClass();
        q q0 = z0.c;
        a a0 = q0.a();
        long v = q0.a().e;
        long v1 = a0.d + 15000L;
        if(v1 <= v) {
            v = v1;
        }
        q0.a();
        z0.e.v(v);
    }

    public static void D(z z0, int v) {
        z0.getClass();
        q q0 = z0.c;
        long v1 = q0.a().d;
        long v2 = q0.a().e;
        if(v1 != 0x8000000000000001L && v2 != 0x8000000000000001L) {
            q0.a();
            z0.e.v(v1 + ((long)(((float)v2) * 0.2f)));
        }
    }

    public final Object E(c c0) {
        M m0;
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v = u0.B;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.B = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.r;
        ne.a a0 = ne.a.a;
        s2 s20 = this.d;
        switch(u0.B) {
            case 0: {
                n.D(object0);
                F2 f20 = ((d3)s20).d();
                u0.B = 1;
                object0 = FlowKt.first(f20, u0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        switch(((M)object0).ordinal()) {
            case 1: {
                m0 = M.c;
                break;
            }
            case 2: {
                m0 = M.a;
                break;
            }
            default: {
                m0 = M.b;
            }
        }
        B b0 = ((d3)s20).y(m0);
        u0.B = 2;
        Object object1 = ListenableFutureKt.await(b0, u0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object F(c c0) {
        v v0;
        if(c0 instanceof v) {
            v0 = (v)c0;
            int v1 = v0.B;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(this, c0);
            }
            else {
                v0.B = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(this, c0);
        }
        Object object0 = v0.r;
        ne.a a0 = ne.a.a;
        s2 s20 = this.d;
        switch(v0.B) {
            case 0: {
                n.D(object0);
                F2 f20 = ((d3)s20).c();
                v0.B = 1;
                object0 = FlowKt.first(f20, v0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        B b0 = ((d3)s20).z(!((Boolean)object0).booleanValue());
        v0.B = 2;
        Object object1 = ListenableFutureKt.await(b0, v0);
        return object1 == a0 ? a0 : object1;
    }

    public final Object G(c c0) {
        SetABRangeRepeatResult.SetRangeBResult setABRangeRepeatResult$SetRangeBResult0;
        d d1;
        Object object1;
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.D;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.D = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.w;
        ne.a a0 = ne.a.a;
        Qb.z z0 = this.e;
        switch(w0.D) {
            case 0: {
                n.D(object0);
                d d0 = this.c.a().j;
                long v1 = this.j().a;
                if(kotlin.jvm.internal.q.b(d0, ac.a.a)) {
                    w0.r = d0;
                    w0.D = 1;
                    object1 = z0.w(v1, w0);
                    if(object1 == a0) {
                        return a0;
                    }
                    d1 = d0;
                    object0 = object1;
                    break;
                }
                else if(d0 instanceof ac.b) {
                    w0.r = d0;
                    w0.D = 2;
                    Object object2 = z0.x(v1, w0);
                    if(object2 == a0) {
                        return a0;
                    }
                    d1 = d0;
                    object0 = object2;
                    setABRangeRepeatResult$SetRangeBResult0 = (SetABRangeRepeatResult.SetRangeBResult)object0;
                    z0.s();
                }
                else {
                    if(!(d0 instanceof ac.c)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    w0.r = d0;
                    w0.D = 3;
                    object1 = z0.p(w0);
                    if(object1 == a0) {
                        return a0;
                    }
                    d1 = d0;
                    object0 = object1;
                    break;
                }
                break;
            }
            case 2: {
                d1 = w0.r;
                n.D(object0);
                setABRangeRepeatResult$SetRangeBResult0 = (SetABRangeRepeatResult.SetRangeBResult)object0;
                z0.s();
                break;
            }
            case 1: 
            case 3: {
                d1 = w0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.f, "setOrClearRangeRepeatWithCurrentPosition curState: " + d1 + ", result: " + ((p)object0), null, false, 6, null);
        return object0;
    }

    public final Object H(PlaylistId playlistId0, List list0, c c0) {
        x x0;
        if(c0 instanceof x) {
            x0 = (x)c0;
            int v = x0.B;
            if((v & 0x80000000) == 0) {
                x0 = new x(this, c0);
            }
            else {
                x0.B = v ^ 0x80000000;
            }
        }
        else {
            x0 = new x(this, c0);
        }
        Object object0 = x0.r;
        ne.a a0 = ne.a.a;
        switch(x0.B) {
            case 0: {
                n.D(object0);
                d3 d30 = (d3)this.d;
                if(playlistId0 != d30.j()) {
                    d30.a(playlistId0);
                }
                d30.getClass();
                kotlin.jvm.internal.q.g(list0, "indices");
                X2 x20 = new X2(d30, list0, null);
                B b0 = ListenableFutureKt.future$default(d30.b, null, null, x20, 3, null);
                x0.B = 1;
                object0 = ListenableFutureKt.await(b0, x0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((l0)object0) instanceof k0) {
            ToastManager.showShort(0x7F130911);  // string:section_repeat_mode_set "반복재생이 설정되었습니다."
            this.e.s();
        }
        return (l0)object0;
    }

    public final Object I(we.n n0, c c0) {
        int v1;
        H h0;
        y y0;
        if(c0 instanceof y) {
            y0 = (y)c0;
            int v = y0.G;
            if((v & 0x80000000) == 0) {
                y0 = new y(this, c0);
            }
            else {
                y0.G = v ^ 0x80000000;
            }
        }
        else {
            y0 = new y(this, c0);
        }
        Object object0 = y0.D;
        ne.a a0 = ne.a.a;
        switch(y0.G) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                y0.r = (i)n0;
                y0.G = 1;
                object0 = ListenableFutureKt.await(b0, y0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 1: {
                n0 = (we.n)y0.r;
                n.D(object0);
            label_22:
                h0 = (H)object0;
                v1 = !this.c.a().b;
                if(n0 != null) {
                    y0.r = null;
                    y0.w = h0;
                    y0.B = v1;
                    y0.G = 2;
                    if(n0.invoke(Boolean.valueOf(((boolean)v1)), y0) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 2: {
                int v2 = y0.B;
                H h1 = y0.w;
                n.D(object0);
                v1 = v2;
                h0 = h1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Qb.z z0 = this.e;
        if(v1 != 0) {
            if(!e1.b.D(h0.getState())) {
                z0.s();
                return ie.H.a;
            }
            ToastManager.showShort(this.f(h0.getId()));
            return ie.H.a;
        }
        z0.r();
        return ie.H.a;
    }

    public static boolean a(PlaylistId playlistId0) {
        return playlistId0 == null ? false : e1.n.k(playlistId0);
    }

    public final Object b(int v, Continuation continuation0) {
        ob.c c0;
        if(continuation0 instanceof ob.c) {
            c0 = (ob.c)continuation0;
            int v1 = c0.D;
            if((v1 & 0x80000000) == 0) {
                c0 = new ob.c(this, continuation0);
            }
            else {
                c0.D = v1 ^ 0x80000000;
            }
        }
        else {
            c0 = new ob.c(this, continuation0);
        }
        Object object0 = c0.w;
        ne.a a0 = ne.a.a;
        switch(c0.D) {
            case 0: {
                n.D(object0);
                x2 x20 = new x2(((d3)this.d), null);
                B b0 = ListenableFutureKt.future$default(((d3)this.d).b, null, null, x20, 3, null);
                c0.r = v;
                c0.D = 1;
                object0 = ListenableFutureKt.await(b0, c0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = c0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((e)object0) instanceof oc.d) {
            ToastManager.show(v);
        }
        return ie.H.a;
    }

    public final void c(int v, long v1) {
        this.e.getClass();
        k k0 = new k(v, v1, this.e, null);
        this.e.f(k0);
    }

    public final a d(a a0) {
        Uri uri1;
        String s9;
        String s7;
        Uri uri0;
        String s4;
        String s2;
        PlayableData playableData0;
        oc.w w0 = ((d3)this.d).k();
        String s = null;
        if(w0 == null) {
            playableData0 = null;
        }
        else {
            Q q0 = w0.getState();
            playableData0 = q0 == null ? null : e1.b.z(q0);
        }
        Playable playable0 = playableData0 == null ? null : playableData0.a;
        long v = 0x8000000000000001L;
        if(a0.c.length() == 0) {
            long v1 = w0 == null ? 0x8000000000000001L : w0.k();
            if(playable0 != null) {
                v = playable0.getDuration();
            }
            if(playableData0 == null) {
                s2 = "";
            }
            else {
                String s1 = playableData0.h;
                s2 = s1 == null ? "" : s1;
            }
            if(playableData0 == null) {
                s4 = "";
            }
            else {
                String s3 = playableData0.i;
                s4 = s3 == null ? "" : s3;
            }
            if(playableData0 == null) {
                uri0 = Uri.EMPTY;
            }
            else {
                uri0 = playableData0.n;
                if(uri0 == null) {
                    uri0 = Uri.EMPTY;
                }
            }
            kotlin.jvm.internal.q.d(uri0);
            return new a(false, v1, v, s2, s4, uri0, 0x307);
        }
        String s5 = F.Y(a0.c).a;
        if(playable0 != null) {
            s = "";
        }
        if(!s5.equals(s)) {
            long v2 = w0 == null ? 0x8000000000000001L : w0.k();
            if(playable0 != null) {
                v = playable0.getDuration();
            }
            if(playableData0 == null) {
                s7 = "";
            }
            else {
                String s6 = playableData0.h;
                s7 = s6 == null ? "" : s6;
            }
            if(playableData0 == null) {
                s9 = "";
            }
            else {
                String s8 = playableData0.i;
                s9 = s8 == null ? "" : s8;
            }
            if(playableData0 == null) {
                uri1 = Uri.EMPTY;
            }
            else {
                uri1 = playableData0.n;
                if(uri1 == null) {
                    uri1 = Uri.EMPTY;
                }
            }
            kotlin.jvm.internal.q.d(uri1);
            return new a(a0.b, v2, v, s7, s9, uri1, 0x305);
        }
        return a0.e == 0x8000000000000001L ? a.a(a0, 0, false, null, 0L, playable0.getDuration(), null, null, null, null, null, 1007) : a0;
    }

    public final A e(a a0) {
        oc.w w0 = ((d3)this.d).k();
        Playable playable0 = ((d3)this.d).f();
        long v = a0.d;
        long v1 = 0x8000000000000001L;
        if(a0.c.length() == 0) {
            long v2 = w0 == null ? 0x8000000000000001L : w0.k();
            if(playable0 != null) {
                v1 = playable0.getDuration();
            }
            return new A(v2, v1);
        }
        if(!F.Y(a0.c).a.equals((playable0 == null ? null : ""))) {
            long v3 = w0 == null ? 0x8000000000000001L : w0.k();
            if(playable0 != null) {
                v1 = playable0.getDuration();
            }
            return new A(v3, v1);
        }
        return a0.e == 0x8000000000000001L ? new A(v, playable0.getDuration()) : new A(v, a0.e);
    }

    public final String f(PlaylistId playlistId0) {
        kotlin.jvm.internal.q.g(playlistId0, "playlistId");
        return ob.b.a[playlistId0.ordinal()] == 1 ? this.b.a(0x7F13082C) : this.b.a(0x7F13082B);  // string:playlist_empty_mv "재생할 비디오가 없습니다."
    }

    public final Flow g() {
        return FlowKt.distinctUntilChanged(FlowKt.combine(this.h(), ((d3)this.d).i(), new Uc.z(3, 1, null)));
    }

    public final Flow h() {
        return FlowKt.distinctUntilChanged(new F2(FlowKt.asStateFlow(this.c.b), 25));
    }

    public final Flow i() {
        return FlowKt.callbackFlow(new ob.i(this, null));
    }

    public final A j() {
        return this.e(this.c.a());
    }

    public static Flow k(z z0) {
        z0.getClass();
        return FlowKt.callbackFlow(new m(z0, null));
    }

    public final Object l(c c0) {
        ob.n n0;
        if(c0 instanceof ob.n) {
            n0 = (ob.n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new ob.n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new ob.n(this, c0);
        }
        Object object0 = n0.r;
        ne.a a0 = ne.a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                n0.B = 1;
                object0 = ListenableFutureKt.await(b0, n0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        oc.z z0 = ((H)object0) instanceof oc.z ? ((oc.z)(((H)object0))) : null;
        if(z0 != null) {
            O o0 = z0.e();
            if(o0 != null) {
                List list0 = o0.d();
                if(list0 != null) {
                    return list0;
                }
            }
        }
        return je.w.a;
    }

    public final Object m(int v, c c0) {
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v1 = o0.D;
            if((v1 & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.D = v1 ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                o0.r = v;
                o0.D = 1;
                object0 = ListenableFutureKt.await(b0, o0);
                if(object0 == a0) {
                    return a0;
                }
                return ((H)object0) instanceof oc.z ? Boolean.valueOf(((oc.z)(((H)object0))).e().d().contains(new Integer(v))) : false;
            }
            case 1: {
                v = o0.r;
                n.D(object0);
                return ((H)object0) instanceof oc.z ? Boolean.valueOf(((oc.z)(((H)object0))).e().d().contains(new Integer(v))) : false;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final boolean n() {
        return this.c.a().b;
    }

    public final Object o(Continuation continuation0) {
        ob.p p0;
        if(continuation0 instanceof ob.p) {
            p0 = (ob.p)continuation0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new ob.p(this, continuation0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new ob.p(this, continuation0);
        }
        Object object0 = p0.r;
        ne.a a0 = ne.a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                p0.B = 1;
                object0 = ListenableFutureKt.await(b0, p0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        oc.z z0 = ((H)object0) instanceof oc.z ? ((oc.z)(((H)object0))) : null;
        if(z0 != null) {
            O o0 = z0.e();
            return o0 == null ? Boolean.valueOf(((boolean)0)) : Boolean.valueOf(!o0.d().isEmpty());
        }
        return Boolean.valueOf(((boolean)0));
    }

    public final Object p(PlaylistId playlistId0, int v, c c0) {
        int v2;
        ob.q q0;
        if(c0 instanceof ob.q) {
            q0 = (ob.q)c0;
            int v1 = q0.G;
            if((v1 & 0x80000000) == 0) {
                q0 = new ob.q(this, c0);
            }
            else {
                q0.G = v1 ^ 0x80000000;
            }
        }
        else {
            q0 = new ob.q(this, c0);
        }
        Object object0 = q0.D;
        ne.a a0 = ne.a.a;
        boolean z = false;
        switch(q0.G) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).h();
                q0.r = playlistId0;
                q0.w = v;
                q0.G = 1;
                object0 = ListenableFutureKt.await(b0, q0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                v = q0.w;
                playlistId0 = q0.r;
                n.D(object0);
            label_25:
                v2 = playlistId0 == object0 ? 1 : 0;
                q0.r = null;
                q0.w = v;
                q0.B = v2;
                q0.G = 2;
                object0 = this.o(q0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_36;
            }
            case 2: {
                v2 = q0.B;
                v = q0.w;
                n.D(object0);
            label_36:
                if(((Boolean)object0).booleanValue()) {
                    if(v2 == 0) {
                        return true;
                    }
                    q0.w = v;
                    q0.B = v2;
                    q0.G = 3;
                    object0 = this.m(v, q0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_46;
                }
                break;
            }
            case 3: {
                n.D(object0);
            label_46:
                if(!((Boolean)object0).booleanValue()) {
                    z = true;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return Boolean.valueOf(z);
    }

    public final Object q(Continuation continuation0) {
        r r0;
        if(continuation0 instanceof r) {
            r0 = (r)continuation0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, continuation0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, continuation0);
        }
        Object object0 = r0.r;
        ne.a a0 = ne.a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                r0.B = 1;
                object0 = ListenableFutureKt.await(b0, r0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!e1.b.D(((H)object0).getState())) {
            this.e.q();
            return ie.H.a;
        }
        ToastManager.showShort(this.f(((H)object0).getId()));
        return ie.H.a;
    }

    public final Object r(c c0) {
        s s0;
        if(c0 instanceof s) {
            s0 = (s)c0;
            int v = s0.B;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, c0);
            }
            else {
                s0.B = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, c0);
        }
        Object object0 = s0.r;
        ne.a a0 = ne.a.a;
        switch(s0.B) {
            case 0: {
                n.D(object0);
                O2 o20 = new O2(((d3)this.d), null);
                B b0 = ListenableFutureKt.future$default(((d3)this.d).b, null, null, o20, 3, null);
                s0.B = 1;
                object0 = ListenableFutureKt.await(b0, s0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        uc.B b1 = ((uc.A)(((l)object0))).e();
        int v1 = this.a.j(b1, false);
        ie.H h0 = ie.H.a;
        if(v1 == -1) {
            LogU.debug$default(this.f, "nextVod() - No next video", null, false, 6, null);
            return h0;
        }
        this.e.u(v1);
        return h0;
    }

    public final void s() {
        this.e.r();
    }

    public final void t() {
        if(this.n()) {
            this.s();
        }
        ((d3)this.d).b();
    }

    public final void u() {
        this.e.s();
    }

    public final void v(int v) {
        this.e.u(v);
    }

    public final void w(PlaylistId playlistId0, int v) {
        kotlin.jvm.internal.q.g(playlistId0, "playlistId");
        d3 d30 = (d3)this.d;
        if(playlistId0 != d30.j()) {
            d30.a(playlistId0);
        }
        this.e.u(v);
    }

    public final Object x(boolean z, c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.D;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.D = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.w;
        ne.a a0 = ne.a.a;
        switch(t0.D) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)this.d).g();
                t0.r = z;
                t0.D = 1;
                object0 = ListenableFutureKt.await(b0, t0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                z = t0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!e1.b.D(((H)object0).getState())) {
            this.e.t(z);
            return ie.H.a;
        }
        ToastManager.showShort(this.f(((H)object0).getId()));
        return ie.H.a;
    }

    public final void y(int v, long v1) {
        this.e.getClass();
        Qb.s s0 = new Qb.s(v, v1, this.e, null);
        this.e.f(s0);
    }

    public final void z(long v) {
        this.e.v(v);
    }
}

