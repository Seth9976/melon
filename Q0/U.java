package Q0;

import A3.l;
import B0.a;
import Dc.s;
import E9.t;
import F0.b;
import G0.c;
import J0.i;
import J0.j;
import J0.x;
import Mc.H;
import N0.J;
import N0.Z;
import N0.d0;
import N0.g0;
import P0.A0;
import P0.G0;
import P0.I;
import P0.K;
import P0.X;
import P0.j0;
import P0.q0;
import P0.r0;
import P0.t0;
import P0.v;
import P0.w0;
import Ua.h;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScrollCaptureTarget;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest.Builder;
import androidx.collection.G;
import androidx.collection.z;
import androidx.compose.runtime.E;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidAccessibilityManager;
import androidx.compose.ui.platform.AndroidClipboard;
import androidx.compose.ui.platform.AndroidClipboardManager;
import androidx.compose.ui.platform.AndroidComposeView.bringIntoViewNode.1;
import androidx.compose.ui.platform.AndroidFontResourceLoader;
import androidx.compose.ui.platform.AndroidViewsHandler;
import androidx.compose.ui.platform.DrawChildContainer;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import com.iloen.melon.custom.S0;
import f1.A;
import f1.y;
import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.P3;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import k8.Y;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r1.e;
import r1.m;
import s0.k;
import y0.F;
import y0.d;

public final class u extends ViewGroup implements i, r0, d1, f {
    public final Q0.i A0;
    public final AndroidAccessibilityManager B;
    public final A B0;
    public final y C0;
    public final d D;
    public final AtomicReference D0;
    public final k E;
    public final l0 E0;
    public final AndroidFontResourceLoader F0;
    public final ArrayList G;
    public final b0 G0;
    public int H0;
    public ArrayList I;
    public final b0 I0;
    public final b J0;
    public final c K0;
    public final O0.c L0;
    public boolean M;
    public final W M0;
    public boolean N;
    public MotionEvent N0;
    public long O0;
    public final ea.c P0;
    public final G Q0;
    public final t R0;
    public final j S;
    public final l S0;
    public final a T;
    public boolean T0;
    public final r U0;
    public we.k V;
    public final e0 V0;
    public final s0.a W;
    public boolean W0;
    public final h X0;
    public final q Y0;
    public static Class Z0;
    public long a;
    public static Method a1;
    public final boolean b;
    public final s0.c b0;
    public final K c;
    public boolean c0;
    public final b0 d;
    public final AndroidClipboardManager d0;
    public final w0.k e;
    public final AndroidClipboard e0;
    public me.i f;
    public final t0 f0;
    public final u0.a g;
    public boolean g0;
    public final y0 h;
    public AndroidViewsHandler h0;
    public final y0.r i;
    public DrawChildContainer i0;
    public final c0 j;
    public r1.a j0;
    public final I k;
    public boolean k0;
    public final z l;
    public final X l0;
    public final Y0.a m;
    public long m0;
    public final u n;
    public final int[] n0;
    public final X0.q o;
    public final float[] o0;
    public final float[] p0;
    public final float[] q0;
    public final C r;
    public long r0;
    public boolean s0;
    public long t0;
    public boolean u0;
    public final b0 v0;
    public t0.d w;
    public final E w0;
    public we.k x0;
    public final g y0;
    public final Q0.h z0;

    static {
    }

    public u(Context context0, me.i i0) {
        super(context0);
        ea.b b0;
        m m0;
        this.a = 0x7FC000007FC00000L;
        this.b = true;
        this.c = new K();
        e e0 = de.c.c(context0);
        V v0 = V.d;
        this.d = w.r(e0, v0);
        X0.f f0 = new X0.f();  // 初始化器: Lr0/p;-><init>()V
        EmptySemanticsElement emptySemanticsElement0 = new EmptySemanticsElement(f0);
        AndroidComposeView.bringIntoViewNode.1 androidComposeView$bringIntoViewNode$10 = new AndroidComposeView.bringIntoViewNode.1(this);
        this.e = new w0.k(new H(1, this, u.class, "registerOnEndApplyChangesListener", "registerOnEndApplyChangesListener(Lkotlin/jvm/functions/Function0;)V", 0, 18), new s(2, this, u.class, "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", 0, 3), new H(1, this, u.class, "onMoveFocusInChildren", "onMoveFocusInChildren-3ESFkO8(I)Z", 0, 19), new Ic.h(0, this, u.class, "onClearFocusForOwner", "onClearFocusForOwner()V", 0, 4), new Ic.h(0, this, u.class, "onFetchFocusRect", "onFetchFocusRect()Landroidx/compose/ui/geometry/Rect;", 0, 5), new n(0, 0, u.class, this, "layoutDirection", "getLayoutDirection()Landroidx/compose/ui/unit/LayoutDirection;"));
        this.f = i0;
        this.g = new u0.a();
        this.h = new y0();
        r0.q q0 = androidx.compose.ui.input.key.a.b(new p(this, 0));
        r0.q q1 = androidx.compose.ui.input.rotary.a.a();
        this.i = new y0.r();
        this.j = new c0(ViewConfiguration.get(context0));
        I i1 = new I(3);
        i1.b0(d0.b);
        i1.Z(this.getDensity());
        i1.d0(this.getViewConfiguration());
        i1.c0(emptySemanticsElement0.then(q1).then(q0).then(((w0.k)this.getFocusOwner()).i).then(this.getDragAndDropManager().c).then(androidComposeView$bringIntoViewNode$10));
        this.k = i1;
        this.l = new z();
        this.m = new Y0.a();
        this.n = this;
        this.o = new X0.q(this.getRoot(), f0, this.getLayoutNodes());
        C c0 = new C(this);
        this.r = c0;
        this.w = new t0.d(this, new Ic.h(0, this, N.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", 1, 3));
        this.B = new AndroidAccessibilityManager(context0);
        this.D = new d(this);
        this.E = new k();
        this.G = new ArrayList();
        this.S = new j();
        I i2 = this.getRoot();
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.b = i2;
        a0.c = new J0.d(((v)i2.b0.c));
        a0.d = new I7.c(3);
        a0.e = new P0.t();
        this.T = a0;
        this.V = Q0.l.g;
        this.W = new s0.a(this, this.getAutofillTree());
        AutofillManager autofillManager0 = (AutofillManager)context0.getSystemService(AutofillManager.class);
        if(autofillManager0 == null) {
            throw Y.d("Autofill service could not be located.");
        }
        this.b0 = new s0.c(new pc.t(autofillManager0, 9), this.getSemanticsOwner(), this, this.getRectManager(), "com.iloen.melon");
        this.d0 = new AndroidClipboardManager(context0);
        this.e0 = new AndroidClipboard(this.getClipboardManager());
        this.f0 = new t0(new p(this, 1));
        this.l0 = new X(this.getRoot());
        this.m0 = 0x7FFFFFFF7FFFFFFFL;
        this.n0 = new int[]{0, 0};
        float[] arr_f = F.a();
        this.o0 = arr_f;
        this.p0 = F.a();
        this.q0 = F.a();
        this.r0 = -1L;
        this.t0 = 0x7F8000007F800000L;
        this.u0 = true;
        h h0 = null;
        this.v0 = w.s(null);
        this.w0 = w.i(new r(this, 1));
        this.y0 = () -> {
            boolean z2;
            boolean z1;
            int[] arr_v = this.n0;
            this.getLocationOnScreen(arr_v);
            int v = (int)(this.m0 >> 0x20);
            int v1 = (int)(this.m0 & 0xFFFFFFFFL);
            boolean z = false;
            int v2 = arr_v[0];
            if(v == v2 && v1 == arr_v[1] && this.r0 >= 0L) {
                z1 = false;
            }
            else {
                this.m0 = 0xFFFFFFFFL & ((long)arr_v[1]) | ((long)v2) << 0x20;
                if(v == 0x7FFFFFFF || v1 == 0x7FFFFFFF) {
                    z1 = false;
                }
                else {
                    this.getRoot().c0.p.x0();
                    z1 = true;
                }
            }
            this.D();
            Y0.a a0 = this.getRectManager();
            long v3 = this.m0;
            long v4 = e1.b.J(this.t0);
            a0.getClass();
            float[] arr_f = this.p0;
            Y0.d d0 = a0.b;
            if((a.a.j(arr_f) & 2) != 0) {
                arr_f = null;
            }
            if(r1.j.a(v4, d0.b)) {
                z2 = false;
            }
            else {
                d0.b = v4;
                z2 = true;
            }
            if(!r1.j.a(v3, d0.c)) {
                d0.c = v3;
                z2 = true;
            }
            if(arr_f != null) {
                z2 = true;
            }
            if(z2 || a0.e) {
                z = true;
            }
            a0.e = z;
            this.l0.a(z1);
            this.getRectManager().a();
        };
        this.z0 = new Q0.h(this, 0);
        this.A0 = new Q0.i(this);
        A a1 = new A(this, this);
        this.B0 = a1;
        this.C0 = new y(a1);
        this.D0 = new AtomicReference(null);
        this.E0 = new l0(this.getTextInputService());
        this.F0 = new AndroidFontResourceLoader(context0);
        this.G0 = w.r(e1.m.m(context0), v0);
        Configuration configuration0 = context0.getResources().getConfiguration();
        int v1 = Build.VERSION.SDK_INT;
        this.H0 = v1 < 0x1F ? 0 : configuration0.fontWeightAdjustment;
        switch(context0.getResources().getConfiguration().getLayoutDirection()) {
            case 0: {
                m0 = m.a;
                break;
            }
            case 1: {
                m0 = m.b;
                break;
            }
            default: {
                m0 = null;
            }
        }
        if(m0 == null) {
            m0 = m.a;
        }
        this.I0 = w.s(m0);
        this.J0 = new b(this, 0);
        this.K0 = new c((this.isInTouchMode() ? 1 : 2));
        this.L0 = new O0.c(this);
        this.M0 = new W(this);
        this.P0 = new ea.c();
        this.Q0 = new G();
        this.R0 = new t(this, 4);
        this.S0 = new l(this, 9);
        this.U0 = new r(this, 0);
        if(v1 < 29) {
            b0 = new ea.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b0.a = arr_f;
            b0.b = new int[2];
        }
        else {
            b0 = new f0();
        }
        this.V0 = b0;
        this.addOnAttachStateChangeListener(this.w);
        this.setWillNotDraw(false);
        this.setFocusable(true);
        M.a.a(this, 1, false);
        this.setFocusableInTouchMode(true);
        this.setClipChildren(false);
        c2.W.o(this, c0);
        this.setOnDragListener(this.getDragAndDropManager());
        this.getRoot().e(this);
        if(v1 >= 29) {
            Q0.H.a.a(this);
        }
        if(v1 >= 0x1F) {
            h0 = new h(8);
        }
        this.X0 = h0;
        this.Y0 = new q(this);
    }

    public final void A(I i0, boolean z, boolean z1, boolean z2) {
        X x0 = this.l0;
        if(z) {
            d5.e e0 = x0.b;
            P0.M m0 = i0.c0;
            if(i0.h == null) {
                M0.a.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
            }
            switch(m0.d.ordinal()) {
                case 1: {
                    break;
                }
                case 0: 
                case 2: 
                case 3: {
                    P0.W w0 = new P0.W(i0, true, z1);
                    x0.h.b(w0);
                    return;
                }
                case 4: {
                    if(!m0.e || z1) {
                        m0.e = true;
                        m0.p.G = true;
                        if(!i0.l0) {
                            if(!kotlin.jvm.internal.q.b(i0.J(), Boolean.TRUE) && (!m0.e || i0.s() != P0.G.a && (m0.q == null || (m0.q.B == null || !m0.q.B.e())))) {
                            label_20:
                                if(i0.I() || X.h(i0)) {
                                    I i2 = i0.u();
                                    if(i2 == null || !i2.r()) {
                                        e0.h(i0, false);
                                    }
                                }
                            }
                            else {
                                I i1 = i0.u();
                                if(i1 == null || !i1.c0.e) {
                                    e0.h(i0, true);
                                    goto label_24;
                                }
                                goto label_20;
                            }
                        label_24:
                            if(!x0.d && z2) {
                                this.G(i0);
                                return;
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        else if(x0.p(i0, z1) && z2) {
            this.G(i0);
        }
    }

    public final void B(I i0, boolean z, boolean z1) {
        P0.M m0 = i0.c0;
        X x0 = this.l0;
        if(z) {
            d5.e e0 = x0.b;
            switch(m0.d.ordinal()) {
                case 1: 
                case 3: {
                    break;
                }
                case 0: 
                case 2: 
                case 4: {
                    if(!m0.e && !m0.f || z1) {
                        m0.f = true;
                        m0.g = true;
                        m0.p.I = true;
                        m0.p.M = true;
                        if(!i0.l0) {
                            I i1 = i0.u();
                            if(kotlin.jvm.internal.q.b(i0.J(), Boolean.TRUE) && (i1 == null || !i1.c0.e) && (i1 == null || !i1.c0.f)) {
                                e0.h(i0, true);
                            }
                            else if(i0.I() && (i1 == null || !i1.q()) && (i1 == null || !i1.r())) {
                                e0.h(i0, false);
                            }
                            if(!x0.d) {
                                this.G(null);
                                return;
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        else {
            x0.getClass();
            switch(m0.d.ordinal()) {
                case 0: 
                case 1: 
                case 2: 
                case 3: {
                    break;
                }
                case 4: {
                    I i2 = i0.u();
                    boolean z2 = i2 == null || i2.I();
                    if(z1 || !i0.r() && (!i0.q() || i0.I() != z2 || i0.I() != m0.p.E)) {
                        m0.p.I = true;
                        m0.p.M = true;
                        if(!i0.l0 && m0.p.E && z2) {
                            if((i2 == null || !i2.q()) && (i2 == null || !i2.r())) {
                                x0.b.h(i0, false);
                            }
                            if(!x0.d) {
                                this.G(null);
                                return;
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }

    public final void C() {
        C c0 = this.r;
        c0.x = true;
        if(c0.l() && !c0.I) {
            c0.I = true;
            c0.i.post(c0.J);
        }
        t0.d d0 = this.w;
        d0.g = true;
        if(d0.e() && !d0.n) {
            d0.n = true;
            d0.i.post(d0.o);
        }
    }

    public final void D() {
        if(!this.s0) {
            long v = AnimationUtils.currentAnimationTimeMillis();
            if(v != this.r0) {
                this.r0 = v;
                this.V0.c(this, this.p0);
                N.n(this.p0, this.q0);
                ViewParent viewParent0 = this.getParent();
                View view0 = this;
                while(viewParent0 instanceof ViewGroup) {
                    view0 = (View)viewParent0;
                    viewParent0 = ((ViewGroup)view0).getParent();
                }
                view0.getLocationOnScreen(this.n0);
                float f = (float)this.n0[0];
                float f1 = (float)this.n0[1];
                view0.getLocationInWindow(this.n0);
                this.t0 = ((long)Float.floatToRawIntBits(f - ((float)this.n0[0]))) << 0x20 | ((long)Float.floatToRawIntBits(f1 - ((float)this.n0[1]))) & 0xFFFFFFFFL;
            }
        }
    }

    public final void E(MotionEvent motionEvent0) {
        this.r0 = AnimationUtils.currentAnimationTimeMillis();
        this.V0.c(this, this.p0);
        N.n(this.p0, this.q0);
        long v = F.b(((long)Float.floatToRawIntBits(motionEvent0.getX())) << 0x20 | ((long)Float.floatToRawIntBits(motionEvent0.getY())) & 0xFFFFFFFFL, this.p0);
        this.t0 = ((long)Float.floatToRawIntBits(motionEvent0.getRawX() - Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(motionEvent0.getRawY() - Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL;
    }

    public final void F(q0 q00) {
        g0.e e0;
        ea.c c0;
        do {
            c0 = this.P0;
            ReferenceQueue referenceQueue0 = (ReferenceQueue)c0.c;
            e0 = (g0.e)c0.b;
            Reference reference0 = referenceQueue0.poll();
            if(reference0 != null) {
                e0.j(reference0);
            }
        }
        while(reference0 != null);
        e0.b(new WeakReference(q00, ((ReferenceQueue)c0.c)));
        this.G.remove(q00);
    }

    public final void G(I i0) {
        if(!this.isLayoutRequested() && this.isAttachedToWindow()) {
            if(i0 != null) {
                while(i0 != null && i0.c0.p.l == P0.G.a) {
                    if(!this.k0) {
                        I i1 = i0.u();
                        if(i1 == null) {
                            break;
                        }
                        long v = ((v)i1.b0.c).d;
                        if(!r1.a.f(v) || !r1.a.e(v)) {
                            goto label_8;
                        }
                        break;
                    }
                label_8:
                    i0 = i0.u();
                }
                if(i0 == this.getRoot()) {
                    this.requestLayout();
                    return;
                }
            }
            if(this.getWidth() != 0 && this.getHeight() != 0) {
                this.invalidate();
                return;
            }
            this.requestLayout();
        }
    }

    public final long H(long v) {
        this.D();
        return F.b(((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(this.t0 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) - Float.intBitsToFloat(((int)(this.t0 >> 0x20))))) << 0x20, this.q0);
    }

    public final int I(MotionEvent motionEvent0) {
        Object object1;
        if(this.W0) {
            this.W0 = false;
            int v = motionEvent0.getMetaState();
            this.h.getClass();
            J0.E e0 = new J0.E(v);
            ((O0)f1.a).setValue(e0);
        }
        j j0 = this.S;
        x9.c c0 = j0.a(this, motionEvent0);
        a a0 = this.T;
        if(c0 != null) {
            List list0 = (List)c0.b;
            int v1 = list0.size() - 1;
            if(v1 >= 0) {
                while(true) {
                    Object object0 = list0.get(v1);
                    if(((x)object0).e) {
                        object1 = object0;
                        goto label_21;
                    }
                    if(v1 - 1 < 0) {
                        break;
                    }
                    --v1;
                }
            }
            object1 = null;
        label_21:
            if(((x)object1) != null) {
                this.a = ((x)object1).d;
            }
            int v2 = a0.c(c0, this, this.q(motionEvent0));
            switch(motionEvent0.getActionMasked()) {
                case 0: 
                case 5: {
                    if((v2 & 1) != 0) {
                        return v2;
                    }
                    int v3 = motionEvent0.getPointerId(motionEvent0.getActionIndex());
                    j0.c.delete(v3);
                    j0.b.delete(v3);
                    return v2;
                }
                default: {
                    return v2;
                }
            }
        }
        if(!a0.a) {
            ((androidx.collection.s)((I7.c)a0.d).b).a();
            ((J0.d)a0.c).f();
        }
        return 0;
    }

    public final void J(MotionEvent motionEvent0, int v, long v1, boolean z) {
        int v2 = -1;
        switch(motionEvent0.getActionMasked()) {
            case 1: {
                if(v != 9 && v != 10) {
                    v2 = 0;
                }
                break;
            }
            case 6: {
                v2 = motionEvent0.getActionIndex();
            }
        }
        int v3 = motionEvent0.getPointerCount() - (v2 < 0 ? 0 : 1);
        if(v3 == 0) {
            return;
        }
        MotionEvent.PointerProperties[] arr_motionEvent$PointerProperties = new MotionEvent.PointerProperties[v3];
        for(int v4 = 0; v4 < v3; ++v4) {
            arr_motionEvent$PointerProperties[v4] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] arr_motionEvent$PointerCoords = new MotionEvent.PointerCoords[v3];
        for(int v5 = 0; v5 < v3; ++v5) {
            arr_motionEvent$PointerCoords[v5] = new MotionEvent.PointerCoords();
        }
        for(int v6 = 0; v6 < v3; ++v6) {
            int v7 = (v2 < 0 || v6 < v2 ? 0 : 1) + v6;
            motionEvent0.getPointerProperties(v7, arr_motionEvent$PointerProperties[v6]);
            MotionEvent.PointerCoords motionEvent$PointerCoords0 = arr_motionEvent$PointerCoords[v6];
            motionEvent0.getPointerCoords(v7, motionEvent$PointerCoords0);
            long v8 = this.t(((long)Float.floatToRawIntBits(motionEvent$PointerCoords0.y)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(motionEvent$PointerCoords0.x)) << 0x20);
            motionEvent$PointerCoords0.x = Float.intBitsToFloat(((int)(v8 >> 0x20)));
            motionEvent$PointerCoords0.y = Float.intBitsToFloat(((int)(v8 & 0xFFFFFFFFL)));
        }
        int v9 = z ? 0 : motionEvent0.getButtonState();
        MotionEvent motionEvent1 = MotionEvent.obtain((motionEvent0.getDownTime() == motionEvent0.getEventTime() ? v1 : motionEvent0.getDownTime()), v1, v, v3, arr_motionEvent$PointerProperties, arr_motionEvent$PointerCoords, motionEvent0.getMetaState(), v9, motionEvent0.getXPrecision(), motionEvent0.getYPrecision(), motionEvent0.getDeviceId(), motionEvent0.getEdgeFlags(), motionEvent0.getSource(), motionEvent0.getFlags());
        x9.c c0 = this.S.a(this, motionEvent1);
        kotlin.jvm.internal.q.d(c0);
        this.T.c(c0, this, true);
        motionEvent1.recycle();
    }

    public final void K(we.n n0, oe.c c0) {
        Q0.t t0;
        if(c0 instanceof Q0.t) {
            t0 = (Q0.t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new Q0.t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new Q0.t(this, c0);
        }
        Object object0 = t0.r;
        ne.a a0 = ne.a.a;
        switch(t0.B) {
            case 0: {
                d5.n.D(object0);
                p p0 = new p(this, 2);
                t0.B = 1;
                if(CoroutineScopeKt.coroutineScope(new r0.t(p0, this.D0, n0, null), t0) == a0) {
                    return;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    // 检测为 Lambda 实现
    public final void L() [...]

    @Override  // android.view.ViewGroup
    public final void addView(View view0) {
        this.addView(view0, -1);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v) {
        kotlin.jvm.internal.q.d(view0);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            viewGroup$LayoutParams0 = this.generateDefaultLayoutParams();
        }
        this.addViewInLayout(view0, v, viewGroup$LayoutParams0, true);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, int v1) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.generateDefaultLayoutParams();
        viewGroup$LayoutParams0.width = v;
        viewGroup$LayoutParams0.height = v1;
        this.addViewInLayout(view0, -1, viewGroup$LayoutParams0, true);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.addViewInLayout(view0, v, viewGroup$LayoutParams0, true);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.addViewInLayout(view0, -1, viewGroup$LayoutParams0, true);
    }

    @Override  // android.view.View
    public final void autofill(SparseArray sparseArray0) {
        s0.c c0 = this.b0;
        if(c0 != null) {
            int v1 = sparseArray0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = sparseArray0.keyAt(v2);
                AutofillValue autofillValue0 = (AutofillValue)sparseArray0.get(v3);
                if(autofillValue0.isText()) {
                    I i0 = (I)c0.b.c.b(v3);
                    if(i0 != null) {
                        X0.l l0 = i0.w();
                        if(l0 != null) {
                            Object object0 = l0.a.g(X0.k.g);
                            if(object0 == null) {
                                object0 = null;
                            }
                            if(((X0.a)object0) != null) {
                                we.k k0 = (we.k)((X0.a)object0).b;
                                if(k0 != null) {
                                    Boolean boolean0 = (Boolean)k0.invoke(new a1.g(autofillValue0.getTextValue().toString()));
                                }
                            }
                        }
                    }
                }
                else if(autofillValue0.isDate()) {
                    Log.w("ComposeAutofillManager", "Auto filling Date fields is not yet supported.");
                }
                else if(autofillValue0.isList()) {
                    Log.w("ComposeAutofillManager", "Auto filling dropdown lists is not yet supported.");
                }
                else if(autofillValue0.isToggle()) {
                    Log.w("ComposeAutofillManager", "Auto filling toggle fields are not yet supported.");
                }
            }
        }
        s0.a a0 = this.W;
        if(a0 != null) {
            k k1 = a0.b;
            if(!k1.a.isEmpty()) {
                int v4 = sparseArray0.size();
                for(int v = 0; v < v4; ++v) {
                    int v5 = sparseArray0.keyAt(v);
                    AutofillValue autofillValue1 = (AutofillValue)sparseArray0.get(v5);
                    if(autofillValue1.isText()) {
                        String s = autofillValue1.getTextValue().toString();
                        s0.j j0 = (s0.j)k1.a.get(v5);
                        if(j0 != null) {
                            we.k k2 = j0.c;
                            if(k2 != null) {
                                k2.invoke(s);
                            }
                        }
                    }
                    else {
                        if(autofillValue1.isDate()) {
                            throw new ie.l("An operation is not implemented: b/138604541: Add onFill() callback for date");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
                        }
                        if(autofillValue1.isList()) {
                            throw new ie.l("An operation is not implemented: b/138604541: Add onFill() callback for list");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
                        }
                        if(autofillValue1.isToggle()) {
                            throw new ie.l("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
                        }
                        continue;
                    }
                }
            }
        }
    }

    public static final void b(u u0, int v, AccessibilityNodeInfo accessibilityNodeInfo0, String s) {
        C c0 = u0.r;
        if(kotlin.jvm.internal.q.b(s, c0.D)) {
            int v1 = c0.B.d(v);
            if(v1 != -1) {
                accessibilityNodeInfo0.getExtras().putInt(s, v1);
            }
        }
        else if(kotlin.jvm.internal.q.b(s, c0.E)) {
            int v2 = c0.C.d(v);
            if(v2 != -1) {
                accessibilityNodeInfo0.getExtras().putInt(s, v2);
            }
        }
    }

    @Override  // android.view.View
    public final boolean canScrollHorizontally(int v) {
        return this.r.d(this.a, v, false);
    }

    @Override  // android.view.View
    public final boolean canScrollVertically(int v) {
        return this.r.d(this.a, v, true);
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        if(!this.isAttachedToWindow()) {
            u.n(this.getRoot());
        }
        this.u(true);
        p0.m.k().m();
        this.M = true;
        Canvas canvas1 = this.i.a.a;
        this.i.a.a = canvas0;
        this.getRoot().j(this.i.a, null);
        this.i.a.a = canvas1;
        ArrayList arrayList0 = this.G;
        if(!arrayList0.isEmpty()) {
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((q0)arrayList0.get(v1)).k();
            }
        }
        if(c1.E) {
            int v2 = canvas0.save();
            canvas0.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas0);
            canvas0.restoreToCount(v2);
        }
        arrayList0.clear();
        this.M = false;
        ArrayList arrayList1 = this.I;
        if(arrayList1 != null) {
            arrayList0.addAll(arrayList1);
            arrayList1.clear();
        }
        this.getRectManager().a();
    }

    @Override  // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent0) {
        P0.m m0;
        r0.p p1;
        if(this.T0) {
            l l0 = this.S0;
            this.removeCallbacks(l0);
            if(motionEvent0.getActionMasked() == 8) {
                this.T0 = false;
            }
            else {
                l0.run();
            }
        }
        if(motionEvent0.getActionMasked() == 8 && !u.p(motionEvent0) && this.isAttachedToWindow()) {
            if(motionEvent0.isFromSource(0x400000)) {
                ViewConfiguration viewConfiguration0 = ViewConfiguration.get(this.getContext());
                motionEvent0.getAxisValue(26);
                this.getContext();
                viewConfiguration0.getScaledVerticalScrollFactor();
                this.getContext();
                viewConfiguration0.getScaledHorizontalScrollFactor();
                motionEvent0.getEventTime();
                motionEvent0.getDeviceId();
                G.g g0 = new G.g(11, this, motionEvent0);
                w0.k k0 = (w0.k)this.getFocusOwner();
                if(k0.g.f) {
                    System.out.println("FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
                    return false;
                }
                w0.u u0 = w0.f.g(k0.f);
                if(u0 == null) {
                    m0 = null;
                }
                else {
                    if(!u0.getNode().isAttached()) {
                        M0.a.b("visitAncestors called on an unattached node");
                    }
                    r0.p p0 = u0.getNode();
                    I i0 = P0.f.v(u0);
                alab1:
                    while(true) {
                        p1 = null;
                        if(i0 == null) {
                            break;
                        }
                        if((((r0.p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x4000) != 0) {
                            while(p0 != null) {
                                if((p0.getKindSet$ui_release() & 0x4000) != 0) {
                                    g0.e e0 = null;
                                    p1 = p0;
                                    while(p1 != null) {
                                        if(p1 instanceof L0.a) {
                                            break alab1;
                                        }
                                        if((p1.getKindSet$ui_release() & 0x4000) != 0 && p1 instanceof P0.n) {
                                            r0.p p2 = ((P0.n)p1).b;
                                            int v = 0;
                                            while(p2 != null) {
                                                if((p2.getKindSet$ui_release() & 0x4000) != 0) {
                                                    ++v;
                                                    if(v == 1) {
                                                        p1 = p2;
                                                    }
                                                    else {
                                                        if(e0 == null) {
                                                            e0 = new g0.e(new r0.p[16]);
                                                        }
                                                        if(p1 != null) {
                                                            e0.b(p1);
                                                            p1 = null;
                                                        }
                                                        e0.b(p2);
                                                    }
                                                }
                                                p2 = p2.getChild$ui_release();
                                            }
                                            if(v != 1) {
                                                p1 = P0.f.f(e0);
                                            }
                                        }
                                        else {
                                            p1 = P0.f.f(e0);
                                        }
                                    }
                                }
                                p0 = p0.getParent$ui_release();
                            }
                        }
                        i0 = i0.u();
                        if(i0 != null) {
                            P0.d0 d00 = i0.b0;
                            if(d00 != null) {
                                p0 = (A0)d00.e;
                                continue;
                            }
                        }
                        p0 = null;
                    }
                    m0 = (L0.a)p1;
                }
                if(m0 != null) {
                    if(!((r0.p)m0).getNode().isAttached()) {
                        M0.a.b("visitAncestors called on an unattached node");
                    }
                    r0.p p3 = ((r0.p)m0).getNode().getParent$ui_release();
                    I i1 = P0.f.v(m0);
                    Collection collection0 = null;
                    while(i1 != null) {
                        if((((r0.p)i1.b0.f).getAggregateChildKindSet$ui_release() & 0x4000) != 0) {
                            while(p3 != null) {
                                if((p3.getKindSet$ui_release() & 0x4000) != 0) {
                                    r0.p p4 = p3;
                                    g0.e e1 = null;
                                    while(p4 != null) {
                                        if(p4 instanceof L0.a) {
                                            if(collection0 == null) {
                                                collection0 = new ArrayList();
                                            }
                                            ((List)collection0).add(p4);
                                        }
                                        else if((p4.getKindSet$ui_release() & 0x4000) != 0 && p4 instanceof P0.n) {
                                            r0.p p5 = ((P0.n)p4).b;
                                            int v1 = 0;
                                            while(p5 != null) {
                                                if((p5.getKindSet$ui_release() & 0x4000) != 0) {
                                                    ++v1;
                                                    if(v1 == 1) {
                                                        p4 = p5;
                                                    }
                                                    else {
                                                        if(e1 == null) {
                                                            e1 = new g0.e(new r0.p[16]);
                                                        }
                                                        if(p4 != null) {
                                                            e1.b(p4);
                                                            p4 = null;
                                                        }
                                                        e1.b(p5);
                                                    }
                                                }
                                                p5 = p5.getChild$ui_release();
                                            }
                                            if(v1 != 1) {
                                                goto label_107;
                                            }
                                            continue;
                                        }
                                    label_107:
                                        p4 = P0.f.f(e1);
                                    }
                                }
                                p3 = p3.getParent$ui_release();
                            }
                        }
                        i1 = i1.u();
                        if(i1 != null) {
                            P0.d0 d01 = i1.b0;
                            if(d01 != null) {
                                p3 = (A0)d01.e;
                                continue;
                            }
                        }
                        p3 = null;
                    }
                    if(collection0 != null) {
                        int v2 = collection0.size() - 1;
                        if(v2 >= 0) {
                            while(true) {
                                ((L0.a)((List)collection0).get(v2)).getClass();
                                if(v2 - 1 < 0) {
                                    break;
                                }
                                --v2;
                            }
                        }
                    }
                    r0.p p6 = ((r0.p)m0).getNode();
                    g0.e e2 = null;
                    while(p6 != null) {
                        if(p6 instanceof L0.a) {
                            L0.a a0 = (L0.a)p6;
                        }
                        else if((p6.getKindSet$ui_release() & 0x4000) != 0 && p6 instanceof P0.n) {
                            r0.p p7 = ((P0.n)p6).b;
                            int v3 = 0;
                            while(p7 != null) {
                                if((p7.getKindSet$ui_release() & 0x4000) != 0) {
                                    ++v3;
                                    if(v3 == 1) {
                                        p6 = p7;
                                    }
                                    else {
                                        if(e2 == null) {
                                            e2 = new g0.e(new r0.p[16]);
                                        }
                                        if(p6 != null) {
                                            e2.b(p6);
                                            p6 = null;
                                        }
                                        e2.b(p7);
                                    }
                                }
                                p7 = p7.getChild$ui_release();
                            }
                            if(v3 != 1) {
                                goto label_150;
                            }
                            continue;
                        }
                    label_150:
                        p6 = P0.f.f(e2);
                    }
                    if(((Boolean)g0.invoke()).booleanValue()) {
                        return true;
                    }
                    r0.p p8 = ((r0.p)m0).getNode();
                    g0.e e3 = null;
                    while(p8 != null) {
                        if(p8 instanceof L0.a) {
                            L0.a a1 = (L0.a)p8;
                        }
                        else if((p8.getKindSet$ui_release() & 0x4000) != 0 && p8 instanceof P0.n) {
                            r0.p p9 = ((P0.n)p8).b;
                            int v4 = 0;
                            while(p9 != null) {
                                if((p9.getKindSet$ui_release() & 0x4000) != 0) {
                                    ++v4;
                                    if(v4 == 1) {
                                        p8 = p9;
                                    }
                                    else {
                                        if(e3 == null) {
                                            e3 = new g0.e(new r0.p[16]);
                                        }
                                        if(p8 != null) {
                                            e3.b(p8);
                                            p8 = null;
                                        }
                                        e3.b(p9);
                                    }
                                }
                                p9 = p9.getChild$ui_release();
                            }
                            if(v4 != 1) {
                                goto label_177;
                            }
                            continue;
                        }
                    label_177:
                        p8 = P0.f.f(e3);
                    }
                    if(collection0 != null) {
                        int v5 = collection0.size();
                        for(int v6 = 0; v6 < v5; ++v6) {
                            L0.a a2 = (L0.a)((List)collection0).get(v6);
                        }
                        return false;
                    }
                }
                return false;
            }
            return (this.m(motionEvent0) & 1) != 0;
        }
        return super.dispatchGenericMotionEvent(motionEvent0);
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchHoverEvent(MotionEvent motionEvent0) {
        int v5;
        l l0 = this.S0;
        if(this.T0) {
            this.removeCallbacks(l0);
            l0.run();
        }
        if(!u.p(motionEvent0) && this.isAttachedToWindow()) {
            C c0 = this.r;
            u u0 = c0.a;
            if(c0.d.isEnabled() && c0.d.isTouchExplorationEnabled()) {
                int v = motionEvent0.getAction();
                if(v == 7) {
                label_20:
                    float f = motionEvent0.getX();
                    float f1 = motionEvent0.getY();
                    u0.u(true);
                    P0.t t0 = new P0.t();
                    I i0 = u0.getRoot();
                    long v2 = ((j0)i0.b0.d).N0(((long)Float.floatToRawIntBits(f)) << 0x20 | ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL);
                    ((j0)i0.b0.d).W0(j0.g0, v2, t0, 1, true);
                    int v3 = e.k.s(t0);
                    while(true) {
                        if(-1 < v3) {
                            Object object0 = t0.a.e(v3);
                            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
                            I i1 = P0.f.v(((r0.p)object0));
                            if(((u1.i)u0.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(i1)) == null) {
                                if(i1.b0.e(8)) {
                                    int v4 = c0.q(i1.b);
                                    X0.p p0 = com.google.firebase.b.n(i1, false);
                                    if(N.p(p0) && !p0.i().a.c(X0.s.x)) {
                                        v5 = v4;
                                        break;
                                    }
                                }
                                --v3;
                                continue;
                            }
                        }
                        v5 = 0x80000000;
                        break;
                    }
                    u0.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent0);
                    int v6 = c0.b;
                    if(v6 != v5) {
                        c0.b = v5;
                        C.u(c0, v5, 0x80, null, 12);
                        C.u(c0, v6, 0x100, null, 12);
                    }
                }
                else {
                    switch(v) {
                        case 9: {
                            goto label_20;
                        }
                        case 10: {
                            int v1 = c0.b;
                            if(v1 == 0x80000000) {
                                u0.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent0);
                            }
                            else {
                                c0.b = 0x80000000;
                                C.u(c0, 0x80000000, 0x80, null, 12);
                                C.u(c0, v1, 0x100, null, 12);
                            }
                        }
                    }
                }
            }
            switch(motionEvent0.getActionMasked()) {
                case 7: {
                    return this.r(motionEvent0) ? (this.m(motionEvent0) & 1) != 0 : false;
                }
                case 10: {
                    if(!this.q(motionEvent0)) {
                        return (this.m(motionEvent0) & 1) != 0;
                    }
                    else if(motionEvent0.getToolType(0) != 3 || motionEvent0.getButtonState() == 0) {
                        MotionEvent motionEvent1 = this.N0;
                        if(motionEvent1 != null) {
                            motionEvent1.recycle();
                        }
                        this.N0 = MotionEvent.obtainNoHistory(motionEvent0);
                        this.T0 = true;
                        this.postDelayed(l0, 8L);
                        return false;
                    }
                    break;
                }
                default: {
                    return (this.m(motionEvent0) & 1) != 0;
                }
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(this.isFocused()) {
            int v = keyEvent0.getMetaState();
            this.h.getClass();
            J0.E e0 = new J0.E(v);
            ((O0)f1.a).setValue(e0);
            return ((w0.k)this.getFocusOwner()).d(keyEvent0, w0.i.f) || super.dispatchKeyEvent(keyEvent0);
        }
        return ((w0.k)this.getFocusOwner()).d(keyEvent0, new G.g(10, this, keyEvent0));
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent0) {
        P0.m m0;
        r0.p p1;
        if(this.isFocused()) {
            w0.k k0 = (w0.k)this.getFocusOwner();
            if(k0.g.f) {
                System.out.println("FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
                return super.dispatchKeyEventPreIme(keyEvent0);
            }
            w0.u u0 = w0.f.g(k0.f);
            if(u0 == null) {
                m0 = null;
            }
            else {
                if(!u0.getNode().isAttached()) {
                    M0.a.b("visitAncestors called on an unattached node");
                }
                r0.p p0 = u0.getNode();
                I i0 = P0.f.v(u0);
            alab1:
                while(true) {
                    p1 = null;
                    if(i0 == null) {
                        break;
                    }
                    if((((r0.p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x20000) != 0) {
                        while(p0 != null) {
                            if((p0.getKindSet$ui_release() & 0x20000) != 0) {
                                g0.e e0 = null;
                                p1 = p0;
                                while(p1 != null) {
                                    if(p1 instanceof H0.a) {
                                        break alab1;
                                    }
                                    if((p1.getKindSet$ui_release() & 0x20000) != 0 && p1 instanceof P0.n) {
                                        r0.p p2 = ((P0.n)p1).b;
                                        int v = 0;
                                        while(p2 != null) {
                                            if((p2.getKindSet$ui_release() & 0x20000) != 0) {
                                                ++v;
                                                if(v == 1) {
                                                    p1 = p2;
                                                }
                                                else {
                                                    if(e0 == null) {
                                                        e0 = new g0.e(new r0.p[16]);
                                                    }
                                                    if(p1 != null) {
                                                        e0.b(p1);
                                                        p1 = null;
                                                    }
                                                    e0.b(p2);
                                                }
                                            }
                                            p2 = p2.getChild$ui_release();
                                        }
                                        if(v != 1) {
                                            p1 = P0.f.f(e0);
                                        }
                                    }
                                    else {
                                        p1 = P0.f.f(e0);
                                    }
                                }
                            }
                            p0 = p0.getParent$ui_release();
                        }
                    }
                    i0 = i0.u();
                    if(i0 != null) {
                        P0.d0 d00 = i0.b0;
                        if(d00 != null) {
                            p0 = (A0)d00.e;
                            continue;
                        }
                    }
                    p0 = null;
                }
                m0 = (H0.a)p1;
            }
            if(m0 != null) {
                if(!((r0.p)m0).getNode().isAttached()) {
                    M0.a.b("visitAncestors called on an unattached node");
                }
                r0.p p3 = ((r0.p)m0).getNode().getParent$ui_release();
                I i1 = P0.f.v(m0);
                Collection collection0 = null;
                while(i1 != null) {
                    if((((r0.p)i1.b0.f).getAggregateChildKindSet$ui_release() & 0x20000) != 0) {
                        while(p3 != null) {
                            if((p3.getKindSet$ui_release() & 0x20000) != 0) {
                                r0.p p4 = p3;
                                g0.e e1 = null;
                                while(p4 != null) {
                                    if(p4 instanceof H0.a) {
                                        if(collection0 == null) {
                                            collection0 = new ArrayList();
                                        }
                                        ((List)collection0).add(p4);
                                    }
                                    else if((p4.getKindSet$ui_release() & 0x20000) != 0 && p4 instanceof P0.n) {
                                        r0.p p5 = ((P0.n)p4).b;
                                        int v1 = 0;
                                        while(p5 != null) {
                                            if((p5.getKindSet$ui_release() & 0x20000) != 0) {
                                                ++v1;
                                                if(v1 == 1) {
                                                    p4 = p5;
                                                }
                                                else {
                                                    if(e1 == null) {
                                                        e1 = new g0.e(new r0.p[16]);
                                                    }
                                                    if(p4 != null) {
                                                        e1.b(p4);
                                                        p4 = null;
                                                    }
                                                    e1.b(p5);
                                                }
                                            }
                                            p5 = p5.getChild$ui_release();
                                        }
                                        if(v1 != 1) {
                                            goto label_90;
                                        }
                                        continue;
                                    }
                                label_90:
                                    p4 = P0.f.f(e1);
                                }
                            }
                            p3 = p3.getParent$ui_release();
                        }
                    }
                    i1 = i1.u();
                    if(i1 != null) {
                        P0.d0 d01 = i1.b0;
                        if(d01 != null) {
                            p3 = (A0)d01.e;
                            continue;
                        }
                    }
                    p3 = null;
                }
                if(collection0 != null) {
                    int v2 = collection0.size() - 1;
                    if(v2 >= 0) {
                        while(true) {
                            ((H0.a)((List)collection0).get(v2)).getClass();
                            if(v2 - 1 < 0) {
                                break;
                            }
                            --v2;
                        }
                    }
                }
                r0.p p6 = ((r0.p)m0).getNode();
                g0.e e2 = null;
                while(p6 != null) {
                    if(p6 instanceof H0.a) {
                        H0.a a0 = (H0.a)p6;
                    }
                    else if((p6.getKindSet$ui_release() & 0x20000) != 0 && p6 instanceof P0.n) {
                        r0.p p7 = ((P0.n)p6).b;
                        int v3 = 0;
                        while(p7 != null) {
                            if((p7.getKindSet$ui_release() & 0x20000) != 0) {
                                ++v3;
                                if(v3 == 1) {
                                    p6 = p7;
                                }
                                else {
                                    if(e2 == null) {
                                        e2 = new g0.e(new r0.p[16]);
                                    }
                                    if(p6 != null) {
                                        e2.b(p6);
                                        p6 = null;
                                    }
                                    e2.b(p7);
                                }
                            }
                            p7 = p7.getChild$ui_release();
                        }
                        if(v3 != 1) {
                            goto label_133;
                        }
                        continue;
                    }
                label_133:
                    p6 = P0.f.f(e2);
                }
                r0.p p8 = ((r0.p)m0).getNode();
                g0.e e3 = null;
                while(p8 != null) {
                    if(p8 instanceof H0.a) {
                        we.k k1 = ((H0.a)p8).a;
                        if((k1 == null ? false : ((Boolean)k1.invoke(new H0.d(keyEvent0))).booleanValue())) {
                            return true;
                        }
                    }
                    else if((p8.getKindSet$ui_release() & 0x20000) != 0 && p8 instanceof P0.n) {
                        r0.p p9 = ((P0.n)p8).b;
                        int v4 = 0;
                        while(p9 != null) {
                            if((p9.getKindSet$ui_release() & 0x20000) != 0) {
                                ++v4;
                                if(v4 == 1) {
                                    p8 = p9;
                                }
                                else {
                                    if(e3 == null) {
                                        e3 = new g0.e(new r0.p[16]);
                                    }
                                    if(p8 != null) {
                                        e3.b(p8);
                                        p8 = null;
                                    }
                                    e3.b(p9);
                                }
                            }
                            p9 = p9.getChild$ui_release();
                        }
                        if(v4 != 1) {
                            goto label_160;
                        }
                        continue;
                    }
                label_160:
                    p8 = P0.f.f(e3);
                }
                if(collection0 != null) {
                    int v5 = collection0.size();
                    int v6 = 0;
                    while(v6 < v5) {
                        we.k k2 = ((H0.a)((List)collection0).get(v6)).a;
                        if(!(k2 == null ? false : ((Boolean)k2.invoke(new H0.d(keyEvent0))).booleanValue())) {
                            ++v6;
                            continue;
                        }
                        return true;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent0);
    }

    @Override  // android.view.ViewGroup
    public final void dispatchProvideStructure(ViewStructure viewStructure0) {
        if(Build.VERSION.SDK_INT < 28) {
            Q0.G.a.a(viewStructure0, this);
            return;
        }
        super.dispatchProvideStructure(viewStructure0);
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        if(this.T0) {
            l l0 = this.S0;
            this.removeCallbacks(l0);
            MotionEvent motionEvent1 = this.N0;
            kotlin.jvm.internal.q.d(motionEvent1);
            if(motionEvent0.getActionMasked() != 0 || motionEvent1.getSource() != motionEvent0.getSource() || motionEvent1.getToolType(0) != motionEvent0.getToolType(0)) {
                l0.run();
            }
            else {
                this.T0 = false;
            }
        }
        if(!u.p(motionEvent0) && this.isAttachedToWindow() && (motionEvent0.getActionMasked() != 2 || this.r(motionEvent0))) {
            int v = this.m(motionEvent0);
            if((v & 2) != 0) {
                this.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return (v & 1) != 0;
        }
        return false;
    }

    @Nullable
    public final View findViewByAccessibilityIdTraversal(int v) {
        try {
            if(Build.VERSION.SDK_INT < 29) {
                return u.k(this, v);
            }
            Method method0 = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            method0.setAccessible(true);
            Object object0 = method0.invoke(this, v);
            return object0 instanceof View ? ((View)object0) : null;
        }
        catch(NoSuchMethodException unused_ex) {
        }
        return null;
    }

    @Override  // android.view.ViewGroup
    public final View focusSearch(View view0, int v) {
        x0.c c0;
        if(view0 != null && !this.l0.c) {
            View view1 = FocusFinder.getInstance().findNextFocus(this, view0, v);
            if(view0 == this) {
                w0.u u0 = w0.f.g(((w0.k)this.getFocusOwner()).f);
                c0 = u0 == null ? null : w0.f.j(u0);
                if(c0 == null) {
                    c0 = w0.f.d(view0, this);
                }
            }
            else {
                c0 = w0.f.d(view0, this);
            }
            w0.d d0 = w0.f.E(v);
            int v1 = d0 == null ? 6 : d0.a;
            kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
            if(((w0.k)this.getFocusOwner()).e(v1, c0, new I0.h(4, h0)) != null) {
                Object object0 = h0.a;
                if(object0 == null) {
                    return view1 == null ? view0 : view1;
                }
                if(view1 != null) {
                    if(v1 == 1 || v1 == 2) {
                        return super.focusSearch(view0, v);
                    }
                    kotlin.jvm.internal.q.d(object0);
                    if(!w0.f.p(w0.f.j(((w0.u)object0)), w0.f.d(view1, this), c0, v1)) {
                        return view1;
                    }
                }
                return this;
            }
            return view0;
        }
        return super.focusSearch(view0, v);
    }

    public static final boolean g(u u0, w0.d d0, x0.c c0) {
        if(!u0.isFocused() && !u0.hasFocus()) {
            if(d0 != null) {
                Integer integer0 = w0.f.D(d0.a);
                if(integer0 != null) {
                    int v = (int)integer0;
                    return c0 == null ? u0.super.requestFocus(v, null) : u0.super.requestFocus(v, y0.M.w(c0));
                }
            }
            return c0 == null ? u0.super.requestFocus(130, null) : u0.super.requestFocus(130, y0.M.w(c0));
        }
        return true;
    }

    public Q0.f getAccessibilityManager() {
        return this.getAccessibilityManager();
    }

    @NotNull
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.B;
    }

    @NotNull
    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if(this.h0 == null) {
            AndroidViewsHandler androidViewsHandler0 = new AndroidViewsHandler(this.getContext());
            this.h0 = androidViewsHandler0;
            this.addView(androidViewsHandler0, -1);
            this.requestLayout();
        }
        AndroidViewsHandler androidViewsHandler1 = this.h0;
        kotlin.jvm.internal.q.d(androidViewsHandler1);
        return androidViewsHandler1;
    }

    @Nullable
    public s0.g getAutofill() {
        return this.W;
    }

    @Nullable
    public s0.i getAutofillManager() {
        return this.b0;
    }

    @NotNull
    public k getAutofillTree() {
        return this.E;
    }

    public h0 getClipboard() {
        return this.getClipboard();
    }

    @NotNull
    public AndroidClipboard getClipboard() {
        return this.e0;
    }

    public i0 getClipboardManager() {
        return this.getClipboardManager();
    }

    @NotNull
    public AndroidClipboardManager getClipboardManager() {
        return this.d0;
    }

    @NotNull
    public final we.k getConfigurationChangeObserver() {
        return this.V;
    }

    @NotNull
    public final t0.d getContentCaptureManager$ui_release() {
        return this.w;
    }

    @NotNull
    public me.i getCoroutineContext() {
        return this.f;
    }

    @NotNull
    public r1.c getDensity() {
        return (r1.c)((O0)this.d).getValue();
    }

    @NotNull
    public u0.a getDragAndDropManager() {
        return this.g;
    }

    public u0.c getDragAndDropManager() {
        return this.getDragAndDropManager();
    }

    @NotNull
    public w0.j getFocusOwner() {
        return this.e;
    }

    @Override  // android.view.View
    public final void getFocusedRect(Rect rect0) {
        x0.c c0 = this.y();
        if(c0 != null) {
            rect0.left = Math.round(c0.a);
            rect0.top = Math.round(c0.b);
            rect0.right = Math.round(c0.c);
            rect0.bottom = Math.round(c0.d);
            return;
        }
        if(!kotlin.jvm.internal.q.b(((w0.k)this.getFocusOwner()).e(6, null, Q0.l.h), Boolean.TRUE)) {
            rect0.set(0x80000000, 0x80000000, 0x80000000, 0x80000000);
            return;
        }
        super.getFocusedRect(rect0);
    }

    @NotNull
    public e1.i getFontFamilyResolver() {
        return (e1.i)((O0)this.G0).getValue();
    }

    @NotNull
    public e1.h getFontLoader() {
        return this.F0;
    }

    @ie.d
    public static void getFontLoader$annotations() {
    }

    @NotNull
    public y0.z getGraphicsContext() {
        return this.D;
    }

    @NotNull
    public F0.a getHapticFeedBack() {
        return this.J0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.l0.b.n();
    }

    @Override  // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    @NotNull
    public G0.b getInputModeManager() {
        return this.K0;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.r0;
    }

    public static void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    @NotNull
    public m getLayoutDirection() {
        return (m)((O0)this.I0).getValue();
    }

    public androidx.collection.m getLayoutNodes() {
        return this.getLayoutNodes();
    }

    @NotNull
    public z getLayoutNodes() {
        return this.l;
    }

    public long getMeasureIteration() {
        X x0 = this.l0;
        if(!x0.c) {
            M0.a.a("measureIteration should be only used during the measure/layout pass");
        }
        return x0.g;
    }

    @NotNull
    public O0.c getModifierLocalManager() {
        return this.L0;
    }

    @NotNull
    public Z getPlacementScope() {
        return new J(this, 1);
    }

    @NotNull
    public J0.t getPointerIconService() {
        return this.Y0;
    }

    @NotNull
    public Y0.a getRectManager() {
        return this.m;
    }

    @NotNull
    public I getRoot() {
        return this.k;
    }

    @NotNull
    public P0.y0 getRootForTest() {
        return this.n;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return this.X0 == null ? false : ((Boolean)((O0)(((b0)this.X0.a))).getValue()).booleanValue();
        }
        return false;
    }

    @NotNull
    public X0.q getSemanticsOwner() {
        return this.o;
    }

    @NotNull
    public K getSharedDrawScope() {
        return this.c;
    }

    public boolean getShowLayoutBounds() {
        return this.g0;
    }

    public static void getShowLayoutBounds$annotations() {
    }

    @NotNull
    public t0 getSnapshotObserver() {
        return this.f0;
    }

    @NotNull
    public R0 getSoftwareKeyboardController() {
        return this.E0;
    }

    @NotNull
    public y getTextInputService() {
        return this.C0;
    }

    @ie.d
    public static void getTextInputService$annotations() {
    }

    @NotNull
    public T0 getTextToolbar() {
        return this.M0;
    }

    @NotNull
    public View getView() [...] // Inlined contents

    @NotNull
    public b1 getViewConfiguration() {
        return this.j;
    }

    @Nullable
    public final Q0.j getViewTreeOwners() {
        return (Q0.j)this.w0.getValue();
    }

    @NotNull
    public e1 getWindowInfo() {
        return this.h;
    }

    @Nullable
    public final s0.c get_autofillManager$ui_release() {
        return this.b0;
    }

    private final Q0.j get_viewTreeOwners() {
        return (Q0.j)((O0)this.v0).getValue();
    }

    public static void i(ViewGroup viewGroup0) {
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            if(view0 instanceof u) {
                ((u)view0).x();
            }
            else if(view0 instanceof ViewGroup) {
                u.i(((ViewGroup)view0));
            }
        }
    }

    public static long j(int v) {
        int v1 = View.MeasureSpec.getMode(v);
        int v2 = View.MeasureSpec.getSize(v);
        switch(v1) {
            case 0x80000000: {
                return (long)v2;
            }
            case 0: {
                return 0x7FFFFFFFL;
            }
            default: {
                if(v1 != 0x40000000) {
                    throw new IllegalStateException();
                }
                return ((long)v2) | ((long)v2) << 0x20;
            }
        }
    }

    public static View k(View view0, int v) {
        if(Build.VERSION.SDK_INT < 29) {
            Method method0 = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            method0.setAccessible(true);
            if(kotlin.jvm.internal.q.b(method0.invoke(view0, null), v)) {
                return view0;
            }
            if(view0 instanceof ViewGroup) {
                int v1 = ((ViewGroup)view0).getChildCount();
                for(int v2 = 0; v2 < v1; ++v2) {
                    View view1 = u.k(((ViewGroup)view0).getChildAt(v2), v);
                    if(view1 != null) {
                        return view1;
                    }
                }
            }
        }
        return null;
    }

    public final void l(I i0, boolean z) {
        this.l0.f(i0, z);
    }

    public final int m(MotionEvent motionEvent0) {
        int v4;
        MotionEvent motionEvent2;
        this.removeCallbacks(this.R0);
        try {
            this.E(motionEvent0);
            this.s0 = true;
            this.u(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int v1 = motionEvent0.getActionMasked();
                MotionEvent motionEvent1 = this.N0;
                boolean z = motionEvent1 == null || motionEvent1.getToolType(0) != 3 ? false : true;
                a a0 = this.T;
                if(motionEvent1 == null) {
                    motionEvent2 = null;
                }
                else if(motionEvent1.getSource() == motionEvent0.getSource() && motionEvent1.getToolType(0) == motionEvent0.getToolType(0)) {
                    motionEvent2 = motionEvent1;
                }
                else if(motionEvent1.getButtonState() == 0) {
                    switch(motionEvent1.getActionMasked()) {
                        case 0: 
                        case 2: 
                        case 6: {
                            motionEvent2 = motionEvent1;
                            goto label_26;
                        }
                        default: {
                            if(motionEvent1.getActionMasked() != 10 && z) {
                                this.J(motionEvent1, 10, motionEvent1.getEventTime(), true);
                            }
                            motionEvent2 = motionEvent1;
                        }
                    }
                }
                else {
                    motionEvent2 = motionEvent1;
                label_26:
                    if(!a0.a) {
                        ((androidx.collection.s)((I7.c)a0.d).b).a();
                        ((J0.d)a0.c).f();
                    }
                }
                if(!z && motionEvent0.getToolType(0) == 3 && (v1 != 3 && v1 != 9) && this.q(motionEvent0)) {
                    this.J(motionEvent0, 9, motionEvent0.getEventTime(), true);
                }
                if(motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if(this.N0 != null && this.N0.getAction() == 10) {
                    int v2 = this.N0 == null ? -1 : this.N0.getPointerId(0);
                    int v3 = motionEvent0.getAction();
                    j j0 = this.S;
                    if(v3 != 9 || motionEvent0.getHistorySize() != 0) {
                        if(motionEvent0.getAction() == 0 && motionEvent0.getHistorySize() == 0) {
                            float f = NaNf;
                            float f1 = this.N0 == null ? NaNf : this.N0.getX();
                            MotionEvent motionEvent3 = this.N0;
                            if(motionEvent3 != null) {
                                f = motionEvent3.getY();
                            }
                            if(f1 != motionEvent0.getX() || f != motionEvent0.getY() || (this.N0 == null ? -1L : this.N0.getEventTime()) != motionEvent0.getEventTime()) {
                                if(v2 >= 0) {
                                    j0.c.delete(v2);
                                    j0.b.delete(v2);
                                }
                                J0.d d0 = (J0.d)a0.c;
                                if(d0.c) {
                                    d0.c = true;
                                }
                                else {
                                    ((J0.l)d0.g).a.g();
                                }
                            }
                        }
                    }
                    else if(v2 >= 0) {
                        j0.c.delete(v2);
                        j0.b.delete(v2);
                    }
                }
                this.N0 = MotionEvent.obtainNoHistory(motionEvent0);
                v4 = this.I(motionEvent0);
            }
            finally {
                Trace.endSection();
            }
            this.s0 = false;
            return v4;
        }
        catch(Throwable throwable0) {
            this.s0 = false;
            throw throwable0;
        }
    }

    public static void n(I i0) {
        i0.C();
        g0.e e0 = i0.y();
        Object[] arr_object = e0.a;
        int v = e0.c;
        for(int v1 = 0; v1 < v; ++v1) {
            u.n(((I)arr_object[v1]));
        }
    }

    public final void o(I i0) {
        this.l0.p(i0, false);
        g0.e e0 = i0.y();
        Object[] arr_object = e0.a;
        int v1 = e0.c;
        for(int v = 0; v < v1; ++v) {
            this.o(((I)arr_object[v]));
        }
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean boolean0 = Boolean.valueOf(this.hasWindowFocus());
        ((O0)this.h.a).setValue(boolean0);
        this.h.getClass();
        this.o(this.getRoot());
        u.n(this.getRoot());
        this.getSnapshotObserver().a.d();
        s0.a a0 = this.W;
        if(a0 != null) {
            s0.h.a.getClass();
            a0.c.registerCallback(s0.h.a);
        }
        D d0 = androidx.lifecycle.f0.d(this);
        E4.g g0 = a.a.v(this);
        Q0.j j0 = this.getViewTreeOwners();
        androidx.lifecycle.t t0 = null;
        if(j0 == null || d0 != null && g0 != null && (d0 != j0.a || g0 != j0.a)) {
            if(d0 == null) {
                throw new IllegalStateException("Composed into the View which doesn\'t propagate ViewTreeLifecycleOwner!");
            }
            if(g0 == null) {
                throw new IllegalStateException("Composed into the View which doesn\'t propagateViewTreeSavedStateRegistryOwner!");
            }
            if(j0 != null) {
                androidx.lifecycle.t t1 = j0.a.getLifecycle();
                if(t1 != null) {
                    t1.c(this);
                }
            }
            d0.getLifecycle().a(this);
            Q0.j j1 = new Q0.j(d0, g0);
            this.set_viewTreeOwners(j1);
            we.k k0 = this.x0;
            if(k0 != null) {
                k0.invoke(j1);
            }
            this.x0 = null;
        }
        G0.a a1 = new G0.a((this.isInTouchMode() ? 1 : 2));
        ((O0)this.K0.a).setValue(a1);
        Q0.j j2 = this.getViewTreeOwners();
        if(j2 != null) {
            t0 = j2.a.getLifecycle();
        }
        if(t0 == null) {
            throw Y.d("No lifecycle owner exists");
        }
        t0.a(this);
        t0.a(this.w);
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.y0);
        this.getViewTreeObserver().addOnScrollChangedListener(this.z0);
        this.getViewTreeObserver().addOnTouchModeChangeListener(this.A0);
        if(Build.VERSION.SDK_INT >= 0x1F) {
            Q0.K.a.b(this);
        }
        s0.c c0 = this.b0;
        if(c0 != null) {
            ((w0.k)this.getFocusOwner()).k.a(c0);
            this.getSemanticsOwner().d.a(c0);
        }
    }

    @Override  // android.view.View
    public final boolean onCheckIsTextEditor() {
        r0.s s0 = (r0.s)this.D0.get();
        Object object0 = null;
        Object object1 = s0 == null ? null : s0.b;
        if(((Q0.V)object1) == null) {
            return this.B0.d;
        }
        r0.s s1 = (r0.s)((Q0.V)object1).d.get();
        if(s1 != null) {
            object0 = s1.b;
        }
        return ((u0)object0) != null && !((u0)object0).e == 1;
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.setDensity(de.c.c(this.getContext()));
        this.h.getClass();
        int v = Build.VERSION.SDK_INT;
        int v1 = 0;
        if((v < 0x1F ? 0 : configuration0.fontWeightAdjustment) != this.H0) {
            if(v >= 0x1F) {
                v1 = configuration0.fontWeightAdjustment;
            }
            this.H0 = v1;
            this.setFontFamilyResolver(e1.m.m(this.getContext()));
        }
        this.V.invoke(configuration0);
    }

    @Override  // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        int v;
        r0.s s0 = (r0.s)this.D0.get();
        Object object0 = s0 == null ? null : s0.b;
        if(((Q0.V)object0) == null) {
            A a0 = this.B0;
            if(a0.d) {
                f1.j j0 = a0.h;
                f1.x x0 = a0.g;
                boolean z = j0.a;
                switch(j0.e) {
                    case 0: {
                        v = 1;
                        break;
                    }
                    case 2: {
                        v = 2;
                        break;
                    }
                    case 3: {
                        v = 3;
                        break;
                    }
                    case 4: {
                        v = 4;
                        break;
                    }
                    case 5: {
                        v = 7;
                        break;
                    }
                    case 6: {
                        v = 5;
                        break;
                    }
                    case 7: {
                        v = 6;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("invalid ImeAction");
                    }
                }
                editorInfo0.imeOptions = v;
                switch(j0.d) {
                    case 1: {
                        editorInfo0.inputType = 1;
                        break;
                    }
                    case 2: {
                        editorInfo0.inputType = 1;
                        editorInfo0.imeOptions = 0x80000000 | v;
                        break;
                    }
                    case 3: {
                        editorInfo0.inputType = 2;
                        break;
                    }
                    case 4: {
                        editorInfo0.inputType = 3;
                        break;
                    }
                    case 5: {
                        editorInfo0.inputType = 17;
                        break;
                    }
                    case 6: {
                        editorInfo0.inputType = 33;
                        break;
                    }
                    case 7: {
                        editorInfo0.inputType = 0x81;
                        break;
                    }
                    case 8: {
                        editorInfo0.inputType = 18;
                        break;
                    }
                    case 9: {
                        editorInfo0.inputType = 0x2002;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Invalid Keyboard Type");
                    }
                }
                if(!z) {
                    int v1 = editorInfo0.inputType;
                    if((v1 & 1) == 1) {
                        editorInfo0.inputType = v1 | 0x20000;
                    }
                }
                int v2 = editorInfo0.inputType;
                if((v2 & 1) == 1) {
                    int v3 = j0.b;
                    if(v3 == 1) {
                        editorInfo0.inputType = v2 | 0x1000;
                    }
                    else if(v3 == 2) {
                        editorInfo0.inputType = v2 | 0x2000;
                    }
                    else if(v3 == 3) {
                        editorInfo0.inputType = v2 | 0x4000;
                    }
                    if(j0.c) {
                        editorInfo0.inputType |= 0x8000;
                    }
                }
                editorInfo0.initialSelStart = (int)(x0.b >> 0x20);
                editorInfo0.initialSelEnd = (int)(x0.b & 0xFFFFFFFFL);
                e2.a.P(editorInfo0, x0.a.b);
                editorInfo0.imeOptions |= 0x2000000;
                boolean z1 = a0.h.c;
                InputConnection inputConnection0 = new f1.s(a0.g, new S0(a0, 9), z1);
                WeakReference weakReference0 = new WeakReference(inputConnection0);
                a0.i.add(weakReference0);
                return inputConnection0;
            }
        }
        else {
            r0.s s1 = (r0.s)((Q0.V)object0).d.get();
            Object object1 = s1 == null ? null : s1.b;
            if(((u0)object1) != null) {
                synchronized(((u0)object1).c) {
                    if(((u0)object1).e) {
                        return null;
                    }
                    W.x x1 = ((u0)object1).a.a(editorInfo0);
                    B0.b b0 = new B0.b(((u0)object1), 20);
                    InputConnection inputConnection1 = Build.VERSION.SDK_INT >= 34 ? new f1.n(x1, b0) : new f1.m(x1, b0);  // 初始化器: Lf1/m;-><init>(LW/x;LB0/b;)V
                    G0 g00 = new G0(inputConnection1);  // 初始化器: Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
                    ((u0)object1).d.b(g00);
                    return inputConnection1;
                }
            }
        }
        return null;
    }

    @Override  // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] arr_v, int[] arr_v1, Consumer consumer0) {
        t0.d d0 = this.w;
        d0.getClass();
        for(int v = 0; v < arr_v.length; ++v) {
            long v1 = arr_v[v];
            Q0 q00 = (Q0)d0.d().b(((int)v1));
            if(q00 != null) {
                X0.p p0 = q00.a;
                if(p0 != null) {
                    ViewTranslationRequest.Builder viewTranslationRequest$Builder0 = i3.i.m(d0.a.getAutofillId(), ((long)p0.g));
                    Object object0 = p0.d.a.g(X0.s.y);
                    if(object0 == null) {
                        object0 = null;
                    }
                    if(((List)object0) != null) {
                        String s = t1.a.a(((List)object0), "\n", null, 62);
                        if(s != null) {
                            i3.i.w(viewTranslationRequest$Builder0, TranslationRequestValue.forText(new a1.g(s)));
                            consumer0.accept(viewTranslationRequest$Builder0.build());
                        }
                    }
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p0.s s0 = this.getSnapshotObserver().a;
        j3.n n0 = s0.h;
        if(n0 != null) {
            n0.d();
        }
        s0.b();
        this.h.getClass();
        Q0.j j0 = this.getViewTreeOwners();
        androidx.lifecycle.t t0 = j0 == null ? null : j0.a.getLifecycle();
        if(t0 == null) {
            throw Y.d("No lifecycle owner exists");
        }
        t0.c(this.w);
        t0.c(this);
        s0.a a0 = this.W;
        if(a0 != null) {
            s0.h.a.getClass();
            a0.c.unregisterCallback(s0.h.a);
        }
        this.getViewTreeObserver().removeOnGlobalLayoutListener(this.y0);
        this.getViewTreeObserver().removeOnScrollChangedListener(this.z0);
        this.getViewTreeObserver().removeOnTouchModeChangeListener(this.A0);
        if(Build.VERSION.SDK_INT >= 0x1F) {
            Q0.K.a.a(this);
        }
        s0.c c0 = this.b0;
        if(c0 != null) {
            this.getSemanticsOwner().d.h(c0);
            ((w0.k)this.getFocusOwner()).k.h(c0);
        }
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
    }

    @Override  // android.view.View
    public final void onFocusChanged(boolean z, int v, Rect rect0) {
        super.onFocusChanged(z, v, rect0);
        if(!z && !this.hasFocus()) {
            w0.f.e(((w0.k)this.getFocusOwner()).f, true);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        this.r0 = 0L;
        this.l0.j(this.U0);
        this.j0 = null;
        this.L();
        if(this.h0 != null) {
            this.getAndroidViewsHandler$ui_release().layout(0, 0, v2 - v, v3 - v1);
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        X x0 = this.l0;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if(!this.isAttachedToWindow()) {
                this.o(this.getRoot());
            }
            long v3 = u.j(v);
            long v4 = u.j(v1);
            long v5 = df.d.q(((int)(v3 >>> 0x20)), ((int)(v3 & 0xFFFFFFFFL)), ((int)(v4 >>> 0x20)), ((int)(0xFFFFFFFFL & v4)));
            r1.a a0 = this.j0;
            if(a0 == null) {
                this.j0 = new r1.a(v5);
                this.k0 = false;
            }
            else if(!r1.a.b(a0.a, v5)) {
                this.k0 = true;
            }
            x0.q(v5);
            x0.l();
            this.setMeasuredDimension(this.getRoot().c0.p.a, this.getRoot().c0.p.b);
            if(this.h0 != null) {
                this.getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(this.getRoot().c0.p.a, 0x40000000), View.MeasureSpec.makeMeasureSpec(this.getRoot().c0.p.b, 0x40000000));
            }
        }
        finally {
            Trace.endSection();
        }
    }

    @Override  // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure0, int v) {
        if(viewStructure0 != null) {
            s0.c c0 = this.b0;
            if(c0 != null) {
                AutofillId autofillId0 = c0.g;
                String s = c0.e;
                Y0.a a0 = c0.d;
                df.v.G(viewStructure0, c0.b.a, autofillId0, s, a0);
                G g0 = new G(2);
                g0.a(c0.b.a);
                g0.a(viewStructure0);
                int v1;
                while((v1 = g0.b) != 0) {
                    Object object0 = g0.i(v1 - 1);
                    kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type android.view.ViewStructure");
                    ViewStructure viewStructure1 = (ViewStructure)object0;
                    Object object1 = g0.i(g0.b - 1);
                    kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
                    List list0 = ((I)object1).o();
                    int v2 = list0.size();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        I i0 = (I)((g0.b)list0).get(v3);
                        if(!i0.l0 && i0.H() && i0.I()) {
                            X0.l l0 = i0.w();
                            if(l0 == null || !l0.a.b(X0.k.g) && !l0.a.b(X0.s.p) && !l0.a.b(X0.s.q)) {
                                g0.a(i0);
                                g0.a(viewStructure1);
                            }
                            else {
                                ViewStructure viewStructure2 = viewStructure1.newChild(viewStructure1.addChildCount(1));
                                df.v.G(viewStructure2, i0, autofillId0, s, a0);
                                g0.a(i0);
                                g0.a(viewStructure2);
                            }
                        }
                    }
                }
            }
            s0.a a1 = this.W;
            if(a1 != null) {
                LinkedHashMap linkedHashMap0 = a1.b.a;
                if(!a1.b.a.isEmpty()) {
                    int v4 = viewStructure0.addChildCount(linkedHashMap0.size());
                    for(Object object2: linkedHashMap0.entrySet()) {
                        int v5 = ((Number)((Map.Entry)object2).getKey()).intValue();
                        s0.j j0 = (s0.j)((Map.Entry)object2).getValue();
                        ViewStructure viewStructure3 = viewStructure0.newChild(v4);
                        viewStructure3.setAutofillId(a1.d, v5);
                        viewStructure3.setId(v5, "com.iloen.melon", null, null);
                        viewStructure3.setAutofillType(1);
                        List list1 = j0.a;
                        ArrayList arrayList0 = new ArrayList(list1.size());
                        int v6 = list1.size();
                        for(int v7 = 0; v7 < v6; ++v7) {
                            s0.l l1 = (s0.l)list1.get(v7);
                            String s1 = (String)s0.d.a.get(l1);
                            if(s1 == null) {
                                throw new IllegalArgumentException("Unsupported autofill type");
                            }
                            arrayList0.add(s1);
                        }
                        viewStructure3.setAutofillHints(((String[])arrayList0.toArray(new String[0])));
                        x0.c c1 = j0.b;
                        if(c1 == null) {
                            Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                        }
                        else {
                            int v8 = Math.round(c1.a);
                            int v9 = Math.round(c1.b);
                            viewStructure3.setDimens(v8, v9, 0, 0, Math.round(c1.c) - v8, Math.round(c1.d) - v9);
                        }
                        ++v4;
                    }
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent0, int v) {
        int v1 = motionEvent0.getToolType(v);
        if(!motionEvent0.isFromSource(0x2002) && motionEvent0.isFromSource(0x4002) && (v1 == 2 || v1 == 4)) {
            J0.s s0 = ((q)this.getPointerIconService()).a;
            if(s0 != null) {
                Context context0 = this.getContext();
                return s0 instanceof J0.a ? PointerIcon.getSystemIcon(context0, ((J0.a)s0).b) : PointerIcon.getSystemIcon(context0, 1000);
            }
        }
        return super.onResolvePointerIcon(motionEvent0, v);
    }

    @Override  // androidx.lifecycle.f
    public final void onResume(D d0) {
        this.setShowLayoutBounds(Q0.t0.a());
    }

    @Override  // android.view.View
    public final void onRtlPropertiesChanged(int v) {
        m m0;
        if(this.b) {
            switch(v) {
                case 0: {
                    m0 = m.a;
                    break;
                }
                case 1: {
                    m0 = m.b;
                    break;
                }
                default: {
                    m0 = null;
                }
            }
            if(m0 == null) {
                m0 = m.a;
            }
            this.setLayoutDirection(m0);
        }
    }

    @Override  // android.view.View
    public final void onScrollCaptureSearch(Rect rect0, Point point0, Consumer consumer0) {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            h h0 = this.X0;
            if(h0 != null) {
                me.i i0 = this.getCoroutineContext();
                g0.e e0 = new g0.e(new W0.j[16]);
                De.I.e0(this.getSemanticsOwner().a(), 0, new Ff.j(1, e0, g0.e.class, "add", "add(Ljava/lang/Object;)Z", 8, 1));
                e0.o(e1.b.q(new we.k[]{W0.d.h, W0.d.i}));
                Object object0 = e0.c == 0 ? null : e0.a[e0.c - 1];
                if(((W0.j)object0) != null) {
                    CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(i0);
                    W0.f f0 = new W0.f(((W0.j)object0).a, ((W0.j)object0).c, coroutineScope0, h0, this);
                    x0.c c0 = g0.g(((W0.j)object0).d).f(((W0.j)object0).d, true);
                    long v = ((W0.j)object0).c.a();
                    ScrollCaptureTarget scrollCaptureTarget0 = B0.t.k(this, y0.M.v(e1.m.B(c0)), new Point(((int)(v >> 0x20)), ((int)(v & 0xFFFFFFFFL))), f0);
                    scrollCaptureTarget0.setScrollBounds(y0.M.v(((W0.j)object0).c));
                    consumer0.accept(scrollCaptureTarget0);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onVirtualViewTranslationResponses(LongSparseArray longSparseArray0) {
        t0.d d0 = this.w;
        d0.getClass();
        if(Build.VERSION.SDK_INT < 0x1F) {
            return;
        }
        if(kotlin.jvm.internal.q.b(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            e1.x.A(d0, longSparseArray0);
            return;
        }
        P3 p30 = new P3(23, d0, longSparseArray0);
        d0.a.post(p30);
    }

    @Override  // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        ((O0)this.h.a).setValue(Boolean.valueOf(z));
        this.W0 = true;
        super.onWindowFocusChanged(z);
        if(z) {
            boolean z1 = Q0.t0.a();
            if(this.getShowLayoutBounds() != z1) {
                this.setShowLayoutBounds(z1);
                u.n(this.getRoot());
            }
        }
    }

    public static boolean p(MotionEvent motionEvent0) {
        boolean z = (Float.floatToRawIntBits(motionEvent0.getX()) & 0x7FFFFFFF) >= 0x7F800000 || (Float.floatToRawIntBits(motionEvent0.getY()) & 0x7FFFFFFF) >= 0x7F800000 || (Float.floatToRawIntBits(motionEvent0.getRawX()) & 0x7FFFFFFF) >= 0x7F800000 || (Float.floatToRawIntBits(motionEvent0.getRawY()) & 0x7FFFFFFF) >= 0x7F800000;
        if(!z) {
            int v = motionEvent0.getPointerCount();
            for(int v1 = 1; v1 < v; ++v1) {
                z = (Float.floatToRawIntBits(motionEvent0.getX(v1)) & 0x7FFFFFFF) >= 0x7F800000 || (Float.floatToRawIntBits(motionEvent0.getY(v1)) & 0x7FFFFFFF) >= 0x7F800000 || Build.VERSION.SDK_INT >= 29 && !B0.a.a(motionEvent0, v1);
                if(z) {
                    break;
                }
            }
        }
        return z;
    }

    public final boolean q(MotionEvent motionEvent0) {
        float f = motionEvent0.getX();
        float f1 = motionEvent0.getY();
        return 0.0f <= f && f <= ((float)this.getWidth()) && 0.0f <= f1 && f1 <= ((float)this.getHeight());
    }

    public final boolean r(MotionEvent motionEvent0) {
        if(motionEvent0.getPointerCount() == 1) {
            MotionEvent motionEvent1 = this.N0;
            return motionEvent1 == null || motionEvent1.getPointerCount() != motionEvent0.getPointerCount() || motionEvent0.getRawX() != motionEvent1.getRawX() || motionEvent0.getRawY() != motionEvent1.getRawY();
        }
        return true;
    }

    @Override  // android.view.ViewGroup
    public final boolean requestFocus(int v, Rect rect0) {
        if(this.isFocused()) {
            return true;
        }
        if(((w0.k)this.getFocusOwner()).f.o0().a()) {
            return super.requestFocus(v, rect0);
        }
        w0.d d0 = w0.f.E(v);
        int v1 = d0 == null ? 7 : d0.a;
        w0.j j0 = this.getFocusOwner();
        return rect0 == null ? kotlin.jvm.internal.q.b(((w0.k)j0).e(v1, null, new P.A(v1, 1)), Boolean.TRUE) : kotlin.jvm.internal.q.b(((w0.k)j0).e(v1, new x0.c(((float)rect0.left), ((float)rect0.top), ((float)rect0.right), ((float)rect0.bottom)), new P.A(v1, 1)), Boolean.TRUE);
    }

    public final void s(float[] arr_f) {
        this.D();
        F.e(arr_f, this.p0);
        float f = Float.intBitsToFloat(((int)(this.t0 >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(this.t0 & 0xFFFFFFFFL)));
        F.d(this.o0);
        F.f(this.o0, f, f1);
        N.t(arr_f, this.o0);
    }

    public void setAccessibilityEventBatchIntervalMillis(long v) {
        this.r.e = v;
    }

    public final void setConfigurationChangeObserver(@NotNull we.k k0) {
        this.V = k0;
    }

    public final void setContentCaptureManager$ui_release(@NotNull t0.d d0) {
        this.w = d0;
    }

    public void setCoroutineContext(@NotNull me.i i0) {
        this.f = i0;
        r0.p p0 = (r0.p)this.getRoot().b0.f;
        if(p0 instanceof J0.N) {
            ((J0.N)p0).o0();
        }
        if(!p0.getNode().isAttached()) {
            M0.a.b("visitSubtreeIf called on an unattached node");
        }
        g0.e e0 = new g0.e(new r0.p[16]);
        r0.p p1 = p0.getNode().getChild$ui_release();
        if(p1 == null) {
            P0.f.b(e0, p0.getNode());
        }
        else {
            e0.b(p1);
        }
        int v;
        while((v = e0.c) != 0) {
            r0.p p2 = (r0.p)e0.k(v - 1);
            if((p2.getAggregateChildKindSet$ui_release() & 16) != 0) {
                r0.p p3 = p2;
                while(p3 != null) {
                    if((p3.getKindSet$ui_release() & 16) != 0) {
                        r0.p p4 = p3;
                        g0.e e1 = null;
                        while(p4 != null) {
                            if(!(p4 instanceof w0)) {
                                if((p4.getKindSet$ui_release() & 16) != 0 && p4 instanceof P0.n) {
                                    r0.p p5 = ((P0.n)p4).b;
                                    int v1 = 0;
                                    while(p5 != null) {
                                        if((p5.getKindSet$ui_release() & 16) != 0) {
                                            ++v1;
                                            if(v1 == 1) {
                                                p4 = p5;
                                            }
                                            else {
                                                if(e1 == null) {
                                                    e1 = new g0.e(new r0.p[16]);
                                                }
                                                if(p4 != null) {
                                                    e1.b(p4);
                                                    p4 = null;
                                                }
                                                e1.b(p5);
                                            }
                                        }
                                        p5 = p5.getChild$ui_release();
                                    }
                                    if(v1 != 1) {
                                        goto label_44;
                                    }
                                    continue;
                                }
                            }
                            else if(((w0)p4) instanceof J0.N) {
                                ((J0.N)(((w0)p4))).o0();
                            }
                        label_44:
                            p4 = P0.f.f(e1);
                        }
                    }
                    p3 = p3.getChild$ui_release();
                }
            }
            P0.f.b(e0, p2);
        }
    }

    private void setDensity(r1.c c0) {
        ((O0)this.d).setValue(c0);
    }

    private void setFontFamilyResolver(e1.i i0) {
        ((O0)this.G0).setValue(i0);
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long v) {
        this.r0 = v;
    }

    private void setLayoutDirection(m m0) {
        ((O0)this.I0).setValue(m0);
    }

    public final void setOnViewTreeOwnersAvailable(@NotNull we.k k0) {
        Q0.j j0 = this.getViewTreeOwners();
        if(j0 != null) {
            k0.invoke(j0);
        }
        if(!this.isAttachedToWindow()) {
            this.x0 = k0;
        }
    }

    public void setShowLayoutBounds(boolean z) {
        this.g0 = z;
    }

    private final void set_viewTreeOwners(Q0.j j0) {
        ((O0)this.v0).setValue(j0);
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final long t(long v) {
        this.D();
        long v1 = F.b(v, this.p0);
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(this.t0 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(this.t0 >> 0x20))) + Float.intBitsToFloat(((int)(v1 >> 0x20))))) << 0x20;
    }

    public final void u(boolean z) {
        X x0 = this.l0;
        if(!x0.b.n() && ((g0.e)x0.e.a).c == 0) {
            return;
        }
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            if(x0.j((z ? this.U0 : null))) {
                this.requestLayout();
            }
            x0.a(false);
            if(this.N) {
                this.getViewTreeObserver().dispatchOnGlobalLayout();
                this.N = false;
            }
        }
        finally {
            Trace.endSection();
        }
    }

    public final void v(I i0, long v) {
        X x0 = this.l0;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            x0.k(i0, v);
            if(!x0.b.n()) {
                x0.a(false);
                if(this.N) {
                    this.getViewTreeObserver().dispatchOnGlobalLayout();
                    this.N = false;
                }
            }
            this.getRectManager().a();
        }
        finally {
            Trace.endSection();
        }
    }

    public final void w(q0 q00, boolean z) {
        ArrayList arrayList0 = this.G;
        if(!z) {
            if(!this.M) {
                arrayList0.remove(q00);
                ArrayList arrayList1 = this.I;
                if(arrayList1 != null) {
                    arrayList1.remove(q00);
                }
            }
            return;
        }
        if(!this.M) {
            arrayList0.add(q00);
            return;
        }
        ArrayList arrayList2 = this.I;
        if(arrayList2 == null) {
            arrayList2 = new ArrayList();
            this.I = arrayList2;
        }
        arrayList2.add(q00);
    }

    public final void x() {
        if(this.c0) {
            t0 t00 = this.getSnapshotObserver();
            Object object0 = t00.a.g;
            synchronized(object0) {
                g0.e e0 = t00.a.f;
                int v1 = e0.c;
                int v3 = 0;
                for(int v2 = 0; v2 < v1; ++v2) {
                    p0.r r0 = (p0.r)e0.a[v2];
                    r0.e();
                    if(r0.f.e == 0) {
                        ++v3;
                    }
                    else if(v3 > 0) {
                        e0.a[v2 - v3] = e0.a[v2];
                    }
                }
                int v4 = v1 - v3;
                Arrays.fill(e0.a, v4, v1, null);
                e0.c = v4;
            }
            this.c0 = false;
        }
        AndroidViewsHandler androidViewsHandler0 = this.h0;
        if(androidViewsHandler0 != null) {
            u.i(androidViewsHandler0);
        }
        s0.c c0 = this.b0;
        if(c0 != null) {
            androidx.collection.A a0 = c0.h;
            if(a0.d == 0 && c0.i) {
                ((AutofillManager)c0.a.b).commit();
                c0.i = false;
            }
            if(a0.d != 0) {
                c0.i = true;
            }
        }
        while(this.Q0.b != 0 && this.Q0.e(0) != null) {
            int v5 = this.Q0.b;
            int v6 = 0;
            while(v6 < v5) {
                we.a a1 = (we.a)this.Q0.e(v6);
                G g0 = this.Q0;
                if(v6 >= 0 && v6 < g0.b) {
                    Object[] arr_object = g0.a;
                    Object object1 = arr_object[v6];
                    arr_object[v6] = null;
                    if(a1 != null) {
                        a1.invoke();
                    }
                    ++v6;
                    continue;
                }
                g0.l(v6);
                throw null;
            }
            this.Q0.j(0, v5);
        }
    }

    public final x0.c y() {
        if(this.isFocused()) {
            w0.u u0 = w0.f.g(((w0.k)this.getFocusOwner()).f);
            return u0 == null ? null : w0.f.j(u0);
        }
        View view0 = this.findFocus();
        return view0 == null ? null : w0.f.d(view0, this);
    }

    public final void z(I i0) {
        C c0 = this.r;
        c0.x = true;
        if(c0.l()) {
            c0.m(i0);
        }
        t0.d d0 = this.w;
        d0.g = true;
        if(d0.e()) {
            d0.h.trySend-JP2dKIU(ie.H.a);
        }
    }
}

