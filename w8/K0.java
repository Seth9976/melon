package w8;

import Cc.e0;
import E2.i;
import H0.e;
import Ma.m;
import O2.h;
import V4.s;
import V4.u;
import Vc.G;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.google.firebase.b;
import com.iloen.melon.playback.Actor;
import d5.n;
import df.v;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.Y;
import k8.o;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import ob.z;
import oe.c;
import q2.f;
import sd.g;

public final class k0 extends T {
    public final Actor d;
    public static final f e;

    static {
        k0.e = v.n("show_multi_streaming_msg");
    }

    public k0() {
        this.d = Actor.Widget_cover;
    }

    @Override  // w8.T
    public final Actor d() {
        throw null;
    }

    @Override  // w8.T
    public final Object e(Context context0, D2.f f0, Continuation continuation0) {
        h0 h00;
        if(continuation0 instanceof h0) {
            h00 = (h0)continuation0;
            int v = h00.E;
            if((v & 0x80000000) == 0) {
                h00 = new h0(this, ((c)continuation0));
            }
            else {
                h00.E = v ^ 0x80000000;
            }
        }
        else {
            h00 = new h0(this, ((c)continuation0));
        }
        Object object0 = h00.B;
        a a0 = a.a;
        H h0 = H.a;
        switch(h00.E) {
            case 0: {
                n.D(object0);
                h00.r = context0;
                h00.w = f0;
                h00.E = 1;
                if(h0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                f0 = h00.w;
                context0 = h00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.g(context0, "context");
        q.g(f0, "glanceId");
        s s0 = s.c0(context0);
        String s1 = f0.toString();
        q.g(s1, "tag");
        q.f(s0.k.a, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        e5.c c0 = new e5.c(s0, s1);
        e.O(s0.i.m, "CancelWorkByTag_" + s1, s0.k.a, c0);
        return h0;
    }

    @Override  // w8.T
    public final void f(Context context0, D2.f f0, Continuation continuation0) {
        i0 i00;
        if(continuation0 instanceof i0) {
            i00 = (i0)continuation0;
            int v = i00.B;
            if((v & 0x80000000) == 0) {
                i00 = new i0(this, ((c)continuation0));
            }
            else {
                i00.B = v ^ 0x80000000;
            }
        }
        else {
            i00 = new i0(this, ((c)continuation0));
        }
        Object object0 = i00.r;
        switch(i00.B) {
            case 0: {
                n.D(object0);
                q.g(context0, "context");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                z z0 = ((o)(((Ma.o)b.B(context1, Ma.o.class)))).k();
                m0.b b0 = new m0.b(0xA97400D, new a0(this, z0.i(), z0, ((s2)((o)(((m)Y.e(context0, m.class)))).w.get()), f0, 0), true);
                i00.B = 1;
                b.M(b0, i00);
                return;
            }
            case 1: {
                n.D(object0);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final void i(Flow flow0, z z0, s2 s20, l l0, int v) {
        q.g(flow0, "playbackStateFlow");
        q.g(s20, "playlistManager");
        ((p)l0).c0(0x14CB9687);
        int v1 = (((p)l0).i(flow0) ? 4 : 2) | v | (((p)l0).i(z0) ? 0x20 : 16) | (((p)l0).g(s20) ? 0x100 : 0x80) | (((p)l0).i(this) ? 0x800 : 0x400);
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            e.a(u.n(B2.l.a).b(new B2.c(new h(0x7F06016A))), null, m0.c.e(0x399E4069, ((p)l0), new V(flow0, s20, z0, this)), ((p)l0), 0x180, 2);  // color:gray900e
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new V(this, flow0, z0, s20, v);
        }
    }

    public final void j(int v, B2.n n0, String s, boolean z, i i0, boolean z1, l l0, int v1, int v2) {
        B2.n n3;
        boolean z2;
        int v4;
        ((p)l0).c0(0x84CB556);
        int v3 = ((v1 & 6) == 0 ? v1 | (((p)l0).e(v) ? 4 : 2) : v1) | (((p)l0).g(n0) ? 0x20 : 16) | (((p)l0).g(s) ? 0x100 : 0x80) | (((p)l0).h(z) ? 0x800 : 0x400) | (((p)l0).i(i0) ? 0x4000 : 0x2000);
        if((v2 & 0x20) == 0) {
            z2 = z1;
            v4 = v3 | (((p)l0).h(z2) ? 0x20000 : 0x10000);
        }
        else {
            v4 = v3 | 0x30000;
            z2 = z1;
        }
        boolean z3 = true;
        if(((p)l0).Q(v4 & 1, (74899 & v4) != 74898)) {
            boolean z4 = (v2 & 0x20) == 0 ? z2 : true;
            if(!z || !z4) {
                ((p)l0).a0(-693588500);
                ((p)l0).p(false);
                n3 = n0;
            }
            else {
                ((p)l0).a0(0xD6A6B60D);
                B2.n n1 = e0.U(B2.l.a, i0);
                if((v4 & 0x380) != 0x100) {
                    z3 = false;
                }
                g g0 = ((p)l0).N();
                if(z3 || g0 == k.a) {
                    g0 = new g(s, 9);
                    ((p)l0).l0(g0);
                }
                B2.n n2 = n0.b(K2.c.a(n1, g0));
                ((p)l0).p(false);
                n3 = n2;
            }
            e.a(n3, null, m0.c.e(-325560008, ((p)l0), new qd.b(z4, n0, v, z)), ((p)l0), 0x180, 2);
            z2 = z4;
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.c(this, v, n0, s, z, i0, z2, v1, v2);
        }
    }

    public final void k(int v, B2.n n0, String s, boolean z, PendingIntent pendingIntent0, l l0, int v1) {
        B2.n n1;
        ((p)l0).c0(0x7DE4BD39);
        int v2 = (((p)l0).g(n0) ? 0x20 : 16) | v1 | (((p)l0).g(s) ? 0x100 : 0x80) | (((p)l0).h(z) ? 0x800 : 0x400) | (((p)l0).i(pendingIntent0) ? 0x4000 : 0x2000);
        boolean z1 = true;
        if(((p)l0).Q(v2 & 1, (v2 & 9363) != 9362)) {
            RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D02ED);  // layout:glance_button
            remoteViews0.setImageViewResource(0x7F0A01CA, v);  // id:button
            remoteViews0.setInt(0x7F0A01CA, "setAlpha", (z ? 0xFF : 77));  // id:button
            remoteViews0.setOnClickPendingIntent(0x7F0A01CA, (z ? pendingIntent0 : null));  // id:button
            ((p)l0).a0(0x97AA9F00);
            if(z) {
                ((p)l0).a0(0xBCE2EFFF);
                if((v2 & 0x380) != 0x100) {
                    z1 = false;
                }
                g g0 = ((p)l0).N();
                if(z1 || g0 == k.a) {
                    g0 = new g(s, 8);
                    ((p)l0).l0(g0);
                }
                n1 = K2.c.a(n0, g0);
                ((p)l0).p(false);
            }
            else {
                ((p)l0).a0(0xBCE2F653);
                ((p)l0).p(false);
                n1 = n0;
            }
            ((p)l0).p(false);
            Q1.c.a(remoteViews0, n1, ((p)l0), 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new G(this, v, n0, s, z, pendingIntent0, v1);
        }
    }

    public final PendingIntent l(Context context0, Intent intent0, int v) {
        ActivityOptions activityOptions0 = ActivityOptions.makeBasic();
        activityOptions0.setLaunchDisplayId(v);
        Bundle bundle0 = activityOptions0.toBundle();
        PendingIntent pendingIntent0 = PendingIntent.getActivity(context0, this.d.ordinal(), intent0, 0xC000000, bundle0);
        q.f(pendingIntent0, "getActivity(...)");
        return pendingIntent0;
    }
}

