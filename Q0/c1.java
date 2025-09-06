package Q0;

import B0.e;
import B0.w;
import J0.d;
import P0.q0;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import androidx.compose.ui.platform.DrawChildContainer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import we.a;
import we.n;
import y0.F;
import y0.L;
import y0.M;
import y0.N;
import y0.U;
import y0.b;
import y0.q;
import y0.r;

public final class c1 extends View implements q0 {
    public static Field B;
    public static boolean D;
    public static boolean E;
    public final u a;
    public final DrawChildContainer b;
    public n c;
    public a d;
    public final E0 e;
    public boolean f;
    public Rect g;
    public boolean h;
    public boolean i;
    public final r j;
    public final d k;
    public long l;
    public boolean m;
    public final long n;
    public int o;
    public static final w r;
    public static Method w;

    static {
        c1.r = new w(1);
    }

    public c1(u u0, DrawChildContainer drawChildContainer0, n n0, a a0) {
        super(u0.getContext());
        this.a = u0;
        this.b = drawChildContainer0;
        this.c = n0;
        this.d = a0;
        this.e = new E0();
        this.j = new r();
        this.k = new d(E.j);
        this.l = U.b;
        this.m = true;
        this.setWillNotDraw(false);
        drawChildContainer0.addView(this);
        this.n = (long)View.generateViewId();
    }

    @Override  // P0.q0
    public final void a(float[] arr_f) {
        F.e(arr_f, this.k.c(this));
    }

    @Override  // P0.q0
    public final void b(q q0, e e0) {
        boolean z = this.getElevation() > 0.0f;
        this.i = z;
        if(z) {
            q0.m();
        }
        long v = this.getDrawingTime();
        this.b.a(q0, this, v);
        if(this.i) {
            q0.r();
        }
    }

    @Override  // P0.q0
    public final long c(long v, boolean z) {
        d d0 = this.k;
        if(z) {
            float[] arr_f = d0.b(this);
            if(arr_f == null) {
                return 0x7F8000007F800000L;
            }
            return d0.d ? v : F.b(v, arr_f);
        }
        float[] arr_f1 = d0.c(this);
        return d0.d ? v : F.b(v, arr_f1);
    }

    @Override  // P0.q0
    public final void d(long v) {
        if(((int)(v >> 0x20)) == this.getWidth() && ((int)(v & 0xFFFFFFFFL)) == this.getHeight()) {
            return;
        }
        this.setPivotX(U.b(this.l) * ((float)(((int)(v >> 0x20)))));
        this.setPivotY(U.c(this.l) * ((float)(((int)(v & 0xFFFFFFFFL)))));
        this.setOutlineProvider((this.e.b() == null ? null : c1.r));
        this.layout(this.getLeft(), this.getTop(), this.getLeft() + ((int)(v >> 0x20)), this.getTop() + ((int)(v & 0xFFFFFFFFL)));
        this.l();
        this.k.e();
    }

    @Override  // P0.q0
    public final void destroy() {
        this.setInvalidated(false);
        this.a.c0 = true;
        this.c = null;
        this.d = null;
        this.a.F(this);
        this.b.removeViewInLayout(this);
    }

    @Override  // android.view.View
    public final void dispatchDraw(Canvas canvas0) {
        boolean z;
        r r0 = this.j;
        b b0 = r0.a;
        Canvas canvas1 = b0.a;
        b0.a = canvas0;
        if(this.getManualClipPath() != null || !canvas0.isHardwareAccelerated()) {
            b0.q();
            this.e.a(b0);
            z = true;
        }
        else {
            z = false;
        }
        n n0 = this.c;
        if(n0 != null) {
            n0.invoke(b0, null);
        }
        if(z) {
            b0.j();
        }
        r0.a.a = canvas1;
        this.setInvalidated(false);
    }

    @Override  // P0.q0
    public final void e(N n0) {
        int v = n0.a | this.o;
        if((v & 0x1000) != 0) {
            this.l = n0.n;
            this.setPivotX(U.b(n0.n) * ((float)this.getWidth()));
            this.setPivotY(U.c(this.l) * ((float)this.getHeight()));
        }
        if((v & 1) != 0) {
            this.setScaleX(n0.b);
        }
        if((v & 2) != 0) {
            this.setScaleY(n0.c);
        }
        if((v & 4) != 0) {
            this.setAlpha(n0.d);
        }
        if((v & 8) != 0) {
            this.setTranslationX(n0.e);
        }
        if((v & 16) != 0) {
            this.setTranslationY(n0.f);
        }
        if((v & 0x20) != 0) {
            this.setElevation(n0.g);
        }
        if((v & 0x400) != 0) {
            this.setRotation(n0.l);
        }
        if((v & 0x100) != 0) {
            this.setRotationX(n0.j);
        }
        if((v & 0x200) != 0) {
            this.setRotationY(n0.k);
        }
        if((v & 0x800) != 0) {
            this.setCameraDistancePx(n0.m);
        }
        boolean z = false;
        int v1 = this.getManualClipPath() == null ? 0 : 1;
        boolean z1 = n0.r;
        wc.u u0 = M.a;
        boolean z2 = z1 && n0.o != u0;
        if((v & 0x6000) != 0) {
            this.f = z1 && n0.o == u0;
            this.l();
            this.setClipToOutline(z2);
        }
        boolean z3 = this.e.d(n0.I, n0.d, z2, n0.g, n0.B);
        E0 e00 = this.e;
        if(e00.f) {
            this.setOutlineProvider((e00.b() == null ? null : c1.r));
        }
        int v2 = this.getManualClipPath() == null ? 0 : 1;
        if(v1 != v2 || v2 != 0 && z3) {
            this.invalidate();
        }
        if(!this.i && this.getElevation() > 0.0f) {
            a a0 = this.d;
            if(a0 != null) {
                a0.invoke();
            }
        }
        if((v & 0x1F1B) != 0) {
            this.k.e();
        }
        int v3 = Build.VERSION.SDK_INT;
        if(v3 >= 28) {
            if((v & 0x40) != 0) {
                this.setOutlineAmbientShadowColor(M.z(n0.h));
            }
            if((v & 0x80) != 0) {
                this.setOutlineSpotShadowColor(M.z(n0.i));
            }
        }
        if(v3 >= 0x1F && (0x20000 & v) != 0) {
            this.setRenderEffect((n0.G == null ? null : n0.G.a()));
        }
        if((v & 0x8000) != 0) {
            int v4 = n0.w;
            if(v4 == 1) {
                this.setLayerType(2, null);
                z = true;
            }
            else if(v4 == 2) {
                this.setLayerType(0, null);
            }
            else {
                this.setLayerType(0, null);
                z = true;
            }
            this.m = z;
        }
        this.o = n0.a;
    }

    @Override  // P0.q0
    public final void f(n n0, a a0) {
        this.b.addView(this);
        this.k.a = false;
        this.k.b = false;
        this.k.d = true;
        this.k.c = true;
        F.d(((float[])this.k.g));
        F.d(((float[])this.k.h));
        this.f = false;
        this.i = false;
        this.l = U.b;
        this.c = n0;
        this.d = a0;
        this.setInvalidated(false);
    }

    @Override  // android.view.View
    public final void forceLayout() {
    }

    @Override  // P0.q0
    public final void g(x0.a a0, boolean z) {
        d d0 = this.k;
        if(z) {
            float[] arr_f = d0.b(this);
            if(arr_f == null) {
                a0.a = 0.0f;
                a0.b = 0.0f;
                a0.c = 0.0f;
                a0.d = 0.0f;
                return;
            }
            if(!d0.d) {
                F.c(arr_f, a0);
            }
        }
        else {
            float[] arr_f1 = d0.c(this);
            if(!d0.d) {
                F.c(arr_f1, a0);
            }
        }
    }

    public final float getCameraDistancePx() {
        return this.getCameraDistance() / ((float)this.getResources().getDisplayMetrics().densityDpi);
    }

    @NotNull
    public final DrawChildContainer getContainer() {
        return this.b;
    }

    public long getLayerId() {
        return this.n;
    }

    private final L getManualClipPath() {
        if(this.getClipToOutline()) {
            E0 e00 = this.e;
            if(e00.g) {
                e00.e();
                return e00.e;
            }
        }
        return null;
    }

    @NotNull
    public final u getOwnerView() {
        return this.a;
    }

    public long getOwnerViewId() {
        return Build.VERSION.SDK_INT < 29 ? -1L : this.a.getUniqueDrawingId();
    }

    @Override  // P0.q0
    @NotNull
    public float[] getUnderlyingMatrix-sQKQjiQ() {
        return this.k.c(this);
    }

    @Override  // P0.q0
    public final boolean h(long v) {
        float f = Float.intBitsToFloat(((int)(v >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & v)));
        if(this.f) {
            return 0.0f <= f && f < ((float)this.getWidth()) && 0.0f <= f1 && f1 < ((float)this.getHeight());
        }
        return this.getClipToOutline() ? this.e.c(v) : true;
    }

    @Override  // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.m;
    }

    @Override  // P0.q0
    public final void i(float[] arr_f) {
        float[] arr_f1 = this.k.b(this);
        if(arr_f1 != null) {
            F.e(arr_f, arr_f1);
        }
    }

    @Override  // android.view.View, P0.q0
    public final void invalidate() {
        if(!this.h) {
            this.setInvalidated(true);
            super.invalidate();
            this.a.invalidate();
        }
    }

    @Override  // P0.q0
    public final void j(long v) {
        int v1 = this.getLeft();
        d d0 = this.k;
        if(((int)(v >> 0x20)) != v1) {
            this.offsetLeftAndRight(((int)(v >> 0x20)) - this.getLeft());
            d0.e();
        }
        if(((int)(v & 0xFFFFFFFFL)) != this.getTop()) {
            this.offsetTopAndBottom(((int)(v & 0xFFFFFFFFL)) - this.getTop());
            d0.e();
        }
    }

    @Override  // P0.q0
    public final void k() {
        if(this.h && !c1.E) {
            Q0.N.y(this);
            this.setInvalidated(false);
        }
    }

    public final void l() {
        Rect rect1;
        if(this.f) {
            Rect rect0 = this.g;
            if(rect0 == null) {
                this.g = new Rect(0, 0, this.getWidth(), this.getHeight());
            }
            else {
                kotlin.jvm.internal.q.d(rect0);
                rect0.set(0, 0, this.getWidth(), this.getHeight());
            }
            rect1 = this.g;
        }
        else {
            rect1 = null;
        }
        this.setClipBounds(rect1);
    }

    @Override  // android.view.View
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
    }

    public final void setCameraDistancePx(float f) {
        this.setCameraDistance(f * ((float)this.getResources().getDisplayMetrics().densityDpi));
    }

    private final void setInvalidated(boolean z) {
        if(z != this.h) {
            this.h = z;
            this.a.w(this, z);
        }
    }
}

