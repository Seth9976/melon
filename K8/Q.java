package k8;

import Ab.d;
import Ac.G0;
import Ac.L3;
import Ac.M0;
import Ac.N2;
import Ac.g0;
import Ac.r4;
import Ba.A;
import Ba.H;
import Ba.P;
import Ba.S;
import Ba.c;
import Ba.s;
import Ba.z;
import Dd.g1;
import Ea.e;
import Ic.A0;
import Oc.D;
import Oc.N;
import Oc.x;
import Rc.t0;
import Ua.n;
import Uc.m;
import Uc.w;
import W.p;
import Wc.j;
import ad.q0;
import androidx.lifecycle.c0;
import androidx.media3.session.legacy.V;
import ba.r;
import com.iloen.melon.custom.S0;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel;
import com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel_MembersInjector;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountViewModel;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel;
import com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel;
import com.iloen.melon.player.playlist.music.MusicPlaylistViewModel;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase;
import com.melon.data.main.bottomtab.MainBottomTabPreferenceDataSourceImpl;
import com.melon.ui.b3;
import com.melon.ui.comment.CommentAttachPagerViewModel;
import com.melon.ui.n4;
import com.melon.ui.t3;
import com.melon.utils.image.ImageUtils;
import d5.t;
import d5.v;
import dd.C;
import dd.J;
import dd.K;
import dd.M;
import dd.O;
import dd.Q;
import dd.T;
import dd.W;
import de.h;
import eb.y;
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
import gd.u0;
import gd.y2;
import ge.b;
import hb.f;
import hd.O1;
import hd.m1;
import i.n.i.b.a.s.e.Ga;
import kc.s2;
import kotlinx.coroutines.CoroutineScope;
import mb.k;
import pb.l;
import rd.K1;
import ta.L;
import td.t1;
import tg.U;
import ua.u;
import yc.E;

public final class q extends I {
    public final b A;
    public final b A0;
    public final i B;
    public final b B0;
    public final i C;
    public final b C0;
    public final i D;
    public final b D0;
    public final i E;
    public final b E0;
    public final i F;
    public final b F0;
    public final i G;
    public final b G0;
    public final i H;
    public final b H0;
    public final i I;
    public final b I0;
    public final i J;
    public final b J0;
    public final i K;
    public final b K0;
    public final i L;
    public final b L0;
    public final i M;
    public final b M0;
    public final i N;
    public final b N0;
    public final i O;
    public final b O0;
    public final i P;
    public final i P0;
    public final i Q;
    public final i Q0;
    public final i R;
    public final i R0;
    public final i S;
    public final i S0;
    public final i T;
    public final i T0;
    public final i U;
    public final i U0;
    public final i V;
    public final i V0;
    public final i W;
    public final i W0;
    public final i X;
    public final i X0;
    public final i Y;
    public final i Y0;
    public final i Z;
    public final i Z0;
    public final c0 a;
    public final i a0;
    public final i a1;
    public final h b;
    public final i b0;
    public final i b1;
    public final o c;
    public final i c0;
    public final i c1;
    public final g d;
    public final i d0;
    public final i d1;
    public final i e;
    public final i e0;
    public final i e1;
    public final i f;
    public final i f0;
    public final i f1;
    public final i g;
    public final i g0;
    public final i g1;
    public final i h;
    public final i h0;
    public final i h1;
    public final i i;
    public final i i0;
    public final i i1;
    public final i j;
    public final i j0;
    public final i j1;
    public final i k;
    public final i k0;
    public final i k1;
    public final i l;
    public final i l0;
    public final i l1;
    public final i m;
    public final i m0;
    public final i m1;
    public final i n;
    public final i n0;
    public final i n1;
    public final i o;
    public final i o0;
    public final i o1;
    public final i p;
    public final i p0;
    public final i p1;
    public final i q;
    public final i q0;
    public final i q1;
    public final i r;
    public final i r0;
    public final i r1;
    public final i s;
    public final i s0;
    public final i s1;
    public final i t;
    public final i t0;
    public final i t1;
    public final i u;
    public final i u0;
    public final i u1;
    public final i v;
    public final i v0;
    public final i v1;
    public final i w;
    public final b w0;
    public final i w1;
    public final i x;
    public final b x0;
    public final i x1;
    public final b y;
    public final b y0;
    public final i y1;
    public final b z;
    public final b z0;

    public q(o o0, g g0, c0 c00, h h0) {
        this.c = o0;
        this.d = g0;
        this.a = c00;
        this.b = h0;
        this.e = new i(o0, this, 0, 1);
        this.f = new i(o0, this, 1, 1);
        this.g = new i(o0, this, 2, 1);
        this.h = new i(o0, this, 3, 1);
        this.i = new i(o0, this, 4, 1);
        this.j = new i(o0, this, 5, 1);
        this.k = new i(o0, this, 6, 1);
        this.l = new i(o0, this, 7, 1);
        this.m = new i(o0, this, 8, 1);
        this.n = new i(o0, this, 9, 1);
        this.o = new i(o0, this, 10, 1);
        this.p = new i(o0, this, 11, 1);
        this.q = new i(o0, this, 12, 1);
        this.r = new i(o0, this, 13, 1);
        this.s = new i(o0, this, 14, 1);
        this.t = new i(o0, this, 15, 1);
        this.u = new i(o0, this, 16, 1);
        this.v = new i(o0, this, 17, 1);
        this.w = new i(o0, this, 18, 1);
        this.x = new i(o0, this, 19, 1);
        this.y = a.h(o0, this, 21);
        this.z = a.h(o0, this, 22);
        this.A = a.h(o0, this, 23);
        this.B = new i(o0, this, 20, 1);
        this.C = new i(o0, this, 24, 1);
        this.D = new i(o0, this, 25, 1);
        this.E = new i(o0, this, 26, 1);
        this.F = new i(o0, this, 27, 1);
        this.G = new i(o0, this, 28, 1);
        this.H = new i(o0, this, 29, 1);
        this.I = new i(o0, this, 30, 1);
        this.J = new i(o0, this, 0x1F, 1);
        this.K = new i(o0, this, 0x20, 1);
        this.L = new i(o0, this, 33, 1);
        this.M = new i(o0, this, 34, 1);
        this.N = new i(o0, this, 35, 1);
        this.O = new i(o0, this, 36, 1);
        this.P = new i(o0, this, 37, 1);
        this.Q = new i(o0, this, 38, 1);
        this.R = new i(o0, this, 39, 1);
        this.S = new i(o0, this, 40, 1);
        this.T = new i(o0, this, 41, 1);
        this.U = new i(o0, this, 42, 1);
        this.V = new i(o0, this, 43, 1);
        this.W = new i(o0, this, 44, 1);
        this.X = new i(o0, this, 45, 1);
        this.Y = new i(o0, this, 46, 1);
        this.Z = new i(o0, this, 0x2F, 1);
        this.a0 = new i(o0, this, 0x30, 1);
        this.b0 = new i(o0, this, 49, 1);
        this.c0 = new i(o0, this, 50, 1);
        this.d0 = new i(o0, this, 51, 1);
        this.e0 = new i(o0, this, 52, 1);
        this.f0 = new i(o0, this, 53, 1);
        this.g0 = new i(o0, this, 54, 1);
        this.h0 = new i(o0, this, 55, 1);
        this.i0 = new i(o0, this, 56, 1);
        this.j0 = new i(o0, this, 57, 1);
        this.k0 = new i(o0, this, 58, 1);
        this.l0 = new i(o0, this, 59, 1);
        this.m0 = new i(o0, this, 60, 1);
        this.n0 = new i(o0, this, 61, 1);
        this.o0 = new i(o0, this, 62, 1);
        this.p0 = new i(o0, this, 0x3F, 1);
        this.q0 = new i(o0, this, 0x40, 1);
        this.r0 = new i(o0, this, 65, 1);
        this.s0 = new i(o0, this, 66, 1);
        this.t0 = new i(o0, this, 67, 1);
        this.u0 = new i(o0, this, 68, 1);
        this.v0 = new i(o0, this, 69, 1);
        this.w0 = a.h(o0, this, 72);
        this.x0 = a.h(o0, this, 73);
        this.y0 = a.h(o0, this, 71);
        this.z0 = a.h(o0, this, 74);
        this.A0 = a.h(o0, this, 75);
        this.B0 = a.h(o0, this, 76);
        this.C0 = a.h(o0, this, 77);
        this.D0 = a.h(o0, this, 78);
        this.E0 = a.h(o0, this, 0x4F);
        this.F0 = a.h(o0, this, 80);
        this.G0 = a.h(o0, this, 81);
        this.H0 = a.h(o0, this, 82);
        this.I0 = a.h(o0, this, 83);
        this.J0 = a.h(o0, this, 84);
        this.K0 = a.h(o0, this, 85);
        this.L0 = a.h(o0, this, 86);
        this.M0 = a.h(o0, this, 87);
        this.N0 = a.h(o0, this, 88);
        this.O0 = a.h(o0, this, 89);
        this.P0 = new i(o0, this, 70, 1);
        this.Q0 = new i(o0, this, 90, 1);
        this.R0 = new i(o0, this, 91, 1);
        this.S0 = new i(o0, this, 92, 1);
        this.T0 = new i(o0, this, 93, 1);
        this.U0 = new i(o0, this, 94, 1);
        this.V0 = new i(o0, this, 0x5F, 1);
        this.W0 = new i(o0, this, 0x60, 1);
        this.X0 = new i(o0, this, 97, 1);
        this.Y0 = new i(o0, this, 98, 1);
        this.Z0 = new i(o0, this, 99, 1);
        this.a1 = new i(o0, this, 100, 1);
        this.b1 = new i(o0, this, 101, 1);
        this.c1 = new i(o0, this, 102, 1);
        this.d1 = new i(o0, this, 103, 1);
        this.e1 = new i(o0, this, 104, 1);
        this.f1 = new i(o0, this, 105, 1);
        this.g1 = new i(o0, this, 106, 1);
        this.h1 = new i(o0, this, 107, 1);
        this.i1 = new i(o0, this, 108, 1);
        this.j1 = new i(o0, this, 109, 1);
        this.k1 = new i(o0, this, 110, 1);
        this.l1 = new i(o0, this, 0x6F, 1);
        this.m1 = new i(o0, this, 0x70, 1);
        this.n1 = new i(o0, this, 0x71, 1);
        this.o1 = new i(o0, this, 0x72, 1);
        this.p1 = new i(o0, this, 0x73, 1);
        this.q1 = new i(o0, this, 0x74, 1);
        this.r1 = new i(o0, this, 0x75, 1);
        this.s1 = new i(o0, this, 0x76, 1);
        this.t1 = new i(o0, this, 0x77, 1);
        this.u1 = new i(o0, this, 120, 1);
        this.v1 = new i(o0, this, 0x79, 1);
        this.w1 = new i(o0, this, 0x7A, 1);
        this.x1 = new i(o0, this, 0x7B, 1);
        this.y1 = new i(o0, this, 0x7C, 1);
    }

    public static void A(q q0, Oc.o o0) {
        o0.pvUseCase = q0.m1();
        o0.screenCaptureUseCase = q0.r1();
    }

    public final Ua.h A0() {
        c c0 = (c)this.c.Q0.get();
        kotlin.jvm.internal.q.g(c0, "api");
        Ua.h h0 = new Ua.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = c0;
        return new Ua.h(h0);
    }

    public final zb.b A1() {
        return new zb.b(new Ia.c(new Ia.a(((Da.a)a.j(((U)this.c.c1.get()), "retrofit", Da.a.class, "create(...)")))));
    }

    public static void B(q q0, x x0) {
        x0.pvUseCase = q0.m1();
        x0.screenCaptureUseCase = q0.r1();
    }

    public final I7.c B0() {
        return new I7.c(this.A0(), 17);
    }

    public final d B1() {
        return new d(new I7.c(new I7.c(((S)this.c.S.get())), 8), ((k)this.c.m.get()));
    }

    public static void C(q q0, D d0) {
        d0.pvUseCase = q0.m1();
        d0.screenCaptureUseCase = q0.r1();
    }

    public final n C0() {
        return new n(new Ua.h(new androidx.lifecycle.b(((Ba.h)this.c.W0.get()))));
    }

    public static void D(q q0, N n0) {
        n0.pvUseCase = q0.m1();
        n0.screenCaptureUseCase = q0.r1();
    }

    public final Ua.N D0() {
        return new Ua.N(new r(new ba.a(((Ba.g)this.c.X0.get()))));
    }

    public static void E(q q0, Oc.U u0) {
        u0.pvUseCase = q0.m1();
        u0.screenCaptureUseCase = q0.r1();
    }

    public final l E0() {
        return new l(((s2)this.c.w.get()), 2);
    }

    public static void F(q q0, E e0) {
        e0.pvUseCase = q0.m1();
        e0.screenCaptureUseCase = q0.r1();
    }

    public final Ua.h F0() {
        return new Ua.h(new Ga(new Ga(this.c.h(), 11), 12));
    }

    public static void G(q q0, wc.x x0) {
        x0.pvUseCase = q0.m1();
        x0.screenCaptureUseCase = q0.r1();
    }

    public final Za.b G0() {
        return new Za.b(this.c.r());
    }

    public static void H(q q0, ImageToPlaylistViewModel imageToPlaylistViewModel0) {
        imageToPlaylistViewModel0.pvUseCase = q0.m1();
        imageToPlaylistViewModel0.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        ImageToPlaylistViewModel_MembersInjector.injectImageUtils(imageToPlaylistViewModel0, new ImageUtils(q0.c.a.a));
    }

    public final w H0() {
        w w0 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
        Wc.c c0 = new Wc.c();
        t.e(this.c.a.a);
        c0.a = this.c.a.a;
        c0.b = (CoroutineScope)this.y.get();
        c0.c = (Uc.q)this.z.get();
        c0.d = (m)this.A.get();
        this.c.o();
        w0.a = c0;
        Wc.k k0 = new Wc.k();
        t.e(this.c.a.a);
        k0.a = this.c.a.a;
        k0.b = (CoroutineScope)this.y.get();
        k0.c = (Uc.q)this.z.get();
        k0.d = (m)this.A.get();
        this.c.o();
        w0.b = k0;
        j j0 = new j();
        t.e(this.c.a.a);
        j0.a = this.c.a.a;
        j0.b = (CoroutineScope)this.y.get();
        j0.c = (Uc.q)this.z.get();
        j0.d = (m)this.A.get();
        this.c.o();
        w0.c = j0;
        Wc.h h0 = new Wc.h();
        t.e(this.c.a.a);
        h0.a = this.c.a.a;
        h0.b = (CoroutineScope)this.y.get();
        h0.c = (Uc.q)this.z.get();
        h0.d = (m)this.A.get();
        this.c.o();
        w0.d = h0;
        Wc.l l0 = new Wc.l();
        t.e(this.c.a.a);
        l0.a = this.c.a.a;
        l0.b = (CoroutineScope)this.y.get();
        l0.c = (Uc.q)this.z.get();
        l0.d = (m)this.A.get();
        this.c.o();
        w0.e = l0;
        return w0;
    }

    public static void I(q q0, Qc.w w0) {
        w0.pvUseCase = q0.m1();
        w0.screenCaptureUseCase = q0.r1();
    }

    public final Za.b I0() {
        return new Za.b(this.c.r());
    }

    public static void J(q q0, t0 t00) {
        t00.pvUseCase = q0.m1();
        t00.screenCaptureUseCase = q0.r1();
    }

    public final Ua.h J0() {
        Ba.m m0 = (Ba.m)this.c.a1.get();
        kotlin.jvm.internal.q.g(m0, "service");
        return new Ua.h(new ja.g(new Ga(m0, 17)));
    }

    public static void K(q q0, LoginSimpleAccountViewModel loginSimpleAccountViewModel0) {
        loginSimpleAccountViewModel0.pvUseCase = q0.m1();
        loginSimpleAccountViewModel0.screenCaptureUseCase = q0.r1();
    }

    public final I7.c K0() {
        Ba.n n0 = (Ba.n)this.c.b1.get();
        kotlin.jvm.internal.q.g(n0, "service");
        return new I7.c(new Ua.h(new Ua.h(n0)), 21);
    }

    public static void L(q q0, Dd.I i0) {
        i0.pvUseCase = q0.m1();
        i0.screenCaptureUseCase = q0.r1();
    }

    public final V L0() {
        t.e(this.c.a.a);
        u u0 = this.c.r();
        s2 s20 = (s2)this.c.w.get();
        return new V(this.c.a.a, s20, u0);
    }

    public static void M(q q0, zd.c0 c00) {
        c00.pvUseCase = q0.m1();
        c00.screenCaptureUseCase = q0.r1();
    }

    public final H8.q M0() {
        u u0 = this.c.r();
        S0 s00 = this.d.a();
        y y0 = this.y1();
        P p0 = (P)this.c.T0.get();
        kotlin.jvm.internal.q.g(p0, "api");
        I7.c c0 = new I7.c(new I7.c(p0, 4), 5);
        k k0 = (k)this.c.m.get();
        L l0 = this.c.q();
        pb.t t0 = new pb.t(((s2)this.c.w.get()));
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        H8.q q0 = new H8.q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q0.a = u0;
        q0.b = s00;
        q0.c = y0;
        q0.d = c0;
        q0.e = k0;
        q0.f = l0;
        q0.g = t0;
        return q0;
    }

    public static void N(q q0, G g0) {
        g0.pvUseCase = q0.m1();
        g0.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        g0.e = q0.c.a.a;
    }

    public final gb.c N0() {
        return new gb.c(this.O0());
    }

    public static void O(q q0, b0 b00) {
        b00.pvUseCase = q0.m1();
        b00.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
    }

    public final pa.h O0() {
        Ba.r r0 = (Ba.r)this.c.Z0.get();
        kotlin.jvm.internal.q.g(r0, "api");
        kb.D d0 = new kb.D(r0, 28);
        t.e(this.c.a.a);
        return new pa.h(d0, new MainBottomTabPreferenceDataSourceImpl(this.c.a.a));
    }

    public static void P(q q0, u0 u00) {
        u00.pvUseCase = q0.m1();
        u00.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
    }

    public final f P0() {
        return new f(this.c.b());
    }

    public static void Q(q q0, F0 f00) {
        f00.pvUseCase = q0.m1();
        f00.screenCaptureUseCase = q0.r1();
    }

    public final f Q0() {
        return new f(this.c.b());
    }

    public static void R(q q0, a1 a10) {
        a10.pvUseCase = q0.m1();
        a10.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        a10.j = q0.c.a.a;
    }

    public final ea.b R0() {
        v v0 = this.c.b();
        k k0 = (k)this.c.m.get();
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        ea.b b0 = new ea.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.a = v0;
        b0.b = k0;
        return b0;
    }

    public static void S(q q0, r1 r10) {
        r10.pvUseCase = q0.m1();
        r10.screenCaptureUseCase = q0.r1();
    }

    public final f S0() {
        return new f(this.c.b());
    }

    public static void T(q q0, V1 v10) {
        v10.pvUseCase = q0.m1();
        v10.screenCaptureUseCase = q0.r1();
    }

    public final S0 T0() {
        Ba.d d0 = (Ba.d)this.c.O.get();
        kotlin.jvm.internal.q.g(d0, "api");
        return new S0(new Ua.h(new Ua.h(d0)), 21);
    }

    public static void U(q q0, n2 n20) {
        n20.pvUseCase = q0.m1();
        n20.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        n20.e = q0.c.a.a;
    }

    public final f U0() {
        return new f(this.c.b());
    }

    public static void V(q q0, y2 y20) {
        y20.pvUseCase = q0.m1();
        y20.screenCaptureUseCase = q0.r1();
    }

    public final ea.c V0() {
        return new ea.c(this.c.b(), ((k)this.c.m.get()));
    }

    public static void W(q q0, e3 e30) {
        e30.pvUseCase = q0.m1();
        e30.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        e30.g = q0.c.a.a;
    }

    public final ea.d W0() {
        return new ea.d(this.c.b(), ((k)this.c.m.get()));
    }

    public static void X(q q0, E3 e30) {
        e30.pvUseCase = q0.m1();
        e30.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        e30.h = q0.c.a.a;
    }

    public final f X0() {
        return new f(this.c.b());
    }

    public static void Y(q q0, f4 f40) {
        f40.pvUseCase = q0.m1();
        f40.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        f40.j = q0.c.a.a;
    }

    public final f Y0() {
        return new f(this.c.b());
    }

    public static void Z(q q0, i4 i40) {
        i40.pvUseCase = q0.m1();
        i40.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        i40.e = q0.c.a.a;
    }

    public final x9.a Z0() {
        v v0 = this.c.b();
        k k0 = (k)this.c.m.get();
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        x9.a a0 = new x9.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = v0;
        a0.b = k0;
        return a0;
    }

    public static c0 a(q q0) {
        return q0.a;
    }

    public static void a0(q q0, B4 b40) {
        b40.pvUseCase = q0.m1();
        b40.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        b40.i = q0.c.a.a;
    }

    public final x9.b a1() {
        v v0 = this.c.b();
        k k0 = (k)this.c.m.get();
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        x9.b b0 = new x9.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.a = v0;
        b0.b = k0;
        return b0;
    }

    public static void b(q q0, wd.t t0) {
        t0.pvUseCase = q0.m1();
        t0.screenCaptureUseCase = q0.r1();
    }

    public static void b0(q q0, d5 d50) {
        d50.pvUseCase = q0.m1();
        d50.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        d50.j = q0.c.a.a;
    }

    public final x9.c b1() {
        return new x9.c(this.c.b(), ((k)this.c.m.get()));
    }

    public static void c(q q0, A0 a00) {
        a00.pvUseCase = q0.m1();
        a00.screenCaptureUseCase = q0.r1();
    }

    public static void c0(q q0, p5 p50) {
        p50.pvUseCase = q0.m1();
        p50.screenCaptureUseCase = q0.r1();
    }

    public final f c1() {
        return new f(this.c.b());
    }

    public static void d(q q0, xd.r r0) {
        r0.pvUseCase = q0.m1();
        r0.screenCaptureUseCase = q0.r1();
    }

    public static void d0(q q0, C5 c50) {
        c50.pvUseCase = q0.m1();
        c50.screenCaptureUseCase = q0.r1();
    }

    public final f d1() {
        return new f(this.c.b());
    }

    public static void e(q q0, g0 g00) {
        g00.pvUseCase = q0.m1();
        g00.screenCaptureUseCase = q0.r1();
    }

    public static void e0(q q0, P5 p50) {
        p50.pvUseCase = q0.m1();
        p50.screenCaptureUseCase = q0.r1();
    }

    public final E9.g e1() {
        return new E9.g(this.c.b(), this.n1());
    }

    public static void f(q q0, CommentAttachPagerViewModel commentAttachPagerViewModel0) {
        commentAttachPagerViewModel0.pvUseCase = q0.m1();
        commentAttachPagerViewModel0.screenCaptureUseCase = q0.r1();
    }

    public static void f0(q q0, n6 n60) {
        n60.pvUseCase = q0.m1();
        n60.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        n60.i = q0.c.a.a;
    }

    public final p f1() {
        v v0 = this.c.b();
        k k0 = (k)this.c.m.get();
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.a = v0;
        p0.b = k0;
        return p0;
    }

    public static void g(q q0, G0 g00) {
        g00.pvUseCase = q0.m1();
        g00.screenCaptureUseCase = q0.r1();
    }

    public static void g0(q q0, C6 c60) {
        c60.pvUseCase = q0.m1();
        c60.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        c60.h = q0.c.a.a;
    }

    public final qb.I g1() {
        k8.a a0 = (k8.a)this.c.l.get();
        e e0 = this.c.t();
        Ba.x x0 = (Ba.x)this.c.C.get();
        kotlin.jvm.internal.q.g(x0, "api");
        return new qb.I(a0, e0, new qa.b(new pc.t(x0, 2)), new V(this.c.t(), this.c.a(), ((k)this.c.m.get())), this.d.a(), this.c.r(), this.c.q(), ((k)this.c.m.get()), this.c.k(), ((s2)this.c.w.get()));
    }

    public static void h(q q0, M0 m00) {
        m00.pvUseCase = q0.m1();
        m00.screenCaptureUseCase = q0.r1();
    }

    public static void h0(q q0, O7 o70) {
        o70.pvUseCase = q0.m1();
        o70.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
    }

    public final b3 h1() {
        return new b3(this.g1(), this.c.k(), this.c.u());
    }

    public static void i(q q0, N2 n20) {
        n20.pvUseCase = q0.m1();
        n20.screenCaptureUseCase = q0.r1();
    }

    public static void i0(q q0, D8 d80) {
        d80.pvUseCase = q0.m1();
        d80.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        d80.e = q0.c.a.a;
    }

    public final x9.b i1() {
        ra.h h0 = this.j1();
        Ba.b b0 = (Ba.b)this.c.Q.get();
        kotlin.jvm.internal.q.g(b0, "api");
        return new x9.b(h0, new V9.c(new Ua.h(b0)));
    }

    public static void j(q q0, L3 l30) {
        l30.pvUseCase = q0.m1();
        l30.screenCaptureUseCase = q0.r1();
    }

    public static void j0(q q0, g1 g10) {
        g10.pvUseCase = q0.m1();
        g10.screenCaptureUseCase = q0.r1();
    }

    public final ra.h j1() {
        z z0 = (z)this.c.d1.get();
        kotlin.jvm.internal.q.g(z0, "api");
        return new ra.h(new ra.c(z0), new d5.l(14));
    }

    public static void k(q q0, r4 r40) {
        r40.pvUseCase = q0.m1();
        r40.screenCaptureUseCase = q0.r1();
    }

    public static void k0(q q0, dd.E e0) {
        t.e(q0.c.a.a);
        e0.getClass();
        e0.a = (ad.p)q0.w0.get();
        e0.b = (CoroutineScope)q0.y.get();
        e0.c = (ad.n)q0.x0.get();
        e0.d = q0.q1();
    }

    public final Ga k1() {
        MelonDatabase melonDatabase0 = (MelonDatabase)this.c.B.get();
        kotlin.jvm.internal.q.g(melonDatabase0, "db");
        ea.c c0 = melonDatabase0.d();
        t.e(c0);
        pc.t t0 = new pc.t(c0, 10);
        A a0 = (A)this.c.f1.get();
        kotlin.jvm.internal.q.g(a0, "api");
        return new Ga(new sa.c(t0, new pc.t(a0, 11)), 18);
    }

    public static void l(q q0, wc.w w0) {
        w0.pvUseCase = q0.m1();
        w0.screenCaptureUseCase = q0.r1();
    }

    public static void l0(q q0, MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        mixUpPlaylistComposeViewModel0.pvUseCase = q0.m1();
        mixUpPlaylistComposeViewModel0.screenCaptureUseCase = q0.r1();
    }

    public final ad.E l1() {
        ad.E e0 = new ad.E();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.a = (dd.P)this.y0.get();
        K k0 = new K();
        t.e(this.c.a.a);
        k0.a = (ad.p)this.w0.get();
        k0.b = (CoroutineScope)this.y.get();
        k0.c = (ad.n)this.x0.get();
        k0.d = this.q1();
        e0.b = k0;
        e0.c = (dd.d)this.z0.get();
        e0.d = (J)this.A0.get();
        dd.a a0 = new dd.a();
        t.e(this.c.a.a);
        a0.a = (ad.p)this.w0.get();
        a0.b = (CoroutineScope)this.y.get();
        a0.c = (ad.n)this.x0.get();
        a0.d = this.q1();
        e0.e = a0;
        e0.f = (Q)this.B0.get();
        e0.g = (dd.E)this.C0.get();
        O o0 = new O();
        t.e(this.c.a.a);
        o0.a = (ad.p)this.w0.get();
        o0.b = (CoroutineScope)this.y.get();
        o0.c = (ad.n)this.x0.get();
        o0.d = this.q1();
        e0.h = o0;
        e0.i = (M)this.D0.get();
        e0.j = (dd.c)this.E0.get();
        e0.k = (dd.g)this.F0.get();
        e0.l = (dd.p)this.G0.get();
        dd.n n0 = new dd.n();  // 初始化器: Ldd/H;-><init>()V
        n0.g = "";
        t.e(this.c.a.a);
        n0.a = (ad.p)this.w0.get();
        n0.b = (CoroutineScope)this.y.get();
        n0.c = (ad.n)this.x0.get();
        n0.d = this.q1();
        e0.m = n0;
        dd.k k1 = new dd.k();  // 初始化器: Ldd/H;-><init>()V
        k1.g = "";
        t.e(this.c.a.a);
        k1.a = (ad.p)this.w0.get();
        k1.b = (CoroutineScope)this.y.get();
        k1.c = (ad.n)this.x0.get();
        k1.d = this.q1();
        e0.n = k1;
        e0.o = (dd.i)this.H0.get();
        e0.p = (dd.r)this.I0.get();
        e0.q = (dd.y)this.J0.get();
        e0.r = (dd.t)this.K0.get();
        e0.s = (dd.w)this.L0.get();
        e0.t = (dd.V)this.M0.get();
        e0.u = (C)this.N0.get();
        T t0 = new T();  // 初始化器: Ldd/H;-><init>()V
        t.e(this.c.a.a);
        t0.a = (ad.p)this.w0.get();
        t0.b = (CoroutineScope)this.y.get();
        t0.c = (ad.n)this.x0.get();
        t0.d = this.q1();
        e0.v = t0;
        W w0 = new W();
        t.e(this.c.a.a);
        w0.a = (ad.p)this.w0.get();
        w0.b = (CoroutineScope)this.y.get();
        w0.c = (ad.n)this.x0.get();
        w0.d = this.q1();
        e0.w = w0;
        e0.x = (dd.A)this.O0.get();
        return e0;
    }

    public static void m(q q0, Ad.J j0) {
        j0.pvUseCase = q0.m1();
        j0.screenCaptureUseCase = q0.r1();
    }

    public static void m0(q q0, m1 m10) {
        m10.pvUseCase = q0.m1();
        m10.screenCaptureUseCase = q0.r1();
    }

    public final eb.n m1() {
        return new eb.n(new eb.f(new wa.a(((H)this.c.J0.get()))), new eb.c(((eb.a)this.c.K0.get()), ((eb.d)this.c.L0.get()), ((eb.b)this.c.M0.get())), this.n1());
    }

    public static void n(q q0, Fc.p p0) {
        p0.pvUseCase = q0.m1();
        p0.screenCaptureUseCase = q0.r1();
    }

    public static void n0(q q0, O1 o10) {
        o10.pvUseCase = q0.m1();
        o10.screenCaptureUseCase = q0.r1();
        t.e(q0.c.a.a);
        o10.d = q0.c.a.a;
    }

    public final d5.c n1() {
        Ba.p p0 = (Ba.p)this.c.O0.get();
        kotlin.jvm.internal.q.g(p0, "api");
        return new d5.c(new na.c(new kb.D(p0, 18)));
    }

    public static void o(q q0, Fc.D d0) {
        d0.pvUseCase = q0.m1();
        d0.screenCaptureUseCase = q0.r1();
    }

    public static void o0(q q0, t1 t10) {
        t10.pvUseCase = q0.m1();
        t10.screenCaptureUseCase = q0.r1();
    }

    public final PlaylistDeleteHelper o1() {
        return new PlaylistDeleteHelper(((s2)this.c.w.get()), this.c.k(), this.c.u());
    }

    public static void p(q q0, dd.c c0) {
        t.e(q0.c.a.a);
        c0.getClass();
        c0.a = (ad.p)q0.w0.get();
        c0.b = (CoroutineScope)q0.y.get();
        c0.c = (ad.n)q0.x0.get();
        c0.d = q0.q1();
    }

    public static void p0(q q0, MusicPlaylistViewModel musicPlaylistViewModel0) {
        musicPlaylistViewModel0.pvUseCase = q0.m1();
        musicPlaylistViewModel0.screenCaptureUseCase = q0.r1();
    }

    public final t3 p1() {
        return new t3(new ea.a(this.c.r()));
    }

    public static void q(q q0, K1 k10) {
        k10.pvUseCase = q0.m1();
        k10.screenCaptureUseCase = q0.r1();
    }

    public static void q0(q q0, id.w w0) {
        w0.pvUseCase = q0.m1();
        w0.screenCaptureUseCase = q0.r1();
    }

    public final Za.b q1() {
        return new Za.b(this.c.r());
    }

    public static void r(q q0, Bd.P p0) {
        p0.pvUseCase = q0.m1();
        p0.screenCaptureUseCase = q0.r1();
    }

    public static void r0(q q0, id.A a0) {
        a0.pvUseCase = q0.m1();
        a0.screenCaptureUseCase = q0.r1();
    }

    public final eb.u r1() {
        return new eb.u(this.c.u());
    }

    public static void s(q q0, dd.d d0) {
        t.e(q0.c.a.a);
        d0.getClass();
        d0.a = (ad.p)q0.w0.get();
        d0.b = (CoroutineScope)q0.y.get();
        d0.c = (ad.n)q0.x0.get();
        d0.d = q0.q1();
    }

    public static void s0(q q0, q0 q00) {
        q00.pvUseCase = q0.m1();
        q00.screenCaptureUseCase = q0.r1();
    }

    public final ib.m s1() {
        return new ib.m(new ib.f(this.j1()), this.c.u());
    }

    public static void t(q q0, Lc.t t0) {
        t0.pvUseCase = q0.m1();
        t0.screenCaptureUseCase = q0.r1();
    }

    public static void t0(q q0, J j0) {
        t.e(q0.c.a.a);
        j0.getClass();
        j0.a = (ad.p)q0.w0.get();
        j0.b = (CoroutineScope)q0.y.get();
        j0.c = (ad.n)q0.x0.get();
        j0.d = q0.q1();
    }

    public final n4 t1() {
        return new n4(new vb.o(this.c.r(), this.c.a(), this.c.q(), new V(this.c.t(), this.c.a(), ((k)this.c.m.get()))), ((s2)this.c.w.get()), this.c.u());
    }

    public static void u(q q0, DrawerFragmentViewModel drawerFragmentViewModel0) {
        drawerFragmentViewModel0.pvUseCase = q0.m1();
        drawerFragmentViewModel0.screenCaptureUseCase = q0.r1();
    }

    public static void u0(q q0, M m0) {
        t.e(q0.c.a.a);
        m0.getClass();
        m0.a = (ad.p)q0.w0.get();
        m0.b = (CoroutineScope)q0.y.get();
        m0.c = (ad.n)q0.x0.get();
        m0.d = q0.q1();
    }

    public final Ua.h u1() {
        Ca.c c0 = (Ca.c)this.d.a.m1.get();
        Ba.d d0 = (Ba.d)this.d.a.O.get();
        kotlin.jvm.internal.q.g(c0, "programService");
        kotlin.jvm.internal.q.g(d0, "castService");
        E9.g g0 = new E9.g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.a = c0;
        g0.b = d0;
        return new Ua.h(g0);
    }

    public static void v(q q0, DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        drawerSongFragmentViewModel0.pvUseCase = q0.m1();
        drawerSongFragmentViewModel0.screenCaptureUseCase = q0.r1();
    }

    public static void v0(q q0, dd.P p0) {
        t.e(q0.c.a.a);
        p0.getClass();
        p0.a = (ad.p)q0.w0.get();
        p0.b = (CoroutineScope)q0.y.get();
        p0.c = (ad.n)q0.x0.get();
        p0.d = q0.q1();
    }

    public final d5.e v1() {
        Ba.K k0 = (Ba.K)this.c.j1.get();
        kotlin.jvm.internal.q.g(k0, "api");
        A0.c c0 = new A0.c(new A0.c(k0, 12), 13);
        Ba.d d0 = (Ba.d)this.c.O.get();
        kotlin.jvm.internal.q.g(d0, "api");
        return new d5.e(15, c0, new Ua.h(new Ua.h(d0)));
    }

    public static void w(q q0, U8.w w0) {
        w0.pvUseCase = q0.m1();
        w0.screenCaptureUseCase = q0.r1();
    }

    public static void w0(q q0, Q q1) {
        t.e(q0.c.a.a);
        q1.getClass();
        q1.a = (ad.p)q0.w0.get();
        q1.b = (CoroutineScope)q0.y.get();
        q1.c = (ad.n)q0.x0.get();
        q1.d = q0.q1();
    }

    public final ea.d w1() {
        s s0 = (s)this.c.Y0.get();
        kotlin.jvm.internal.q.g(s0, "api");
        return new ea.d(new oa.c(new kb.D(s0, 23)), this.O0());
    }

    public static void x(q q0, dd.g g0) {
        t.e(q0.c.a.a);
        g0.getClass();
        g0.a = (ad.p)q0.w0.get();
        g0.b = (CoroutineScope)q0.y.get();
        g0.c = (ad.n)q0.x0.get();
        g0.d = q0.q1();
    }

    public final com.melon.ui.Q x0() {
        k8.a a0 = (k8.a)this.c.l.get();
        Ba.N n0 = (Ba.N)this.c.U0.get();
        kotlin.jvm.internal.q.g(n0, "api");
        return new com.melon.ui.Q(a0, new w7.d(new z6.f(new A0.c(n0, 25))), ((k)this.c.m.get()), this.c.k(), ((s2)this.c.w.get()), ((Ub.u)this.c.U.get()), ((Ub.s)this.c.z.get()), this.c.o(), this.c.u());
    }

    public final S0 x1() {
        Ba.v v0 = (Ba.v)this.c.V.get();
        kotlin.jvm.internal.q.g(v0, "api");
        return new S0(new oa.x(new oa.l(v0)), 11);
    }

    public static void y(q q0, Uc.Q q1) {
        q1.pvUseCase = q0.m1();
        q1.screenCaptureUseCase = q0.r1();
    }

    public final d5.i y0() {
        u u0 = this.c.r();
        v v0 = this.c.b();
        k k0 = (k)this.c.m.get();
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        d5.i i0 = new d5.i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.a = u0;
        i0.b = v0;
        i0.c = k0;
        LogU logU0 = new LogU("AddToPlaylistUseCase");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        i0.d = logU0;
        return i0;
    }

    public final y y1() {
        return new y(new eb.w(new kb.D(((Ba.O)this.c.R0.get()))));
    }

    public static void z(q q0, Oc.k k0) {
        k0.pvUseCase = q0.m1();
        k0.screenCaptureUseCase = q0.r1();
    }

    public final x9.c z0() {
        Ba.b b0 = (Ba.b)this.c.Q.get();
        kotlin.jvm.internal.q.g(b0, "api");
        return new x9.c(13, new V9.c(new Ua.h(b0)), this.M0());
    }

    public final l z1() {
        return new l(((s2)this.c.w.get()), 1);
    }
}

