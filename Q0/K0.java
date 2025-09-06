package Q0;

import I.L0;
import P0.r0;
import androidx.compose.runtime.A;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidUriHandler;
import e1.i;
import r1.c;
import r1.m;
import we.n;

public abstract class k0 {
    public static final c1 a;
    public static final c1 b;
    public static final c1 c;
    public static final c1 d;
    public static final c1 e;
    public static final c1 f;
    public static final c1 g;
    public static final c1 h;
    public static final c1 i;
    public static final c1 j;
    public static final c1 k;
    public static final c1 l;
    public static final c1 m;
    public static final c1 n;
    public static final c1 o;
    public static final c1 p;
    public static final c1 q;
    public static final c1 r;
    public static final c1 s;
    public static final c1 t;
    public static final c1 u;
    public static final A v;
    public static final c1 w;

    static {
        k0.a = new c1(O.n);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.b = new c1(O.o);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.c = new c1(O.w);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.d = new c1(O.r);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.e = new c1(O.D);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.f = new c1(O.B);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.g = new c1(O.S);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.h = new c1(O.G);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.i = new c1(O.I);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.j = new c1(O.N);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.k = new c1(O.M);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.l = new c1(O.T);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.m = new c1(O.V);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.n = new c1(O.W);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.o = new c1(O.b0);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.p = new c1(O.Z);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.q = new c1(O.c0);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.r = new c1(O.d0);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.s = new c1(O.e0);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.t = new c1(O.f0);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.u = new c1(O.X);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
        k0.v = new A(O.Y);
        k0.w = new c1(O.E);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
    }

    public static final void a(r0 r00, AndroidUriHandler androidUriHandler0, n n0, l l0, int v) {
        ((p)l0).c0(0x34224BAD);
        int v1 = v | (((p)l0).g(r00) ? 4 : 2) | (((p)l0).g(androidUriHandler0) ? 0x20 : 16) | (((p)l0).i(n0) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            f f0 = ((u)r00).getAccessibilityManager();
            m0 m00 = k0.a.a(f0);
            m0 m01 = k0.b.a(((u)r00).getAutofill());
            m0 m02 = k0.d.a(((u)r00).getAutofillManager());
            m0 m03 = k0.c.a(((u)r00).getAutofillTree());
            i0 i00 = ((u)r00).getClipboardManager();
            m0 m04 = k0.e.a(i00);
            h0 h00 = ((u)r00).getClipboard();
            m0 m05 = k0.f.a(h00);
            c c0 = ((u)r00).getDensity();
            m0 m06 = k0.h.a(c0);
            m0 m07 = k0.i.a(((u)r00).getFocusOwner());
            m0 m08 = k0.j.a(((u)r00).getFontLoader());
            m08.f = false;
            i i0 = ((u)r00).getFontFamilyResolver();
            m0 m09 = k0.k.a(i0);
            m09.f = false;
            m0 m010 = k0.l.a(((u)r00).getHapticFeedBack());
            m0 m011 = k0.m.a(((u)r00).getInputModeManager());
            m m0 = ((u)r00).getLayoutDirection();
            w.b(new m0[]{m00, m01, m02, m03, m04, m05, m06, m07, m08, m09, m010, m011, k0.n.a(m0), k0.o.a(((u)r00).getTextInputService()), k0.p.a(((u)r00).getSoftwareKeyboardController()), k0.q.a(((u)r00).getTextToolbar()), k0.r.a(androidUriHandler0), k0.s.a(((u)r00).getViewConfiguration()), k0.t.a(((u)r00).getWindowInfo()), k0.u.a(((u)r00).getPointerIconService()), k0.g.a(((u)r00).getGraphicsContext())}, n0, ((p)l0), v1 >> 3 & 0x70 | 8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new L0(r00, androidUriHandler0, n0, v, 3);
        }
    }

    public static final void b(String s) {
        throw new IllegalStateException(("CompositionLocal " + s + " not present").toString());
    }

    public static final c1 c() {
        return k0.h;
    }
}

