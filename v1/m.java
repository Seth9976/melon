package v1;

import P1.e;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.KeyEvent.DispatcherState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import androidx.appcompat.app.v;
import androidx.compose.runtime.E;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.f0;
import i.n.i.b.a.s.e.M3;
import java.util.UUID;
import kotlin.jvm.internal.G;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.s;
import r1.c;
import r1.k;
import r1.l;
import we.a;

public final class m extends AbstractComposeView {
    public final b0 B;
    public final b0 D;
    public k E;
    public final E G;
    public final Rect I;
    public final s M;
    public v N;
    public final b0 S;
    public boolean T;
    public final int[] V;
    public a i;
    public q j;
    public String k;
    public final View l;
    public final o m;
    public final WindowManager n;
    public final WindowManager.LayoutParams o;
    public p r;
    public r1.m w;

    public m(a a0, q q0, String s, View view0, c c0, p p0, UUID uUID0) {
        o o0 = Build.VERSION.SDK_INT >= 29 ? new n() : new o();  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
        super(view0.getContext(), null, 6, 0);
        this.i = a0;
        this.j = q0;
        this.k = s;
        this.l = view0;
        this.m = o0;
        Object object0 = view0.getContext().getSystemService("window");
        kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        this.n = (WindowManager)object0;
        WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
        windowManager$LayoutParams0.gravity = 0x800033;
        q q1 = this.j;
        boolean z = i.b(view0);
        boolean z1 = q1.b;
        int v = q1.a;
        if(z1 && z) {
            v |= 0x2000;
        }
        else if(z1 && !z) {
            v &= 0xFFFFDFFF;
        }
        windowManager$LayoutParams0.flags = v;
        windowManager$LayoutParams0.type = 1002;
        windowManager$LayoutParams0.token = view0.getApplicationWindowToken();
        windowManager$LayoutParams0.width = -2;
        windowManager$LayoutParams0.height = -2;
        windowManager$LayoutParams0.format = -3;
        windowManager$LayoutParams0.setTitle("Pop-Up Window");
        this.o = windowManager$LayoutParams0;
        this.r = p0;
        this.w = r1.m.a;
        this.B = w.s(null);
        this.D = w.s(null);
        this.G = w.i(new X.k(this, 28));
        this.I = new Rect();
        this.M = new s(new f(this, 2));
        this.setId(0x1020002);
        f0.k(this, f0.d(view0));
        f0.l(this, f0.e(view0));
        a.a.M(this, a.a.v(view0));
        this.setTag(0x7F0A030D, "Popup:" + uUID0);  // id:compose_view_saveable_id_tag
        this.setClipChildren(false);
        this.setElevation(c0.Y(8.0f));
        this.setOutlineProvider(new B0.w(2));
        this.S = w.s(v1.k.a);
        this.V = new int[2];
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public final void a(androidx.compose.runtime.p p0) {
        p0.a0(-857613600);
        this.getContent().invoke(p0, 0);
        p0.p(false);
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(!this.j.c) {
            return super.dispatchKeyEvent(keyEvent0);
        }
        switch(keyEvent0.getKeyCode()) {
            case 4: 
            case 0x6F: {
                KeyEvent.DispatcherState keyEvent$DispatcherState0 = this.getKeyDispatcherState();
                if(keyEvent$DispatcherState0 == null) {
                    return super.dispatchKeyEvent(keyEvent0);
                }
                if(keyEvent0.getAction() == 0 && keyEvent0.getRepeatCount() == 0) {
                    keyEvent$DispatcherState0.startTracking(keyEvent0, this);
                    return true;
                }
                if(keyEvent0.getAction() == 1 && keyEvent$DispatcherState0.isTracking(keyEvent0) && !keyEvent0.isCanceled()) {
                    a a0 = this.i;
                    if(a0 != null) {
                        a0.invoke();
                    }
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent0);
            }
            default: {
                return super.dispatchKeyEvent(keyEvent0);
            }
        }
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public final void e(int v, int v1, int v2, int v3, boolean z) {
        super.e(v, v1, v2, v3, z);
        this.j.getClass();
        View view0 = this.getChildAt(0);
        if(view0 == null) {
            return;
        }
        this.o.width = view0.getMeasuredWidth();
        this.o.height = view0.getMeasuredHeight();
        this.m.getClass();
        this.n.updateViewLayout(this, this.o);
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public final void f(int v, int v1) {
        this.j.getClass();
        k k0 = this.getVisibleDisplayBounds();
        super.f(View.MeasureSpec.makeMeasureSpec(k0.c - k0.a, 0x80000000), View.MeasureSpec.makeMeasureSpec(k0.d - k0.b, 0x80000000));
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean)this.G.getValue()).booleanValue();
    }

    private final we.n getContent() {
        return (we.n)((O0)this.S).getValue();
    }

    @NotNull
    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.o;
    }

    public static void getParams$ui_release$annotations() {
    }

    private final N0.v getParentLayoutCoordinates() {
        return (N0.v)((O0)this.D).getValue();
    }

    @NotNull
    public final r1.m getParentLayoutDirection() {
        return this.w;
    }

    @Nullable
    public final l getPopupContentSize-bOM6tXw() {
        return (l)((O0)this.B).getValue();
    }

    @NotNull
    public final p getPositionProvider() {
        return this.r;
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.T;
    }

    @NotNull
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @NotNull
    public final String getTestTag() {
        return this.k;
    }

    @Nullable
    public View getViewRoot() {
        return null;
    }

    private final k getVisibleDisplayBounds() {
        this.m.getClass();
        this.l.getWindowVisibleDisplayFrame(this.I);
        return new k(this.I.left, this.I.top, this.I.right, this.I.bottom);
    }

    public final void i(androidx.compose.runtime.n n0, b b0) {
        this.setParentCompositionContext(n0);
        this.setContent(b0);
        this.T = true;
    }

    public final void j(a a0, q q0, String s, r1.m m0) {
        this.i = a0;
        this.k = s;
        if(!kotlin.jvm.internal.q.b(this.j, q0)) {
            q0.getClass();
            this.j = q0;
            boolean z = i.b(this.l);
            boolean z1 = q0.b;
            int v = q0.a;
            if(z1 && z) {
                v |= 0x2000;
            }
            else if(z1 && !z) {
                v &= 0xFFFFDFFF;
            }
            this.o.flags = v;
            this.m.getClass();
            this.n.updateViewLayout(this, this.o);
        }
        int v1 = 1;
        int v2 = m0.ordinal();
        if(v2 == 0) {
            v1 = 0;
        }
        else if(v2 != 1) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        super.setLayoutDirection(v1);
    }

    public final void k() {
        N0.v v0 = this.getParentLayoutCoordinates();
        if(v0 != null) {
            if(!v0.h()) {
                v0 = null;
            }
            if(v0 != null) {
                long v1 = v0.l();
                long v2 = v0.D(0L);
                long v3 = ((long)Math.round(Float.intBitsToFloat(((int)(v2 >> 0x20))))) << 0x20 | ((long)Math.round(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL;
                k k0 = new k(((int)(v3 >> 0x20)), ((int)(v3 & 0xFFFFFFFFL)), ((int)(v1 >> 0x20)) + ((int)(v3 >> 0x20)), ((int)(v1 & 0xFFFFFFFFL)) + ((int)(v3 & 0xFFFFFFFFL)));
                if(!k0.equals(this.E)) {
                    this.E = k0;
                    this.m();
                }
            }
        }
    }

    public final void l(N0.v v0) {
        this.setParentLayoutCoordinates(v0);
        this.k();
    }

    public final void m() {
        k k0 = this.E;
        if(k0 != null) {
            l l0 = this.getPopupContentSize-bOM6tXw();
            if(l0 != null) {
                k k1 = this.getVisibleDisplayBounds();
                long v = ((long)(k1.d - k1.b)) & 0xFFFFFFFFL | ((long)(k1.c - k1.a)) << 0x20;
                G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                g0.a = 0L;
                v1.l l1 = new v1.l(g0, this, k0, v, l0.a);
                this.M.c(this, d.k, l1);
                WindowManager.LayoutParams windowManager$LayoutParams0 = this.o;
                windowManager$LayoutParams0.x = (int)(g0.a >> 0x20);
                windowManager$LayoutParams0.y = (int)(g0.a & 0xFFFFFFFFL);
                o o0 = this.m;
                if(this.j.e) {
                    o0.a(this, ((int)(v >> 0x20)), ((int)(v & 0xFFFFFFFFL)));
                }
                o0.getClass();
                this.n.updateViewLayout(this, windowManager$LayoutParams0);
            }
        }
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.M.d();
        if(this.j.c && Build.VERSION.SDK_INT >= 33) {
            if(this.N == null) {
                this.N = new v(this.i, 4);
            }
            e.i(this, this.N);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s s0 = this.M;
        j3.n n0 = s0.h;
        if(n0 != null) {
            n0.d();
        }
        s0.b();
        if(Build.VERSION.SDK_INT >= 33) {
            e.j(this, this.N);
        }
        this.N = null;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!this.j.d) {
            return super.onTouchEvent(motionEvent0);
        }
        if(motionEvent0 != null && motionEvent0.getAction() == 0 && (motionEvent0.getX() < 0.0f || motionEvent0.getX() >= ((float)this.getWidth()) || motionEvent0.getY() < 0.0f || motionEvent0.getY() >= ((float)this.getHeight()))) {
            a a0 = this.i;
            if(a0 == null) {
                return true;
            }
            a0.invoke();
            return true;
        }
        if(motionEvent0 != null && motionEvent0.getAction() == 4) {
            a a1 = this.i;
            if(a1 != null) {
                a1.invoke();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent0);
    }

    private final void setContent(we.n n0) {
        ((O0)this.S).setValue(n0);
    }

    @Override  // android.view.View
    public void setLayoutDirection(int v) {
    }

    private final void setParentLayoutCoordinates(N0.v v0) {
        ((O0)this.D).setValue(v0);
    }

    public final void setParentLayoutDirection(@NotNull r1.m m0) {
        this.w = m0;
    }

    public final void setPopupContentSize-fhxjrPA(@Nullable l l0) {
        ((O0)this.B).setValue(l0);
    }

    public final void setPositionProvider(@NotNull p p0) {
        this.r = p0;
    }

    public final void setTestTag(@NotNull String s) {
        this.k = s;
    }
}

