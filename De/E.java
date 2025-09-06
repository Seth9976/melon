package de;

import E9.w;
import I6.u0;
import S2.c;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import com.google.firebase.b;
import ea.a;
import ee.d;
import ee.j;
import javax.inject.Provider;
import k8.g;
import k8.o;
import k8.q;
import we.k;

public final class e implements o0 {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.lifecycle.o0
    public final m0 create(Class class0, c c0) {
        m0 m00;
        Object object0 = this.b;
        if(this.a != 0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.a = c0;
            return new d(new g(((o)(((ee.c)b.B(((AppCompatActivity)object0), ee.c.class)))).b), j0);
        }
        h h0 = new h();
        c0 c00 = f0.b(c0);
        q q0 = new q(((o)((a)object0).a), ((g)((a)object0).b), c00, h0);
        q q1 = (q)(((f)w.s(q0, f.class)));
        q1.getClass();
        I6.w.c(103, "expectedSize");
        B7.b b0 = new B7.b(103);
        b0.v("wd.t", q1.e);
        b0.v("Ic.A0", q1.f);
        b0.v("xd.r", q1.g);
        b0.v("Ac.g0", q1.h);
        b0.v("com.melon.ui.comment.CommentAttachPagerViewModel", q1.i);
        b0.v("Ac.G0", q1.j);
        b0.v("Ac.M0", q1.k);
        b0.v("Ac.N2", q1.l);
        b0.v("Ac.L3", q1.m);
        b0.v("Ac.r4", q1.n);
        b0.v("wc.w", q1.o);
        b0.v("Ad.J", q1.p);
        b0.v("Fc.p", q1.q);
        b0.v("Fc.D", q1.r);
        b0.v("rd.K1", q1.s);
        b0.v("Bd.P", q1.t);
        b0.v("Lc.t", q1.u);
        b0.v("com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel", q1.v);
        b0.v("com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel", q1.w);
        b0.v("U8.w", q1.x);
        b0.v("Uc.Q", q1.B);
        b0.v("Oc.k", q1.C);
        b0.v("Oc.o", q1.D);
        b0.v("Oc.x", q1.E);
        b0.v("Oc.D", q1.F);
        b0.v("Oc.N", q1.G);
        b0.v("Oc.U", q1.H);
        b0.v("yc.E", q1.I);
        b0.v("wc.x", q1.J);
        b0.v("com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel", q1.K);
        b0.v("com.iloen.melon.player.video.LiveViewModel", q1.L);
        b0.v("Qc.w", q1.M);
        b0.v("Rc.t0", q1.N);
        b0.v("com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel", q1.O);
        b0.v("Tc.g", q1.P);
        b0.v("Dd.I", q1.Q);
        b0.v("zd.c0", q1.R);
        b0.v("gd.G", q1.S);
        b0.v("gd.b0", q1.T);
        b0.v("gd.u0", q1.U);
        b0.v("gd.F0", q1.V);
        b0.v("gd.a1", q1.W);
        b0.v("gd.r1", q1.X);
        b0.v("gd.V1", q1.Y);
        b0.v("gd.n2", q1.Z);
        b0.v("gd.y2", q1.a0);
        b0.v("gd.e3", q1.b0);
        b0.v("gd.E3", q1.c0);
        b0.v("gd.f4", q1.d0);
        b0.v("gd.i4", q1.e0);
        b0.v("gd.B4", q1.f0);
        b0.v("gd.d5", q1.g0);
        b0.v("gd.p5", q1.h0);
        b0.v("gd.C5", q1.i0);
        b0.v("gd.P5", q1.j0);
        b0.v("gd.n6", q1.k0);
        b0.v("gd.C6", q1.l0);
        b0.v("gd.O7", q1.m0);
        b0.v("gd.D8", q1.n0);
        b0.v("Dd.g1", q1.o0);
        b0.v("com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel", q1.p0);
        b0.v("hd.m1", q1.q0);
        b0.v("hd.O1", q1.r0);
        b0.v("td.t1", q1.s0);
        b0.v("com.iloen.melon.player.playlist.music.MusicPlaylistViewModel", q1.t0);
        b0.v("id.w", q1.u0);
        b0.v("id.A", q1.v0);
        b0.v("ad.q0", q1.P0);
        b0.v("jd.M0", q1.Q0);
        b0.v("jd.u1", q1.R0);
        b0.v("jd.Y1", q1.S0);
        b0.v("jd.w2", q1.T0);
        b0.v("ld.c", q1.U0);
        b0.v("ld.x", q1.V0);
        b0.v("Mb.w", q1.W0);
        b0.v("Dd.K1", q1.X0);
        b0.v("Kc.Y", q1.Y0);
        b0.v("Kc.k0", q1.Z0);
        b0.v("com.iloen.melon.player.playlist.PlaylistMainViewModel", q1.a1);
        b0.v("com.iloen.melon.player.playlist.search.PlaylistSearchViewModel", q1.b1);
        b0.v("com.iloen.melon.player.playlist.PlaylistSharedViewModel", q1.c1);
        b0.v("Xc.o", q1.d1);
        b0.v("Cd.C", q1.e1);
        b0.v("Cd.S", q1.f1);
        b0.v("com.iloen.melon.popup.RemoteConnectPopupViewModel", q1.g1);
        b0.v("Fd.Y", q1.h1);
        b0.v("ed.F0", q1.i1);
        b0.v("com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel", q1.j1);
        b0.v("Gd.n", q1.k1);
        b0.v("Gd.G", q1.l1);
        b0.v("com.iloen.melon.player.playlist.music.SmartPlaylistViewModel", q1.m1);
        b0.v("jd.l3", q1.n1);
        b0.v("Hd.y", q1.o1);
        b0.v("ud.O", q1.p1);
        b0.v("ud.R0", q1.q1);
        b0.v("Hd.n0", q1.r1);
        b0.v("Hd.S0", q1.s1);
        b0.v("Yc.W", q1.t1);
        b0.v("Zc.t0", q1.u1);
        b0.v("com.iloen.melon.player.video.VideoViewModel", q1.v1);
        b0.v("Ld.A", q1.w1);
        b0.v("Ld.E", q1.x1);
        b0.v("Ld.J", q1.y1);
        Provider provider0 = (Provider)((u0)b0.g()).get(class0.getName());
        k k0 = (k)c0.a(de.g.d);
        ((f)w.s(q0, f.class)).getClass();
        Object object1 = u0.g.get(class0);
        if(object1 == null) {
            if(k0 != null) {
                throw new IllegalStateException("Found creation callback but class " + class0.getName() + " does not have an assisted factory specified in @HiltViewModel.");
            }
            if(provider0 == null) {
                throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + class0.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
            }
            m00 = (m0)provider0.get();
        }
        else {
            if(provider0 != null) {
                throw new AssertionError("Found the @HiltViewModel-annotated class " + class0.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
            }
            if(k0 == null) {
                throw new IllegalStateException("Found @HiltViewModel-annotated class " + class0.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
            }
            m00 = (m0)k0.invoke(object1);
        }
        m00.addCloseable(new de.d(h0));
        return m00;
    }
}

