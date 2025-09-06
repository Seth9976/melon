package j5;

import C0.c;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w0;
import androidx.compose.runtime.w;
import coil.request.ImageRequest.Builder;
import com.google.firebase.b;
import hd.h0;
import i5.e;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import t5.j;
import t5.s;
import we.k;
import y0.t;

public final class l extends c implements w0 {
    public CoroutineScope a;
    public final MutableStateFlow b;
    public final b0 c;
    public final Z d;
    public final b0 e;
    public g f;
    public c g;
    public k h;
    public k i;
    public N0.k j;
    public int k;
    public boolean l;
    public final b0 m;
    public final b0 n;
    public final b0 o;
    public static final h0 r;

    static {
        l.r = new h0(9);
    }

    public l(j j0, e e0) {
        this.b = StateFlowKt.MutableStateFlow(new x0.e(0L));
        this.c = w.s(null);
        this.d = w.o(1.0f);
        this.e = w.s(null);
        this.f = j5.c.a;
        this.h = l.r;
        this.j = N0.j.c;
        this.k = 1;
        this.m = w.s(j5.c.a);
        this.n = w.s(j0);
        this.o = w.s(e0);
    }

    public final c a(Drawable drawable0) {
        return drawable0 instanceof BitmapDrawable ? b.b(new y0.e(((BitmapDrawable)drawable0).getBitmap()), this.k) : new L5.b(drawable0.mutate());
    }

    @Override  // C0.c
    public final boolean applyAlpha(float f) {
        ((I0)this.d).n(f);
        return true;
    }

    @Override  // C0.c
    public final boolean applyColorFilter(t t0) {
        ((O0)this.e).setValue(t0);
        return true;
    }

    public final void b(g g0) {
        c c0;
        s s0;
        g g1 = this.f;
        g g2 = (g)this.h.invoke(g0);
        this.f = g2;
        ((O0)this.m).setValue(g2);
        w0 w00 = null;
        if(g2 instanceof f) {
            s0 = ((f)g2).b;
            goto label_10;
        }
        else if(g2 instanceof d) {
            s0 = ((d)g2).b;
        label_10:
            w5.f f0 = s0.b().j.create(n.a, s0);
            c0 = f0 instanceof w5.b ? new j5.t((g1 instanceof j5.e ? g1.a() : null), g2.a(), this.j, ((w5.b)f0).c, !(s0 instanceof s) || !s0.g) : null;
        }
        else {
            c0 = null;
        }
        if(c0 == null) {
            c0 = g2.a();
        }
        this.g = c0;
        ((O0)this.c).setValue(c0);
        if(this.a != null && g1.a() != g2.a()) {
            c c1 = g1.a();
            w0 w01 = c1 instanceof w0 ? ((w0)c1) : null;
            if(w01 != null) {
                w01.e();
            }
            c c2 = g2.a();
            if(c2 instanceof w0) {
                w00 = (w0)c2;
            }
            if(w00 != null) {
                w00.c();
            }
        }
        k k0 = this.i;
        if(k0 != null) {
            k0.invoke(g2);
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            if(this.a == null) {
                CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
                this.a = coroutineScope0;
                w0 w00 = this.g instanceof w0 ? ((w0)this.g) : null;
                if(w00 != null) {
                    w00.c();
                }
                if(this.l) {
                    ImageRequest.Builder imageRequest$Builder0 = j.a(((j)((O0)this.n).getValue()));
                    imageRequest$Builder0.b = ((i5.n)(((e)((O0)this.o).getValue()))).b;
                    imageRequest$Builder0.v = null;
                    imageRequest$Builder0.a().D.getClass();
                    this.b(new j5.e(null));
                }
                else {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new i(this, null), 3, null);
                }
            }
        }
        finally {
            Trace.endSection();
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
        CoroutineScope coroutineScope0 = this.a;
        w0 w00 = null;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
        }
        this.a = null;
        c c0 = this.g;
        if(c0 instanceof w0) {
            w00 = (w0)c0;
        }
        if(w00 != null) {
            w00.d();
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        CoroutineScope coroutineScope0 = this.a;
        w0 w00 = null;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
        }
        this.a = null;
        c c0 = this.g;
        if(c0 instanceof w0) {
            w00 = (w0)c0;
        }
        if(w00 != null) {
            w00.e();
        }
    }

    @Override  // C0.c
    public final long getIntrinsicSize-NH-jbRc() {
        c c0 = (c)((O0)this.c).getValue();
        return c0 == null ? 0x7FC000007FC00000L : c0.getIntrinsicSize-NH-jbRc();
    }

    @Override  // C0.c
    public final void onDraw(A0.f f0) {
        x0.e e0 = new x0.e(f0.c());
        this.b.setValue(e0);
        Object object0 = ((O0)this.c).getValue();
        if(((c)object0) != null) {
            ((c)object0).draw-x_KDEd0(f0, f0.c(), ((I0)this.d).m(), ((t)((O0)this.e).getValue()));
        }
    }
}

