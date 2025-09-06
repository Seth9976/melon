package k8;

import Ba.B;
import Ba.C;
import Ba.F;
import Ba.J;
import Ba.L;
import Ba.y;
import Ma.a;
import Ma.b;
import Ma.c;
import Ma.d;
import Ma.e;
import Ma.f;
import Ma.g;
import Ma.i;
import Ma.j;
import Ma.l;
import Ma.m;
import Ma.n;
import Ma.p;
import Ua.h;
import Ub.s;
import Vb.u0;
import com.iloen.melon.custom.S0;
import com.iloen.melon.playback.playlist.sol.PlaylistSolMetaRepository;
import com.iloen.melon.playback.playlist.sol.PlaylistSolMetaRepositoryEntryPoint;
import com.melon.data.database.MelonDatabase;
import com.melon.data.musicwave.MusicWaveLocalDataSourceImpl;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.utils.system.DeviceData;
import d5.t;
import d5.v;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import ee.k;
import kc.s2;
import kotlin.jvm.internal.q;
import ob.z;
import qd.W;
import tg.U;
import ua.u;
import va.u1;
import y8.w;

public final class o implements a, b, c, d, e, f, g, i, j, l, m, n, Ma.o, p, Rb.b, be.a, PlaylistSolMetaRepositoryEntryPoint, db.b, ee.c, k, fe.a, E, mc.a {
    public final ge.b A;
    public final ge.b A0;
    public final ge.b B;
    public final ge.b B0;
    public final ge.b C;
    public final ge.b C0;
    public final ge.b D;
    public final ge.b D0;
    public final ge.b E;
    public final ge.b E0;
    public final ge.b F;
    public final ge.b F0;
    public final ge.b G;
    public final ge.b G0;
    public final ge.b H;
    public final ge.b H0;
    public final ge.b I;
    public final ge.b I0;
    public final ge.b J;
    public final ge.b J0;
    public final ge.b K;
    public final ge.b K0;
    public final ge.b L;
    public final ge.b L0;
    public final ge.b M;
    public final ge.b M0;
    public final ge.b N;
    public final ge.b N0;
    public final ge.b O;
    public final ge.b O0;
    public final ge.b P;
    public final ge.b P0;
    public final ge.b Q;
    public final ge.b Q0;
    public final ge.b R;
    public final ge.b R0;
    public final ge.b S;
    public final ge.b S0;
    public final ge.b T;
    public final ge.b T0;
    public final ge.b U;
    public final ge.b U0;
    public final ge.b V;
    public final ge.b V0;
    public final ge.b W;
    public final ge.b W0;
    public final ge.b X;
    public final ge.b X0;
    public final ge.b Y;
    public final ge.b Y0;
    public final ge.b Z;
    public final ge.b Z0;
    public final ApplicationContextModule a;
    public final ge.b a0;
    public final ge.b a1;
    public final o b;
    public final ge.b b0;
    public final ge.b b1;
    public final ge.b c;
    public final ge.b c0;
    public final ge.b c1;
    public final ge.b d;
    public final ge.b d0;
    public final ge.b d1;
    public final ge.b e;
    public final ge.b e0;
    public final ge.b e1;
    public final ge.b f;
    public final ge.b f0;
    public final ge.b f1;
    public final ge.b g;
    public final ge.b g0;
    public final ge.b g1;
    public final ge.b h;
    public final ge.b h0;
    public final ge.b h1;
    public final ge.b i;
    public final ge.b i0;
    public final ge.b i1;
    public final ge.b j;
    public final ge.b j0;
    public final ge.b j1;
    public final ge.b k;
    public final ge.b k0;
    public final ge.b k1;
    public final ge.b l;
    public final ge.b l0;
    public final ge.b l1;
    public final ge.b m;
    public final ge.b m0;
    public final ge.b m1;
    public final ge.b n;
    public final ge.b n0;
    public final ge.b n1;
    public final ge.b o;
    public final ge.b o0;
    public final ge.b o1;
    public final ge.b p;
    public final ge.b p0;
    public final ge.b p1;
    public final ge.b q;
    public final ge.b q0;
    public final ge.b q1;
    public final ge.b r;
    public final ge.b r0;
    public final ge.b r1;
    public final ge.b s;
    public final ge.b s0;
    public final ge.b s1;
    public final ge.b t;
    public final ge.b t0;
    public final ge.b t1;
    public final ge.b u;
    public final ge.b u0;
    public final ge.b u1;
    public final ge.b v;
    public final ge.b v0;
    public final ge.b w;
    public final ge.b w0;
    public final ge.b x;
    public final ge.b x0;
    public final ge.b y;
    public final ge.b y0;
    public final ge.b z;
    public final ge.b z0;

    public o(ApplicationContextModule applicationContextModule0) {
        this.b = this;
        this.a = applicationContextModule0;
        this.c = com.iloen.melon.utils.a.g(this, 7);
        this.d = com.iloen.melon.utils.a.g(this, 6);
        this.e = com.iloen.melon.utils.a.g(this, 9);
        this.f = com.iloen.melon.utils.a.g(this, 8);
        this.g = com.iloen.melon.utils.a.g(this, 5);
        this.h = com.iloen.melon.utils.a.g(this, 11);
        this.i = com.iloen.melon.utils.a.g(this, 10);
        this.j = com.iloen.melon.utils.a.g(this, 4);
        this.k = com.iloen.melon.utils.a.g(this, 12);
        this.l = ge.a.a(new k8.n(this, 13));
        this.m = com.iloen.melon.utils.a.g(this, 3);
        this.n = com.iloen.melon.utils.a.g(this, 14);
        this.o = com.iloen.melon.utils.a.g(this, 2);
        this.p = com.iloen.melon.utils.a.g(this, 15);
        this.q = com.iloen.melon.utils.a.g(this, 17);
        this.r = ge.a.a(new k8.n(this, 16));
        this.s = com.iloen.melon.utils.a.g(this, 18);
        this.t = com.iloen.melon.utils.a.g(this, 19);
        this.u = com.iloen.melon.utils.a.g(this, 20);
        this.v = com.iloen.melon.utils.a.g(this, 1);
        this.w = com.iloen.melon.utils.a.g(this, 0);
        this.x = com.iloen.melon.utils.a.g(this, 22);
        this.y = com.iloen.melon.utils.a.g(this, 23);
        this.z = com.iloen.melon.utils.a.g(this, 21);
        this.A = com.iloen.melon.utils.a.g(this, 24);
        this.B = com.iloen.melon.utils.a.g(this, 25);
        this.C = com.iloen.melon.utils.a.g(this, 26);
        this.D = com.iloen.melon.utils.a.g(this, 27);
        this.E = com.iloen.melon.utils.a.g(this, 28);
        this.F = com.iloen.melon.utils.a.g(this, 30);
        this.G = com.iloen.melon.utils.a.g(this, 29);
        this.H = com.iloen.melon.utils.a.g(this, 0x20);
        this.I = com.iloen.melon.utils.a.g(this, 0x1F);
        this.J = com.iloen.melon.utils.a.g(this, 33);
        this.K = com.iloen.melon.utils.a.g(this, 34);
        this.L = com.iloen.melon.utils.a.g(this, 35);
        this.M = com.iloen.melon.utils.a.g(this, 36);
        this.N = com.iloen.melon.utils.a.g(this, 37);
        this.O = com.iloen.melon.utils.a.g(this, 38);
        this.P = com.iloen.melon.utils.a.g(this, 39);
        this.Q = com.iloen.melon.utils.a.g(this, 40);
        this.R = com.iloen.melon.utils.a.g(this, 41);
        this.S = com.iloen.melon.utils.a.g(this, 42);
        this.T = com.iloen.melon.utils.a.g(this, 43);
        this.U = com.iloen.melon.utils.a.g(this, 44);
        this.V = com.iloen.melon.utils.a.g(this, 46);
        this.W = ge.a.a(new k8.n(this, 45));
        this.X = com.iloen.melon.utils.a.g(this, 51);
        this.Y = com.iloen.melon.utils.a.g(this, 50);
        this.Z = com.iloen.melon.utils.a.g(this, 49);
        this.a0 = com.iloen.melon.utils.a.g(this, 0x30);
        this.b0 = com.iloen.melon.utils.a.g(this, 54);
        this.c0 = com.iloen.melon.utils.a.g(this, 53);
        this.d0 = com.iloen.melon.utils.a.g(this, 55);
        this.e0 = com.iloen.melon.utils.a.g(this, 52);
        this.f0 = ge.c.a(new k8.n(this, 0x2F));
        this.g0 = com.iloen.melon.utils.a.g(this, 57);
        this.h0 = com.iloen.melon.utils.a.g(this, 58);
        this.i0 = com.iloen.melon.utils.a.g(this, 59);
        this.j0 = ge.c.a(new k8.n(this, 56));
        this.k0 = com.iloen.melon.utils.a.g(this, 61);
        this.l0 = com.iloen.melon.utils.a.g(this, 60);
        this.m0 = com.iloen.melon.utils.a.g(this, 0x3F);
        this.n0 = com.iloen.melon.utils.a.g(this, 65);
        this.o0 = com.iloen.melon.utils.a.g(this, 0x40);
        this.p0 = com.iloen.melon.utils.a.g(this, 67);
        this.q0 = com.iloen.melon.utils.a.g(this, 66);
        this.r0 = com.iloen.melon.utils.a.g(this, 62);
        this.s0 = com.iloen.melon.utils.a.g(this, 71);
        this.t0 = com.iloen.melon.utils.a.g(this, 70);
        this.u0 = com.iloen.melon.utils.a.g(this, 69);
        this.v0 = ge.a.a(new k8.n(this, 72));
        this.w0 = ge.c.a(new k8.n(this, 68));
        this.x0 = com.iloen.melon.utils.a.g(this, 73);
        this.y0 = com.iloen.melon.utils.a.g(this, 74);
        this.z0 = com.iloen.melon.utils.a.g(this, 75);
        this.A0 = com.iloen.melon.utils.a.g(this, 76);
        this.B0 = com.iloen.melon.utils.a.g(this, 77);
        this.C0 = com.iloen.melon.utils.a.g(this, 78);
        this.D0 = com.iloen.melon.utils.a.g(this, 0x4F);
        this.E0 = com.iloen.melon.utils.a.g(this, 80);
        this.F0 = com.iloen.melon.utils.a.g(this, 81);
        this.G0 = com.iloen.melon.utils.a.g(this, 82);
        this.H0 = com.iloen.melon.utils.a.g(this, 83);
        this.I0 = com.iloen.melon.utils.a.g(this, 84);
        this.J0 = com.iloen.melon.utils.a.g(this, 85);
        this.K0 = com.iloen.melon.utils.a.g(this, 86);
        this.L0 = com.iloen.melon.utils.a.g(this, 87);
        this.M0 = com.iloen.melon.utils.a.g(this, 88);
        this.N0 = com.iloen.melon.utils.a.g(this, 90);
        this.O0 = com.iloen.melon.utils.a.g(this, 89);
        this.P0 = com.iloen.melon.utils.a.g(this, 92);
        this.Q0 = com.iloen.melon.utils.a.g(this, 91);
        this.R0 = com.iloen.melon.utils.a.g(this, 93);
        this.S0 = com.iloen.melon.utils.a.g(this, 0x5F);
        this.T0 = com.iloen.melon.utils.a.g(this, 94);
        this.U0 = com.iloen.melon.utils.a.g(this, 0x60);
        this.V0 = com.iloen.melon.utils.a.g(this, 98);
        this.W0 = com.iloen.melon.utils.a.g(this, 97);
        this.X0 = com.iloen.melon.utils.a.g(this, 99);
        this.Y0 = com.iloen.melon.utils.a.g(this, 100);
        this.Z0 = com.iloen.melon.utils.a.g(this, 101);
        this.a1 = com.iloen.melon.utils.a.g(this, 102);
        this.b1 = com.iloen.melon.utils.a.g(this, 103);
        this.c1 = com.iloen.melon.utils.a.g(this, 104);
        this.d1 = com.iloen.melon.utils.a.g(this, 105);
        this.e1 = com.iloen.melon.utils.a.g(this, 107);
        this.f1 = com.iloen.melon.utils.a.g(this, 106);
        this.g1 = com.iloen.melon.utils.a.g(this, 108);
        this.h1 = com.iloen.melon.utils.a.g(this, 109);
        this.i1 = com.iloen.melon.utils.a.g(this, 110);
        this.j1 = com.iloen.melon.utils.a.g(this, 0x6F);
        this.k1 = com.iloen.melon.utils.a.g(this, 0x70);
        this.l1 = com.iloen.melon.utils.a.g(this, 0x71);
        this.m1 = com.iloen.melon.utils.a.g(this, 0x72);
        this.n1 = com.iloen.melon.utils.a.g(this, 0x73);
        this.o1 = com.iloen.melon.utils.a.g(this, 0x74);
        this.p1 = com.iloen.melon.utils.a.g(this, 0x76);
        this.q1 = com.iloen.melon.utils.a.g(this, 0x75);
        this.r1 = com.iloen.melon.utils.a.g(this, 120);
        this.s1 = com.iloen.melon.utils.a.g(this, 0x79);
        this.t1 = com.iloen.melon.utils.a.g(this, 0x77);
        this.u1 = com.iloen.melon.utils.a.g(this, 0x7A);
    }

    public final androidx.lifecycle.b a() {
        Ba.i i0 = (Ba.i)this.H0.get();
        q.g(i0, "api");
        return new androidx.lifecycle.b(new androidx.lifecycle.b(i0, 12), 13);
    }

    public final v b() {
        S0 s00 = new S0(((Ba.l)this.h0.get()));
        ha.a a0 = (ha.a)this.i0.get();
        q.g(a0, "local");
        v v0 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0.a = s00;
        v0.b = a0;
        return v0;
    }

    public final Ra.d c() {
        MelonDatabase melonDatabase0 = (MelonDatabase)this.B.get();
        q.g(melonDatabase0, "db");
        ea.a a0 = melonDatabase0.b();
        t.e(a0);
        return new Ra.d(new h(new h(a0)));
    }

    public final k8.a d() {
        return (k8.a)this.l.get();
    }

    public final DeviceData e() {
        t.e(this.a.a);
        return new DeviceData(this.a.a);
    }

    public final mb.f f() {
        return new mb.f(((va.n)this.G.get()));
    }

    public final y g() {
        return (y)com.iloen.melon.utils.a.j(((U)this.T.get()), "retrofit", y.class, "create(...)");
    }

    public final F h() {
        return (F)com.iloen.melon.utils.a.j(((U)this.e.get()), "retrofit", F.class, "create(...)");
    }

    public final ob.a i() {
        t.e(this.a.a);
        s2 s20 = (s2)this.w.get();
        u u0 = this.r();
        return new ob.a(this.a.a, s20, u0);
    }

    public final Bc.h j() {
        return new Bc.h(this.u(), this.l());
    }

    public final z k() {
        return new z(new ea.b(((Ub.u)this.U.get())), this.u(), ((Ub.q)this.u.get()), ((s2)this.w.get()), ((Qb.z)this.t.get()));
    }

    public final hc.l l() {
        t.e(this.a.a);
        s s0 = (s)this.z.get();
        return new hc.l(this.a.a, s0);
    }

    public final mb.o m() {
        return new mb.o(((u1)this.I.get()));
    }

    public final L n() {
        return (L)com.iloen.melon.utils.a.j(((U)this.R.get()), "retrofit", L.class, "create(...)");
    }

    public final db.g o() {
        return new db.g(((ma.g)this.W.get()));
    }

    public final u0 p() {
        u0 u00 = new u0();
        t.e(this.a.a);
        u00.a = this.a.a;
        u00.b = (kc.i)this.v.get();
        u00.c = (s)this.z.get();
        return u00;
    }

    @Override  // com.iloen.melon.playback.playlist.sol.PlaylistSolMetaRepositoryEntryPoint
    public final PlaylistSolMetaRepository playlistSolMetaRepository() {
        return new PlaylistSolMetaRepository(new w(this.n()));
    }

    public final ta.L q() {
        ta.l l0 = new ta.l(((B)this.E.get()));
        t.e(this.a.a);
        return new ta.L(l0, new MusicWaveLocalDataSourceImpl(this.a.a));
    }

    public final u r() {
        C c0 = (C)this.q.get();
        q.g(c0, "service");
        return new u(new pc.t(c0, 24));
    }

    public final W s() {
        this.u();
        return new W();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final Ea.e t() {
        J j0 = (J)this.G0.get();
        q.g(j0, "api");
        return new Ea.e(new A0.c(j0, 10), new w7.d(11));
    }

    public final StringProviderImpl u() {
        t.e(this.a.a);
        return new StringProviderImpl(this.a.a);
    }
}

