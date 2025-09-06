package k8;

import Ac.G0;
import Ac.L3;
import Ac.M0;
import Ac.N2;
import Ac.g0;
import Ac.h0;
import Ac.r4;
import Ad.J;
import Ba.B;
import Ba.u;
import Bd.P;
import Dd.K1;
import Dd.g1;
import Fc.D;
import Fc.p;
import Hd.n0;
import I6.p0;
import Ic.A0;
import Kc.Y;
import Kc.k0;
import Oc.N;
import Oc.U;
import Vb.o0;
import Vb.t0;
import Vb.u0;
import ad.q0;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.a0;
import androidx.media3.session.e0;
import androidx.media3.session.f0;
import androidx.media3.session.legacy.V;
import b3.S;
import bc.c;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.S0;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel_Factory;
import com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel_Factory;
import com.iloen.melon.player.playlist.PlaylistMainViewModel_Factory;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel;
import com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel_Factory;
import com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel;
import com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel_Factory;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel_Factory;
import com.iloen.melon.player.playlist.music.MusicPlaylistViewModel;
import com.iloen.melon.player.playlist.music.MusicPlaylistViewModel_Factory;
import com.iloen.melon.player.playlist.music.SmartPlaylistViewModel_Factory;
import com.iloen.melon.player.playlist.search.PlaylistSearchViewModel_Factory;
import com.iloen.melon.player.video.LiveViewModel;
import com.iloen.melon.player.video.VideoPipPvLogManager;
import com.iloen.melon.player.video.VideoViewModel;
import com.iloen.melon.popup.RemoteConnectPopupViewModel;
import com.iloen.melon.userstore.VolatileDatabase;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.service.SearchApi;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.comment.CommentAttachPagerViewModel;
import com.melon.ui.interfaces.ColorProviderImpl;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n4;
import com.melon.ui.t3;
import com.melon.utils.preference.PreferenceHelper;
import com.melon.utils.system.SystemSettingUtils;
import d5.e;
import d5.f;
import d5.t;
import db.g;
import dd.C;
import dd.M;
import e1.F;
import ea.d;
import eb.y;
import fe.a;
import gd.B4;
import gd.C5;
import gd.C6;
import gd.D8;
import gd.E3;
import gd.F0;
import gd.G;
import gd.O7;
import gd.P5;
import gd.V1;
import gd.a1;
import gd.b0;
import gd.d5;
import gd.e3;
import gd.f4;
import gd.i4;
import gd.n2;
import gd.n6;
import gd.p5;
import gd.r1;
import gd.y2;
import ge.b;
import hc.l;
import hd.O1;
import hd.m1;
import hd.n1;
import id.A;
import ie.m;
import jd.Y1;
import jd.l3;
import jd.w2;
import kb.s;
import kc.H1;
import kc.h;
import kc.s2;
import kc.t1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowKt;
import ld.x;
import mb.k;
import mb.n;
import ob.z;
import qb.I;
import qd.W;
import rd.L1;
import td.u1;
import ud.O;
import ud.R0;
import wc.w;
import xd.r;
import yc.E;
import zd.c0;

public final class i implements b {
    public final int a;
    public final o b;
    public final int c;
    public final a d;

    public i(o o0, a a0, int v, int v1) {
        this.a = v1;
        this.b = o0;
        this.d = a0;
        this.c = v;
        super();
    }

    private final Object a() {
        j j0 = (j)this.d;
        Service service0 = j0.a;
        o o0 = this.b;
        int v = this.c;
        switch(v) {
            case 0: {
                Context context0 = o0.a.a;
                t.e(context0);
                Object object3 = j0.e.get();
                Object object4 = j0.f.get();
                q.g(((S)object3), "player");
                q.g(((e0)object4), "callback");
                e3.b.c(((S)object3).X());
                Bundle bundle0 = new Bundle();
                Bundle bundle1 = new Bundle();
                PendingIntent pendingIntent0 = PendingIntent.getActivity(context0, 0, new Intent(context0, MusicBrowserActivity.class).setAction("com.iloen.melon.MELON_PLAYER_START").addCategory("android.intent.category.DEFAULT").addFlags(0x10000000).putExtra("activitystartactionname", "player"), 0x4000000);
                e3.b.c(pendingIntent0.isActivity());
                pendingIntent0.getClass();
                f0 f00 = new f0(context0, ((S)object3), pendingIntent0, p0.e, p0.e, p0.e, ((e0)object4), bundle0, bundle1, new d(new DataSourceBitmapLoader(context0)));  // 初始化器: Landroidx/media3/session/y0;-><init>(Landroid/content/Context;Lb3/S;Landroid/app/PendingIntent;LI6/V;LI6/V;LI6/V;Landroidx/media3/session/e0;Landroid/os/Bundle;Landroid/os/Bundle;Lea/d;)V
                Bundle bundle2 = new Bundle(f.j(new m[]{new m("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", Boolean.TRUE), new m("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", Boolean.TRUE)}));
                f00.a.D = bundle2;
                a0 a00 = new a0(bundle2, 1);
                f00.a.d(a00);
                LogU.debug$default(Rb.a.a, "provideMediaSession()", null, false, 6, null);
                return f00;
            }
            case 1: {
                CoroutineScope coroutineScope2 = (CoroutineScope)j0.c.get();
                CoroutineDispatcher coroutineDispatcher0 = h0.C();
                CoroutineDispatcher coroutineDispatcher1 = h0.A();
                CoroutineDispatcher coroutineDispatcher2 = h0.B();
                MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain().getImmediate();
                t.e(mainCoroutineDispatcher0);
                u0 u00 = o0.p();
                Object object1 = o0.q1.get();
                Ub.q q0 = (Ub.q)o0.u.get();
                c c0 = (c)o0.t1.get();
                Object object2 = o0.A0.get();
                h h0 = (h)j0.d.get();
                ec.c c1 = (ec.c)o0.u1.get();
                com.melon.playback.melon.drm.c c2 = (com.melon.playback.melon.drm.c)o0.B0.get();
                k k0 = (k)o0.m.get();
                q.g(coroutineScope2, "coroutineScope");
                q.g(((Wb.b)object1), "analyticsManager");
                q.g(q0, "playbackManager");
                q.g(c0, "streamingHelper");
                q.g(((t0)object2), "playerRules");
                q.g(h0, "currentPlaylist");
                q.g(c1, "epPlayAnalyticsHelper");
                q.g(c2, "drmContentsHelper");
                q.g(k0, "loginUseCase");
                o0 o00 = new o0(service0, coroutineScope2, coroutineDispatcher0, coroutineDispatcher1, coroutineDispatcher2, mainCoroutineDispatcher0, u00, q0, h0, ((Wb.b)object1), c0, c1, ((t0)object2), c2, k0);
                LogU.debug$default(Rb.a.a, "providePlayer()", null, false, 6, null);
                return o00;
            }
            case 2: {
                CoroutineScope coroutineScope1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
                t.e(coroutineScope1);
                return coroutineScope1;
            }
            case 3: {
                return new h(((kc.i)j0.b.v.get()));
            }
            case 4: {
                CoroutineScope coroutineScope0 = (CoroutineScope)j0.c.get();
                Object object0 = o0.v.get();
                z z0 = o0.k();
                ob.a a0 = o0.i();
                t1 t10 = new t1(((s2)o0.w.get()), o0.k(), ((k8.a)o0.l.get()));
                W w0 = o0.s();
                q.g(coroutineScope0, "coroutineScope");
                q.g(((kc.i)object0), "melonInternalPlaylistManager");
                return new Nb.h0(service0, coroutineScope0, ((kc.i)object0), z0, a0, t10, w0);
            }
            default: {
                throw new AssertionError(v);
            }
        }
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        K1 k10;
        x x0;
        Object object0;
        if(this.a != 0) {
            k8.q q0 = (k8.q)this.d;
            int v = this.c;
            o o0 = this.b;
            switch(v / 100) {
                case 0: {
                    switch(v) {
                        case 0: {
                            object0 = u1.d(q0.y0(), o0.u());
                            k8.q.b(q0, ((wd.t)object0));
                            return object0;
                        }
                        case 1: {
                            object0 = h0.m(new Ua.h(q0.d.a()), q0.B0(), q0.M0(), ((k)o0.m.get()), q0.t1(), q0.p1(), q0.h1(), q0.y1(), q0.x0(), q0.C0(), o0.u(), h0.B());
                            k8.q.c(q0, ((A0)object0));
                            return object0;
                        }
                        case 2: {
                            object0 = u1.e(q0.z0(), q0.M0(), o0.u(), h0.B());
                            k8.q.d(q0, ((r)object0));
                            return object0;
                        }
                        case 3: {
                            object0 = h0.a(k8.q.a(q0), q0.D0(), o0.u());
                            k8.q.e(q0, ((g0)object0));
                            return object0;
                        }
                        case 4: {
                            t.e(o0.a.a);
                            object0 = h0.v(o0.a.a);
                            k8.q.f(q0, ((CommentAttachPagerViewModel)object0));
                            return object0;
                        }
                        case 5: {
                            object0 = h0.b(q0.D0(), o0.u());
                            k8.q.g(q0, ((G0)object0));
                            return object0;
                        }
                        case 6: {
                            object0 = h0.c(k8.q.a(q0), q0.D0(), o0.u());
                            k8.q.h(q0, ((M0)object0));
                            return object0;
                        }
                        case 7: {
                            object0 = h0.d(k8.q.a(q0), q0.D0(), o0.u(), q0.x0(), ((k)o0.m.get()));
                            k8.q.i(q0, ((N2)object0));
                            return object0;
                        }
                        case 8: {
                            object0 = h0.e(k8.q.a(q0), q0.D0(), o0.u(), q0.x0(), ((k)o0.m.get()));
                            k8.q.j(q0, ((L3)object0));
                            return object0;
                        }
                        case 9: {
                            object0 = h0.f(k8.q.a(q0), q0.D0(), o0.u(), q0.x0());
                            k8.q.k(q0, ((r4)object0));
                            return object0;
                        }
                        case 10: {
                            object0 = u1.b(new Ua.h(q0.d.a()), q0.B0(), q0.M0(), ((k)o0.m.get()), q0.t1(), q0.p1(), q0.h1(), q0.y1(), q0.x0(), q0.C0(), o0.u(), h0.B());
                            k8.q.l(q0, ((w)object0));
                            return object0;
                        }
                        case 11: {
                            object0 = h0.g(q0.E0(), h0.B(), ((k)o0.m.get()));
                            k8.q.m(q0, ((J)object0));
                            return object0;
                        }
                        case 12: {
                            object0 = h0.k(((s2)o0.w.get()), o0.k());
                            k8.q.n(q0, ((p)object0));
                            return object0;
                        }
                        case 13: {
                            object0 = h0.l(o0.u(), o0.k(), ((s2)o0.w.get()));
                            k8.q.o(q0, ((D)object0));
                            return object0;
                        }
                        case 14: {
                            t.e(o0.a.a);
                            CoroutineDispatcher coroutineDispatcher0 = h0.C();
                            CoroutineDispatcher coroutineDispatcher1 = h0.B();
                            StringProviderImpl stringProviderImpl0 = o0.u();
                            Object object1 = o0.w.get();
                            z z0 = o0.k();
                            ob.a a0 = o0.i();
                            l l0 = o0.l();
                            Object object2 = o0.m.get();
                            g g0 = o0.o();
                            I i0 = q0.g1();
                            V v1 = q0.L0();
                            Za.b b0 = q0.G0();
                            Q q1 = q0.x0();
                            t3 t30 = q0.p1();
                            b3 b30 = q0.h1();
                            n4 n40 = q0.t1();
                            object0 = L1.a(k8.q.a(q0), o0.a.a, coroutineDispatcher0, coroutineDispatcher1, stringProviderImpl0, ((s2)object1), z0, a0, l0, ((k)object2), g0, i0, v1, b0, q1, t30, b30, n40);
                            k8.q.q(q0, ((rd.K1)object0));
                            return object0;
                        }
                        case 15: {
                            StringProviderImpl stringProviderImpl1 = o0.u();
                            t.e(o0.a.a);
                            Object object3 = o0.w.get();
                            Ua.h h0 = q0.F0();
                            g g1 = o0.o();
                            Q q2 = q0.x0();
                            object0 = h0.h(stringProviderImpl1, o0.a.a, ((s2)object3), h0, g1, q2);
                            k8.q.r(q0, ((P)object0));
                            return object0;
                        }
                        case 16: {
                            object0 = h0.n();
                            k8.q.t(q0, ((Lc.t)object0));
                            return object0;
                        }
                        case 17: {
                            object0 = DrawerFragmentViewModel_Factory.newInstance(new Ya.g(o0.r(), o0.b()), ((k)o0.m.get()), ((s2)o0.w.get()), ((k8.a)o0.l.get()), o0.k(), o0.u());
                            k8.q.u(q0, ((DrawerFragmentViewModel)object0));
                            return object0;
                        }
                        case 18: {
                            object0 = DrawerSongFragmentViewModel_Factory.newInstance(h0.C(), h0.A(), h0.B(), ((k)o0.m.get()), q0.y1(), o0.k(), o0.i(), ((s2)o0.w.get()), ((j9.d)o0.n.get()), o0.u(), q0.x0(), q0.p1(), q0.o1(), q0.h1());
                            k8.q.v(q0, ((DrawerSongFragmentViewModel)object0));
                            return object0;
                        }
                        case 19: {
                            object0 = U8.x.a();
                            k8.q.w(q0, ((U8.w)object0));
                            return object0;
                        }
                        case 20: {
                            object0 = U8.x.b(((k)o0.m.get()), o0.m(), q0.w1(), q0.H0(), ((Uc.q)q0.z.get()), ((Uc.m)q0.A.get()), q0.x0(), o0.k(), o0.o(), ((s2)o0.w.get()), h0.B());
                            k8.q.y(q0, ((Uc.Q)object0));
                            return object0;
                        }
                        case 21: {
                            return h0.z(q0.b);
                        }
                        case 22: {
                            return h0.x();
                        }
                        case 23: {
                            return h0.y();
                        }
                        case 24: {
                            object0 = h0.o(q0.J0(), q0.x0(), o0.u());
                            k8.q.z(q0, ((Oc.k)object0));
                            return object0;
                        }
                        case 25: {
                            object0 = h0.p(q0.J0(), q0.x0());
                            k8.q.A(q0, ((Oc.o)object0));
                            return object0;
                        }
                        case 26: {
                            Ua.h h1 = q0.J0();
                            n4 n41 = q0.t1();
                            t3 t31 = q0.p1();
                            b3 b31 = q0.h1();
                            y y0 = q0.y1();
                            object0 = h0.q(h1, q0.x0(), b31, t31, n41, o0.u(), y0, ((k)o0.m.get()));
                            k8.q.B(q0, ((Oc.x)object0));
                            return object0;
                        }
                        case 27: {
                            object0 = h0.r(q0.J0(), q0.t1(), q0.h1(), q0.x0(), ((k)o0.m.get()));
                            k8.q.C(q0, ((Oc.D)object0));
                            return object0;
                        }
                        case 28: {
                            Ua.h h2 = q0.J0();
                            StringProviderImpl stringProviderImpl2 = o0.u();
                            n4 n42 = q0.t1();
                            t3 t32 = q0.p1();
                            y y1 = q0.y1();
                            b3 b32 = q0.h1();
                            object0 = h0.s(h2, q0.x0(), b32, t32, n42, stringProviderImpl2, y1, ((k)o0.m.get()));
                            k8.q.D(q0, ((N)object0));
                            return object0;
                        }
                        case 29: {
                            object0 = h0.t(q0.J0(), q0.x0());
                            k8.q.E(q0, ((U)object0));
                            return object0;
                        }
                        case 30: {
                            object0 = u1.f(q0.K0(), q0.x0(), q0.p1(), q0.h1(), q0.t1());
                            k8.q.F(q0, ((E)object0));
                            return object0;
                        }
                        case 0x1F: {
                            object0 = u1.c(new Ua.h(q0.d.a()), q0.B0(), q0.M0(), ((k)o0.m.get()), q0.t1(), q0.p1(), q0.h1(), q0.y1(), q0.x0(), q0.C0(), o0.u(), h0.B());
                            k8.q.G(q0, ((wc.x)object0));
                            return object0;
                        }
                        case 0x20: {
                            object0 = ImageToPlaylistViewModel_Factory.newInstance(q0.A1(), q0.p1(), o0.u());
                            k8.q.H(q0, ((ImageToPlaylistViewModel)object0));
                            return object0;
                        }
                        case 33: {
                            return new LiveViewModel(new VideoPipPvLogManager(q0.m1()), ((s2)o0.w.get()), o0.k());
                        }
                        case 34: {
                            object0 = h0.u(q0.x0());
                            k8.q.I(q0, ((Qc.w)object0));
                            return object0;
                        }
                        case 35: {
                            t.e(o0.a.a);
                            StringProviderImpl stringProviderImpl3 = o0.u();
                            Object object4 = o0.w.get();
                            z z1 = o0.k();
                            V v2 = q0.L0();
                            l l1 = o0.l();
                            object0 = Rc.u0.a(o0.a.a, stringProviderImpl3, ((s2)object4), z1, v2, l1);
                            k8.q.J(q0, ((Rc.t0)object0));
                            return object0;
                        }
                        case 36: {
                            object0 = LoginSimpleAccountViewModel_Factory.newInstance(o0.m(), ((k)o0.m.get()), new n(((va.u1)q0.c.I.get()), ((mb.l)q0.c.j.get())), ((k8.a)o0.l.get()));
                            k8.q.K(q0, ((LoginSimpleAccountViewModel)object0));
                            return object0;
                        }
                        case 37: {
                            return new Tc.g(q0.N0(), ((k)o0.m.get()));
                        }
                        case 38: {
                            object0 = h0.i(new d(q0.c.r(), q0.c.b()), q0.M0(), q0.x0(), q0.t1(), o0.u(), ((k)o0.m.get()), q0.D0());
                            k8.q.L(q0, ((Dd.I)object0));
                            return object0;
                        }
                        case 39: {
                            object0 = u1.g(q0.g1(), q0.M0(), q0.L0(), q0.z1(), o0.u(), h0.B(), ((k)o0.m.get()));
                            k8.q.M(q0, ((c0)object0));
                            return object0;
                        }
                        case 40: {
                            object0 = U8.x.e();
                            k8.q.N(q0, ((G)object0));
                            return object0;
                        }
                        case 41: {
                            object0 = U8.x.f(new ea.a(q0.c.b(), ((k)q0.c.m.get())), q0.M0(), q0.I0(), o0.u());
                            k8.q.O(q0, ((b0)object0));
                            return object0;
                        }
                        case 42: {
                            object0 = U8.x.g(new ea.a(q0.c.b(), ((k)q0.c.m.get())), q0.M0(), q0.I0(), o0.u());
                            k8.q.P(q0, ((gd.u0)object0));
                            return object0;
                        }
                        case 43: {
                            object0 = U8.x.h(q0.P0());
                            k8.q.Q(q0, ((F0)object0));
                            return object0;
                        }
                        case 44: {
                            StringProviderImpl stringProviderImpl4 = o0.u();
                            hb.f f0 = q0.Q0();
                            object0 = U8.x.i(q0.x0(), q0.h1(), q0.t1(), stringProviderImpl4, f0, ((k)o0.m.get()));
                            k8.q.R(q0, ((a1)object0));
                            return object0;
                        }
                        case 45: {
                            object0 = U8.x.j(q0.R0(), q0.M0(), o0.u(), ((k)o0.m.get()));
                            k8.q.S(q0, ((r1)object0));
                            return object0;
                        }
                        case 46: {
                            object0 = U8.x.k(q0.S0(), q0.x0(), q0.h1(), q0.t1(), q0.p1(), o0.u());
                            k8.q.T(q0, ((V1)object0));
                            return object0;
                        }
                        case 0x2F: {
                            object0 = U8.x.l(q0.T0(), o0.u());
                            k8.q.U(q0, ((n2)object0));
                            return object0;
                        }
                        case 0x30: {
                            object0 = U8.x.m(q0.U0(), q0.x0(), o0.u());
                            k8.q.V(q0, ((y2)object0));
                            return object0;
                        }
                        case 49: {
                            object0 = U8.x.n(q0.V0(), q0.I0(), ((k)o0.m.get()), q0.x0(), o0.u());
                            k8.q.W(q0, ((e3)object0));
                            return object0;
                        }
                        case 50: {
                            object0 = U8.x.o(q0.W0(), q0.x0(), q0.h1(), q0.t1(), ((k)o0.m.get()));
                            k8.q.X(q0, ((E3)object0));
                            return object0;
                        }
                        case 51: {
                            StringProviderImpl stringProviderImpl5 = o0.u();
                            hb.f f1 = q0.X0();
                            Object object5 = o0.m.get();
                            object0 = U8.x.p(q0.x0(), q0.h1(), q0.t1(), stringProviderImpl5, f1, ((k)object5));
                            k8.q.Y(q0, ((f4)object0));
                            return object0;
                        }
                        case 52: {
                            object0 = U8.x.q();
                            k8.q.Z(q0, ((i4)object0));
                            return object0;
                        }
                        case 53: {
                            object0 = U8.x.r(q0.Y0(), ((k)o0.m.get()), q0.x0(), q0.h1(), q0.t1());
                            k8.q.a0(q0, ((B4)object0));
                            return object0;
                        }
                        case 54: {
                            object0 = U8.x.s(o0.u(), q0.Z0(), q0.M0(), q0.I0(), q0.h1());
                            k8.q.b0(q0, ((d5)object0));
                            return object0;
                        }
                        case 55: {
                            object0 = U8.x.t(q0.a1(), o0.u());
                            k8.q.c0(q0, ((p5)object0));
                            return object0;
                        }
                        case 56: {
                            object0 = U8.x.u(((k)o0.m.get()));
                            k8.q.d0(q0, ((C5)object0));
                            return object0;
                        }
                        case 57: {
                            object0 = U8.x.v(q0.b1(), o0.u());
                            k8.q.e0(q0, ((P5)object0));
                            return object0;
                        }
                        case 58: {
                            object0 = U8.x.w(q0.c1(), q0.M0(), q0.x0(), q0.h1(), q0.t1(), o0.u(), ((k)o0.m.get()));
                            k8.q.f0(q0, ((n6)object0));
                            return object0;
                        }
                        case 59: {
                            object0 = U8.x.x(q0.d1(), q0.B0(), q0.M0(), ((k)o0.m.get()), o0.u());
                            k8.q.g0(q0, ((C6)object0));
                            return object0;
                        }
                        case 60: {
                            object0 = U8.x.y(q0.e1(), q0.h1(), q0.x0(), q0.t1(), ((k)o0.m.get()), o0.u());
                            k8.q.h0(q0, ((O7)object0));
                            return object0;
                        }
                        case 61: {
                            object0 = U8.x.z(q0.f1(), q0.M0(), q0.x0(), o0.u());
                            k8.q.i0(q0, ((D8)object0));
                            return object0;
                        }
                        case 62: {
                            object0 = h0.j(new d(q0.c.r(), q0.c.b()), q0.I0(), q0.x0(), q0.t1(), o0.u(), ((k)o0.m.get()), q0.D0());
                            k8.q.j0(q0, ((g1)object0));
                            return object0;
                        }
                        case 0x3F: {
                            t.e(o0.a.a);
                            StringProviderImpl stringProviderImpl6 = o0.u();
                            Object object6 = o0.w.get();
                            z z2 = o0.k();
                            ob.a a1 = o0.i();
                            y y2 = q0.y1();
                            PlaylistDeleteHelper playlistDeleteHelper0 = q0.o1();
                            Object object7 = o0.m.get();
                            t3 t33 = q0.p1();
                            b3 b33 = q0.h1();
                            Q q3 = q0.x0();
                            g g2 = o0.o();
                            Object object8 = o0.l.get();
                            object0 = MixUpPlaylistComposeViewModel_Factory.newInstance(o0.a.a, stringProviderImpl6, ((s2)object6), z2, a1, y2, playlistDeleteHelper0, ((k)object7), t33, b33, q3, g2, ((k8.a)object8));
                            k8.q.l0(q0, ((MixUpPlaylistComposeViewModel)object0));
                            return object0;
                        }
                        case 0x40: {
                            object0 = n1.a(new ib.f(q0.j1()), new F(), q0.s1(), q0.t1(), q0.x0(), ((k)o0.m.get()));
                            k8.q.m0(q0, ((m1)object0));
                            return object0;
                        }
                        case 65: {
                            object0 = n1.b(q0.i1(), q0.x0(), h0.B());
                            k8.q.n0(q0, ((O1)object0));
                            return object0;
                        }
                        case 66: {
                            CoroutineDispatcher coroutineDispatcher2 = h0.C();
                            CoroutineDispatcher coroutineDispatcher3 = h0.A();
                            CoroutineDispatcher coroutineDispatcher4 = h0.B();
                            StringProviderImpl stringProviderImpl7 = o0.u();
                            Object object9 = o0.w.get();
                            z z3 = o0.k();
                            ob.a a2 = o0.i();
                            l l2 = o0.l();
                            Object object10 = o0.m.get();
                            V v3 = q0.L0();
                            Q q4 = q0.x0();
                            t3 t34 = q0.p1();
                            b3 b34 = q0.h1();
                            n4 n43 = q0.t1();
                            W w0 = o0.s();
                            object0 = u1.a(q0.a, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, stringProviderImpl7, ((s2)object9), z3, a2, l2, ((k)object10), v3, q4, t34, b34, n43, w0);
                            k8.q.o0(q0, ((td.t1)object0));
                            return object0;
                        }
                        case 67: {
                            object0 = MusicPlaylistViewModel_Factory.newInstance(h0.C(), h0.A(), h0.B(), o0.u(), ((s2)o0.w.get()), o0.k(), o0.i(), ((k)o0.m.get()), q0.y1(), q0.x0(), q0.p1(), q0.o1(), q0.h1(), ((k8.a)o0.l.get()));
                            k8.q.p0(q0, ((MusicPlaylistViewModel)object0));
                            return object0;
                        }
                        case 68: {
                            object0 = U8.x.A(q0.k1(), q0.x0(), h0.B());
                            k8.q.q0(q0, ((id.w)object0));
                            return object0;
                        }
                        case 69: {
                            object0 = U8.x.B(q0.k1());
                            k8.q.r0(q0, ((A)object0));
                            return object0;
                        }
                        case 70: {
                            object0 = U8.x.c(((k)o0.m.get()), q0.x1(), q0.B0(), q0.l1(), ((ad.p)q0.w0.get()), q0.x0(), o0.u(), ((s2)o0.w.get()), o0.o(), ((ad.n)q0.x0.get()));
                            k8.q.s0(q0, ((q0)object0));
                            return object0;
                        }
                        case 71: {
                            object0 = U8.x.d();
                            k8.q.v0(q0, ((dd.P)object0));
                            return object0;
                        }
                        case 72: {
                            return h0.w();
                        }
                        case 73: {
                            return new ad.n();  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        case 74: {
                            object0 = new dd.d();
                            k8.q.s(q0, ((dd.d)object0));
                            return object0;
                        }
                        case 75: {
                            object0 = new dd.J();
                            k8.q.t0(q0, ((dd.J)object0));
                            return object0;
                        }
                        case 76: {
                            object0 = new dd.Q();
                            k8.q.w0(q0, ((dd.Q)object0));
                            return object0;
                        }
                        case 77: {
                            object0 = new dd.E();
                            k8.q.k0(q0, ((dd.E)object0));
                            return object0;
                        }
                        case 78: {
                            object0 = new M();
                            k8.q.u0(q0, ((M)object0));
                            return object0;
                        }
                        case 0x4F: {
                            object0 = new dd.c();
                            k8.q.p(q0, ((dd.c)object0));
                            return object0;
                        }
                        case 80: {
                            object0 = new dd.g();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            k8.q.x(q0, ((dd.g)object0));
                            return object0;
                        }
                        case 81: {
                            object0 = new dd.p();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 82: {
                            object0 = new dd.i();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 83: {
                            object0 = new dd.r();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 84: {
                            object0 = new dd.y();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 85: {
                            object0 = new dd.t();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 86: {
                            object0 = new dd.w();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 87: {
                            object0 = new dd.V();  // 初始化器: Ldd/H;-><init>()V
                            object0.g = "";
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 88: {
                            object0 = new C();
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 89: {
                            object0 = new dd.A();
                            t.e(q0.c.a.a);
                            object0.a = (ad.p)q0.w0.get();
                            object0.b = (CoroutineScope)q0.y.get();
                            object0.c = (ad.n)q0.x0.get();
                            object0.d = q0.q1();
                            return object0;
                        }
                        case 90: {
                            object0 = new jd.M0(((s2)o0.w.get()), o0.k(), new s(q0.c.q(), ((k)q0.c.m.get()), q0.n1()), q0.x0(), new jd.t(((B)q0.c.E.get())), ((k)o0.m.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            t.e(q0.c.a.a);
                            object0.g = q0.c.a.a;
                            return object0;
                        }
                        case 91: {
                            object0 = new jd.u1(((s2)o0.w.get()), new kb.A(q0.c.q()), q0.h1(), q0.t1(), q0.p1(), q0.x0(), o0.u());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 92: {
                            object0 = new Y1(new kb.A(q0.c.q()), h0.B(), ((H1)o0.r.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 93: {
                            object0 = new w2(new kb.D(q0.c.q(), 0), ((k)o0.m.get()), o0.u());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 94: {
                            object0 = new ld.c();
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x5F: {
                            x0 = new x(new kb.D(new wa.c(new wa.a(((Ba.D)q0.c.g1.get()))), 20), q0.t1(), q0.p1(), q0.h1(), q0.y1(), q0.x0(), o0.u());
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 0x60: {
                            return new Mb.w();
                        }
                        case 97: {
                            k10 = new K1(new d(q0.c.r(), q0.c.b()), q0.I0(), q0.x0(), q0.t1(), o0.u(), ((k)o0.m.get()));
                            k10.pvUseCase = q0.m1();
                            k10.screenCaptureUseCase = q0.r1();
                            return k10;
                        }
                        case 98: {
                            Ca.b b1 = (Ca.b)q0.d.a.h1.get();
                            q.g(b1, "service");
                            Ua.h h3 = new Ua.h(new S0(new S0(b1, 15), 16));
                            H8.q q5 = q0.M0();
                            Za.b b2 = q0.I0();
                            Ba.f f2 = (Ba.f)q0.c.i1.get();
                            q.g(f2, "service");
                            x0 = new Y(h3, q5, b2, new I7.c(new aa.b(new Ua.h(f2)), 27), q0.t1(), q0.p1(), q0.h1(), q0.y1(), q0.x0(), q0.C0(), o0.u(), h0.B());
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 99: {
                            object0 = new k0(new hb.f(q0.c.b()), ((k)o0.m.get()), h0.B());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        default: {
                            throw new AssertionError(v);
                        }
                    }
                }
                case 1: {
                    x9.b b3 = null;
                    switch(v) {
                        case 100: {
                            object0 = PlaylistMainViewModel_Factory.newInstance(o0.u(), ((s2)o0.w.get()), o0.k(), ((k)o0.m.get()), q0.t1());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 101: {
                            CoroutineDispatcher coroutineDispatcher5 = h0.A();
                            CoroutineDispatcher coroutineDispatcher6 = h0.B();
                            Object object11 = o0.w.get();
                            z z4 = o0.k();
                            ob.a a3 = o0.i();
                            Object object12 = o0.m.get();
                            y y3 = q0.y1();
                            PlaylistDeleteHelper playlistDeleteHelper1 = q0.o1();
                            StringProviderImpl stringProviderImpl8 = o0.u();
                            Q q6 = q0.x0();
                            t3 t35 = q0.p1();
                            b3 b35 = q0.h1();
                            object0 = PlaylistSearchViewModel_Factory.newInstance(q0.a, coroutineDispatcher5, coroutineDispatcher6, ((s2)object11), z4, a3, ((k)object12), y3, playlistDeleteHelper1, stringProviderImpl8, q6, t35, b35);
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 102: {
                            return new PlaylistSharedViewModel(((s2)o0.w.get()));
                        }
                        case 103: {
                            object0 = new Xc.o(q0.v1());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 104: {
                            object0 = new Cd.C(o0.u(), new pc.t(new ya.c(new wa.a(((Ba.G)q0.c.k1.get()))), 12));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 105: {
                            x0 = new Cd.S(new pc.t(new ya.c(new wa.a(((Ba.G)q0.c.k1.get()))), 12), q0.x0(), q0.h1(), q0.t1());
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 106: {
                            return new RemoteConnectPopupViewModel(((Ub.s)o0.z.get()), ((s2)o0.w.get()), o0.k());
                        }
                        case 107: {
                            object0 = new Fd.Y(new ub.f(new Aa.j(new Aa.a(((SearchApi)q0.c.l1.get())))), q0.x0(), new A0.c(15, false));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 108: {
                            object0 = new ed.F0(new ub.l(new Aa.j(new Aa.a(((SearchApi)q0.c.l1.get()))), q0.A0()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 109: {
                            Ab.d d0 = q0.B1();
                            Application application0 = a.a.w(o0.a.a);
                            t.e(application0);
                            return new SettingAlarmListViewModel(d0, application0);
                        }
                        case 110: {
                            object0 = new Gd.n(((k)o0.m.get()), o0.m(), ((mb.l)o0.j.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x6F: {
                            object0 = new Gd.G(((k)o0.m.get()), o0.m(), new n(((va.u1)q0.c.I.get()), ((mb.l)q0.c.j.get())), o0.u(), ((k8.a)o0.l.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x70: {
                            object0 = SmartPlaylistViewModel_Factory.newInstance(h0.C(), h0.A(), h0.B(), o0.u(), ((s2)o0.w.get()), o0.k(), o0.i(), ((k)o0.m.get()), q0.y1(), q0.x0(), q0.p1(), q0.o1(), q0.h1(), ((k8.a)o0.l.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x71: {
                            l3 l30 = new l3(((s2)o0.w.get()), new s(q0.c.q(), ((k)q0.c.m.get()), q0.n1()), q0.p1(), q0.h1(), q0.x0(), q0.t1());
                            l30.pvUseCase = q0.m1();
                            l30.screenCaptureUseCase = q0.r1();
                            return l30;
                        }
                        case 0x72: {
                            Ua.h h4 = new Ua.h(q0.d.a());
                            H8.q q7 = q0.M0();
                            Object object13 = o0.m.get();
                            n4 n44 = q0.t1();
                            t3 t36 = q0.p1();
                            b3 b36 = q0.h1();
                            y y4 = q0.y1();
                            Q q8 = q0.x0();
                            CoroutineDispatcher coroutineDispatcher7 = h0.B();
                            Ua.n n0 = q0.C0();
                            StringProviderImpl stringProviderImpl9 = o0.u();
                            x0 = new Hd.y(q0.a, h4, q7, ((k)object13), n44, t36, b36, y4, q8, coroutineDispatcher7, n0, stringProviderImpl9);
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 0x73: {
                            object0 = new O(o0.k(), ((s2)o0.w.get()), ((k)o0.m.get()));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x74: {
                            t.e(o0.a.a);
                            StringProviderImpl stringProviderImpl10 = o0.u();
                            Object object14 = o0.w.get();
                            z z5 = o0.k();
                            Ua.h h5 = q0.u1();
                            H8.q q9 = q0.M0();
                            n4 n45 = q0.t1();
                            t3 t37 = q0.p1();
                            Q q10 = q0.x0();
                            Object object15 = o0.m.get();
                            k10 = new R0(q0.a, o0.a.a, stringProviderImpl10, ((s2)object14), z5, h5, q9, n45, t37, q10, ((k)object15));
                            k10.pvUseCase = q0.m1();
                            k10.screenCaptureUseCase = q0.r1();
                            return k10;
                        }
                        case 0x75: {
                            Object object16 = o0.m.get();
                            Ua.h h6 = q0.u1();
                            H8.q q11 = q0.M0();
                            n4 n46 = q0.t1();
                            Object object17 = o0.F0.get();
                            Object object18 = o0.D0.get();
                            StringProviderImpl stringProviderImpl11 = o0.u();
                            x0 = new n0(q0.a, ((k)object16), h6, q11, n46, ((SystemSettingUtils)object17), ((PreferenceHelper)object18), stringProviderImpl11);
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 0x76: {
                            Object object19 = o0.m.get();
                            e e0 = q0.v1();
                            H8.q q12 = q0.M0();
                            StringProviderImpl stringProviderImpl12 = o0.u();
                            Object object20 = o0.F0.get();
                            Object object21 = o0.D0.get();
                            t.e(o0.a.a);
                            object0 = new Hd.S0(((k)object19), e0, q12, stringProviderImpl12, ((SystemSettingUtils)object20), ((PreferenceHelper)object21), new ColorProviderImpl(o0.a.a));
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x77: {
                            Ba.t t0 = (Ba.t)q0.c.n1.get();
                            q.g(t0, "api");
                            k10 = new Yc.W(new S0(new oa.e(new kb.D(t0, 24)), 10), q0.q1(), q0.x0(), ((k)o0.m.get()), h0.B());
                            k10.pvUseCase = q0.m1();
                            k10.screenCaptureUseCase = q0.r1();
                            return k10;
                        }
                        case 120: {
                            Context context0 = o0.a.a;
                            t.e(context0);
                            q0.getClass();
                            VolatileDatabase volatileDatabase0 = z9.P.a;
                            if(volatileDatabase0 != null) {
                                b3 = volatileDatabase0.c();
                            }
                            kb.D d1 = new kb.D(b3, 25);
                            u u0 = (u)q0.c.o1.get();
                            q.g(u0, "api");
                            x0 = new Zc.t0(context0, new x9.a(new oa.k(d1, new kb.D(u0, 26)), q0.A0()), ((k)o0.m.get()), o0.u(), h0.B());
                            x0.pvUseCase = q0.m1();
                            x0.screenCaptureUseCase = q0.r1();
                            return x0;
                        }
                        case 0x79: {
                            return new VideoViewModel(new VideoPipPvLogManager(q0.m1()), ((s2)o0.w.get()), o0.k());
                        }
                        case 0x7A: {
                            object0 = new Ld.A(q0.B1(), o0.u());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        case 0x7B: {
                            q0.B1();
                            object0 = new Ld.E();  // 初始化器: Landroidx/lifecycle/m0;-><init>()V
                            StateFlowKt.MutableStateFlow(null);
                            StateFlowKt.MutableStateFlow(je.w.a);
                            return object0;
                        }
                        case 0x7C: {
                            object0 = new Ld.J(q0.B1(), q0.B0(), o0.u());
                            object0.pvUseCase = q0.m1();
                            object0.screenCaptureUseCase = q0.r1();
                            return object0;
                        }
                        default: {
                            throw new AssertionError(v);
                        }
                    }
                }
                default: {
                    throw new AssertionError(v);
                }
            }
        }
        return this.a();
    }
}

