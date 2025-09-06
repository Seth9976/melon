package w8;

import Ac.S0;
import B2.a;
import B2.h;
import B2.n;
import Cc.e0;
import D2.E;
import E2.k;
import J2.o;
import Ma.m;
import O2.b;
import O2.e;
import Rc.F;
import V4.u;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.activity.WidgetMoreViewActivity;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import df.v;
import i.n.i.b.a.s.e.M3;
import k8.Y;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ob.z;
import oe.c;
import q2.f;

public abstract class w0 extends T {
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;

    static {
        w0.d = v.n("is_landscape");
        w0.e = v.z("actual_height");
        w0.f = v.n("is_white_type");
        w0.g = new f("skin_alpha");
    }

    @Override  // w8.T
    public final void f(Context context0, D2.f f0, Continuation continuation0) {
        w0.v(this, context0, f0, ((c)continuation0));
    }

    public final void i(l l0, int v) {
        ((p)l0).c0(0x5DE2D1BE);
        int v1 = (((p)l0).i(this) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = u.G(20.0f);
            ((p)l0).a0(0x70757499);
            Intent intent0 = new Intent("com.iloen.melon.intent.action.MAIN");
            intent0.setComponent(new ComponentName(((Context)((p)l0).k(h.b)), MusicBrowserActivity.class));
            intent0.addFlags(0x10000000);
            intent0.putExtra("com.iloen.melon.intent.extra.actor", this.d());
            ((p)l0).p(false);
            n n1 = e0.U(n0, k.a(intent0));
            E9.h.g(new a(0x7F08061D), "멜론 로고", n1, 0, ((p)l0), 0, 24);  // drawable:img_comment_logo
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new w8.n0(this, v, 0);
        }
    }

    public final void j(boolean z, l l0, int v) {
        ((p)l0).c0(0xDABDB581);
        int v1 = (((p)l0).h(z) ? 4 : 2) | v | (((p)l0).i(this) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = e0.U(u.G(28.0f), this.s(((Context)((p)l0).k(h.b))));
            E9.h.g(new a((z ? 0x7F08029C : 0x7F08029B)), "더보기", n0, 0, ((p)l0), 0, 24);  // drawable:btn_widget_more_w
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Fd.h(this, z, v, 6);
        }
    }

    public final void k(z z0, s2 s20, boolean z1, n n0, n n1, l l0, int v, int v1) {
        n n6;
        n n5;
        int v8;
        n n3;
        n n4;
        int v6;
        n n2;
        q.g(z0, "playerUseCase");
        q.g(s20, "playlistManager");
        ((p)l0).c0(1903768937);
        int v2 = ((p)l0).i(z0) ? 4 : 2;
        int v3 = ((p)l0).g(s20) ? 0x20 : 16;
        int v4 = ((p)l0).h(z1) ? 0x100 : 0x80;
        int v5 = (v1 & 8) != 0 || !((p)l0).g(n0) ? 0x400 : 0x800;
        if((v1 & 16) == 0) {
            n2 = n1;
            v6 = ((p)l0).g(n2) ? 0x4000 : 0x2000;
        }
        else {
            n2 = n1;
            v6 = 0x2000;
        }
        int v7 = v | v2 | v3 | v4 | v5 | v6 | (((p)l0).i(this) ? 0x20000 : 0x10000);
        if(((p)l0).Q(v7 & 1, (74899 & v7) != 74898)) {
            ((p)l0).V();
            if((v & 1) == 0 || ((p)l0).B()) {
                if((v1 & 8) == 0) {
                    n4 = n0;
                }
                else {
                    n4 = u.G(44.0f);
                    v7 &= 0xFFFFE3FF;
                }
                if((v1 & 16) != 0) {
                    n2 = new o(e.a).b(new J2.u(e.a));
                    v7 &= 0xFFFF1FFF;
                }
                v8 = v7;
                n3 = n4;
            }
            else {
                ((p)l0).T();
                if((v1 & 8) != 0) {
                    v7 &= 0xFFFFE3FF;
                }
                if((v1 & 16) != 0) {
                    v7 &= 0xFFFF1FFF;
                }
                n3 = n0;
                v8 = v7;
            }
            ((p)l0).q();
            H0.e.a(n3, null, m0.c.e(0x10D91147, ((p)l0), new F(s20, z0, this, z1, n2, 2)), ((p)l0), v8 >> 9 & 14 | 0x180, 2);
            n5 = n2;
            n6 = n3;
        }
        else {
            ((p)l0).T();
            n5 = n2;
            n6 = n0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new ed.n(this, z0, s20, z1, n6, n5, v, v1);
        }
    }

    public final void l(l l0, int v) {
        ((p)l0).c0(0x9A7C0601);
        int v1 = (((p)l0).i(this) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            q.f("스테이션", "getString(...)");
            int v2 = ((Context)((p)l0).k(h.b)).getColor(0x7F06017A);  // color:green500e_support_high_contrast
            ((p)l0).a0(-342705556);
            Intent intent0 = new Intent("com.iloen.melon.intent.action.MAIN");
            intent0.setComponent(new ComponentName(((Context)((p)l0).k(h.b)), MusicBrowserActivity.class));
            intent0.addFlags(0x10000000);
            intent0.putExtra("com.iloen.melon.intent.extra.actor", this.d());
            ((p)l0).p(false);
            E2.h h0 = k.a(intent0);
            this.b("스테이션", v2, 14.0f, e0.U(B2.l.a, h0), ((p)l0), v1 << 12 & 0xE000 | 0x180, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new w8.n0(this, v, 1);
        }
    }

    public abstract void m(Flow arg1, z arg2, s2 arg3, boolean arg4, long arg5, l arg6, int arg7);

    public abstract void n(Flow arg1, z arg2, s2 arg3, boolean arg4, long arg5, boolean arg6, int arg7, l arg8, int arg9);

    public final void o(Playable playable0, Uri uri0, boolean z, float f, boolean z1, boolean z2, l l0, int v, int v1) {
        boolean z4;
        ((p)l0).c0(910303166);
        int v2 = (((p)l0).i(playable0) ? 4 : 2) | v | (((p)l0).i(uri0) ? 0x20 : 16) | (((p)l0).h(z) ? 0x100 : 0x80);
        if((v & 0xC00) == 0) {
            v2 |= (((p)l0).d(f) ? 0x800 : 0x400);
        }
        int v3 = v2 | (((p)l0).h(z1) ? 0x4000 : 0x2000);
        if((v1 & 0x20) != 0) {
            v3 |= 0x30000;
        }
        else if((0x30000 & v) == 0) {
            v3 |= (((p)l0).h(z2) ? 0x20000 : 0x10000);
        }
        int v4 = v3 | (((p)l0).i(this) ? 0x100000 : 0x80000);
        if(((p)l0).Q(v4 & 1, (0x92493 & v4) != 0x92492)) {
            boolean z3 = (v1 & 0x20) == 0 ? z2 : false;
            ((p)l0).a0(0xAE394919);
            Intent intent0 = new Intent();
            intent0.setComponent(new ComponentName(((Context)((p)l0).k(h.b)), MusicBrowserActivity.class));
            intent0.addFlags(0x10000000);
            intent0.putExtra("com.iloen.melon.intent.extra.actor", this.d());
            ((p)l0).p(false);
            if(playable0 == null) {
                intent0.setAction("com.iloen.melon.ALBUM_INFO");
            }
            else if(z) {
                intent0.setAction("com.iloen.melon.MELON_PLAYER_START");
                intent0.putExtra("activitystartactionname", "player");
            }
            else if(!playable0.isTypeOfSong()) {
                intent0.setAction("com.iloen.melon.ALBUM_INFO");
            }
            else if(!Tf.o.H0("") == 1) {
                intent0.setAction("com.iloen.melon.ALBUM_INFO");
                intent0.putExtra("com.iloen.melon.intent.extra.widget.album_id", "");
            }
            else {
                intent0.setAction("com.iloen.melon.ALBUM_INFO");
            }
            n n0 = u.G(f).b(new B2.c(new O2.h((z1 ? 0x7F0604C3 : 0x7F060144))));  // color:widget_default_bg
            if(z3) {
                n0 = n0.b(new E(new b(4.0f)));
            }
            E2.h h0 = k.a(intent0);
            n n1 = n0.b(e0.U(B2.l.a, h0));
            m0.b b0 = m0.c.e(0xD098C5A0, ((p)l0), new C(uri0, z1, z3));
            H0.e.a(n1, J2.c.d, b0, ((p)l0), 0x180, 0);
            z4 = z3;
        }
        else {
            ((p)l0).T();
            z4 = z2;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new S0(this, playable0, uri0, z, f, z1, z4, v, v1);
        }
    }

    public static Flow p(s2 s20, l l0) {
        q.g(s20, "playlistManager");
        Flow flow0 = ((p)l0).N();
        if(flow0 == androidx.compose.runtime.k.a) {
            flow0 = FlowKt.callbackFlow(new s0(s20, null));
            ((p)l0).l0(flow0);
        }
        return flow0;
    }

    public abstract String q();

    public abstract String r();

    public final E2.h s(Context context0) {
        q.g(context0, "context");
        Intent intent0 = new Intent();
        Q1.c.Y(intent0, "com.iloen.melon.intent.action.widget.more", true);
        intent0.setComponent(new ComponentName(context0, WidgetMoreViewActivity.class));
        intent0.addFlags(0x8000);
        intent0.putExtra("com.iloen.melon.intent.extra.actor", this.d());
        return k.a(intent0);
    }

    public final E2.h t(Context context0) {
        q.g(context0, "context");
        Intent intent0 = new Intent("com.iloen.melon.MELON_PLAYER_START");
        intent0.setComponent(new ComponentName(context0, MusicBrowserActivity.class));
        intent0.addFlags(0x10000000);
        intent0.putExtra("activitystartactionname", "player");
        intent0.putExtra("com.iloen.melon.intent.extra.actor", this.d());
        return k.a(intent0);
    }

    public abstract int u();

    public static void v(w0 w00, Context context0, D2.f f0, c c0) {
        t0 t00;
        if(c0 instanceof t0) {
            t00 = (t0)c0;
            int v = t00.B;
            if((v & 0x80000000) == 0) {
                t00 = new t0(w00, c0);
            }
            else {
                t00.B = v ^ 0x80000000;
            }
        }
        else {
            t00 = new t0(w00, c0);
        }
        Object object0 = t00.r;
        switch(t00.B) {
            case 0: {
                d5.n.D(object0);
                LogU.Companion.d("GlanceHomeAppWidgetBase", "id: " + f0);
                q.g(context0, "context");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                z z0 = ((k8.o)(((Ma.o)com.google.firebase.b.B(context1, Ma.o.class)))).k();
                m0.b b0 = new m0.b(0x2322044E, new m0(w00, z0.i(), z0, ((s2)((k8.o)(((m)Y.e(context0, m.class)))).w.get()), context0, f0, 0), true);
                t00.B = 1;
                com.google.firebase.b.M(b0, t00);
                return;
            }
            case 1: {
                d5.n.D(object0);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

