package Ac;

import Ad.J;
import Bd.P;
import Dd.I;
import Dd.g1;
import Fc.D;
import Fc.p;
import H8.q;
import I7.c;
import Ic.A0;
import Oc.U;
import Oc.o;
import Oc.x;
import Qc.w;
import Ua.N;
import Ua.h;
import Ua.n;
import Uc.m;
import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.c0;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.comment.CommentAttachPagerViewModel;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n4;
import com.melon.ui.t3;
import d5.t;
import db.g;
import ea.d;
import eb.y;
import ge.b;
import kc.s2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import mb.k;
import ob.z;
import pb.l;

public abstract class h0 implements b {
    public static CoroutineDispatcher A() {
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getDefault();
        t.e(coroutineDispatcher0);
        return coroutineDispatcher0;
    }

    public static CoroutineDispatcher B() {
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getIO();
        t.e(coroutineDispatcher0);
        return coroutineDispatcher0;
    }

    public static CoroutineDispatcher C() {
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getMain();
        t.e(coroutineDispatcher0);
        return coroutineDispatcher0;
    }

    public static g0 a(c0 c00, N n0, StringProviderImpl stringProviderImpl0) {
        return new g0(c00, n0, stringProviderImpl0);
    }

    public static G0 b(N n0, StringProviderImpl stringProviderImpl0) {
        return new G0(n0, stringProviderImpl0);
    }

    public static M0 c(c0 c00, N n0, StringProviderImpl stringProviderImpl0) {
        return new M0(c00, n0, stringProviderImpl0);
    }

    public static N2 d(c0 c00, N n0, StringProviderImpl stringProviderImpl0, Q q0, k k0) {
        return new N2(c00, n0, stringProviderImpl0, q0, k0);
    }

    public static L3 e(c0 c00, N n0, StringProviderImpl stringProviderImpl0, Q q0, k k0) {
        return new L3(c00, n0, stringProviderImpl0, q0, k0);
    }

    public static r4 f(c0 c00, N n0, StringProviderImpl stringProviderImpl0, Q q0) {
        return new r4(c00, n0, stringProviderImpl0, q0);
    }

    public static J g(l l0, CoroutineDispatcher coroutineDispatcher0, k k0) {
        return new J(l0, coroutineDispatcher0, k0);
    }

    public static P h(StringProviderImpl stringProviderImpl0, Context context0, s2 s20, h h0, g g0, Q q0) {
        return new P(stringProviderImpl0, context0, s20, h0, g0, q0);
    }

    public static I i(d d0, q q0, Q q1, n4 n40, StringProviderImpl stringProviderImpl0, k k0, N n0) {
        return new I(d0, q0, q1, n40, stringProviderImpl0, k0, n0);
    }

    public static g1 j(d d0, Za.b b0, Q q0, n4 n40, StringProviderImpl stringProviderImpl0, k k0, N n0) {
        return new g1(d0, b0, q0, n40, stringProviderImpl0, k0, n0);
    }

    public static p k(s2 s20, z z0) {
        return new p(s20, z0);
    }

    public static D l(StringProviderImpl stringProviderImpl0, z z0, s2 s20) {
        return new D(stringProviderImpl0, z0, s20);
    }

    public static A0 m(h h0, c c0, q q0, k k0, n4 n40, t3 t30, b3 b30, y y0, Q q1, n n0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        return new A0(h0, c0, q0, k0, n40, t30, b30, y0, q1, n0, stringProviderImpl0, coroutineDispatcher0);
    }

    public static Lc.t n() {
        return new Lc.t();
    }

    public static Oc.k o(h h0, Q q0, StringProviderImpl stringProviderImpl0) {
        return new Oc.k(h0, q0, stringProviderImpl0);
    }

    public static o p(h h0, Q q0) {
        return new o(h0, q0);
    }

    public static x q(h h0, Q q0, b3 b30, t3 t30, n4 n40, StringProviderImpl stringProviderImpl0, y y0, k k0) {
        return new x(h0, q0, b30, t30, n40, stringProviderImpl0, y0, k0);
    }

    public static Oc.D r(h h0, n4 n40, b3 b30, Q q0, k k0) {
        return new Oc.D(h0, n40, b30, q0, k0);
    }

    public static Oc.N s(h h0, Q q0, b3 b30, t3 t30, n4 n40, StringProviderImpl stringProviderImpl0, y y0, k k0) {
        return new Oc.N(h0, q0, b30, t30, n40, stringProviderImpl0, y0, k0);
    }

    public static U t(h h0, Q q0) {
        return new U(h0, q0);
    }

    public static w u(Q q0) {
        return new w(q0);
    }

    public static CommentAttachPagerViewModel v(Context context0) {
        return new CommentAttachPagerViewModel(context0);
    }

    public static ad.p w() {
        return new ad.p();
    }

    public static Uc.q x() {
        return new Uc.q();
    }

    public static m y() {
        return new m();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static CoroutineScope z(de.h h0) {
        kotlin.jvm.internal.q.g(h0, "lifecycle");
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        Ma.h h1 = new Ma.h(coroutineScope0);
        if(com.google.firebase.b.c == null) {
            com.google.firebase.b.c = Looper.getMainLooper().getThread();
        }
        if(Thread.currentThread() != com.google.firebase.b.c) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
        if(h0.b) {
            throw new IllegalStateException("There was a race between the call to add/remove an OnClearedListener and onCleared(). This can happen when posting to the Main thread from a background thread, which is not supported.");
        }
        h0.a.add(h1);
        t.e(coroutineScope0);
        return coroutineScope0;
    }
}

