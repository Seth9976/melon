package L5;

import A0.f;
import Ac.U;
import C0.c;
import P4.a;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w0;
import androidx.compose.runtime.w;
import d3.g;
import e1.m;
import i.n.i.b.a.s.e.M3;
import ie.r;
import kotlin.jvm.internal.q;
import x0.e;
import y0.t;

public final class b extends c implements w0 {
    public final Drawable a;
    public final b0 b;
    public final b0 c;
    public final r d;

    public b(Drawable drawable0) {
        q.g(drawable0, "drawable");
        super();
        this.a = drawable0;
        this.b = w.s(0);
        this.c = w.s(new e((drawable0.getIntrinsicWidth() < 0 || drawable0.getIntrinsicHeight() < 0 ? 0x7FC000007FC00000L : m.i(drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight()))));
        this.d = g.Q(new U(this, 23));
        if(drawable0.getIntrinsicWidth() >= 0 && drawable0.getIntrinsicHeight() >= 0) {
            drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
        }
    }

    @Override  // C0.c
    public final boolean applyAlpha(float f) {
        int v = a.j(ye.a.V(f * 255.0f), 0, 0xFF);
        this.a.setAlpha(v);
        return true;
    }

    @Override  // C0.c
    public final boolean applyColorFilter(t t0) {
        this.a.setColorFilter((t0 == null ? null : t0.a));
        return true;
    }

    @Override  // C0.c
    public final boolean applyLayoutDirection(r1.m m0) {
        int v = 1;
        q.g(m0, "layoutDirection");
        int v1 = m0.ordinal();
        if(v1 == 0) {
            v = 0;
        }
        else if(v1 != 1) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return this.a.setLayoutDirection(v);
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
        Drawable.Callback drawable$Callback0 = (Drawable.Callback)this.d.getValue();
        Drawable drawable0 = this.a;
        drawable0.setCallback(drawable$Callback0);
        drawable0.setVisible(true, true);
        if(drawable0 instanceof Animatable) {
            ((Animatable)drawable0).start();
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
        this.e();
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        Drawable drawable0 = this.a;
        if(drawable0 instanceof Animatable) {
            ((Animatable)drawable0).stop();
        }
        drawable0.setVisible(false, false);
        drawable0.setCallback(null);
    }

    @Override  // C0.c
    public final long getIntrinsicSize-NH-jbRc() {
        return ((e)((O0)this.c).getValue()).a;
    }

    @Override  // C0.c
    public final void onDraw(f f0) {
        q.g(f0, "<this>");
        y0.q q0 = f0.a0().h();
        ((Number)((O0)this.b).getValue()).intValue();
        try {
            q0.q();
            Drawable drawable0 = this.a;
            if(Build.VERSION.SDK_INT < 28 || Build.VERSION.SDK_INT >= 0x1F || !B0.q.w(drawable0)) {
                drawable0.setBounds(0, 0, ye.a.V(e.d(f0.c())), ye.a.V(e.b(f0.c())));
            }
            else {
                q0.b(e.d(f0.c()) / e.d(this.getIntrinsicSize-NH-jbRc()), e.b(f0.c()) / e.b(this.getIntrinsicSize-NH-jbRc()));
            }
            drawable0.draw(y0.c.a(q0));
        }
        finally {
            q0.j();
        }
    }
}

