package androidx.compose.material.ripple;

import A3.l;
import a0.o;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;
import x0.b;
import x0.e;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "pressed", "Lie/H;", "setRippleState", "(Z)V", "material-ripple_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RippleHostView extends View {
    public o a;
    public Boolean b;
    public Long c;
    public l d;
    public a e;
    public static final int[] f;
    public static final int[] g;

    static {
        RippleHostView.f = new int[]{0x10100A7, 0x101009E};
        RippleHostView.g = new int[0];
    }

    public RippleHostView(@NotNull Context context0) {
        super(context0);
    }

    public final void b(K.o o0, boolean z, long v, int v1, long v2, float f, a a0) {
        if(this.a == null || !Boolean.valueOf(z).equals(this.b)) {
            o o1 = new o(z);
            this.setBackground(o1);
            this.a = o1;
            this.b = Boolean.valueOf(z);
        }
        o o2 = this.a;
        q.d(o2);
        this.e = a0;
        this.e(v1, v, f, v2);
        if(z) {
            o2.setHotspot(b.d(o0.a), b.e(o0.a));
        }
        else {
            o2.setHotspot(((float)o2.getBounds().centerX()), ((float)o2.getBounds().centerY()));
        }
        this.setRippleState(true);
    }

    public final void c() {
        this.e = null;
        l l0 = this.d;
        if(l0 == null) {
            o o0 = this.a;
            if(o0 != null) {
                o0.setState(RippleHostView.g);
            }
        }
        else {
            this.removeCallbacks(l0);
            l l1 = this.d;
            q.d(l1);
            l1.run();
        }
        o o1 = this.a;
        if(o1 == null) {
            return;
        }
        o1.setVisible(false, false);
        this.unscheduleDrawable(o1);
    }

    public final void d() {
        this.setRippleState(false);
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        if(!this.isAttachedToWindow()) {
            this.c();
            return;
        }
        super.draw(canvas0);
    }

    public final void e(int v, long v1, float f, long v2) {
        o o0 = this.a;
        if(o0 == null) {
            return;
        }
        if(o0.c == null || ((int)o0.c) != v) {
            o0.c = v;
            o0.setRadius(v);
        }
        if(Build.VERSION.SDK_INT < 28) {
            f *= 2.0f;
        }
        if(f > 1.0f) {
            f = 1.0f;
        }
        long v3 = s.c(v2, f);
        if(!(o0.b == null ? false : s.d(o0.b.a, v3))) {
            o0.b = new s(v3);
            o0.setColor(ColorStateList.valueOf(M.z(v3)));
        }
        Rect rect0 = new Rect(0, 0, ye.a.V(e.d(v1)), ye.a.V(e.b(v1)));
        this.setLeft(rect0.left);
        this.setTop(rect0.top);
        this.setRight(rect0.right);
        this.setBottom(rect0.bottom);
        o0.setBounds(rect0);
    }

    @Override  // android.view.View
    public final void invalidateDrawable(Drawable drawable0) {
        a a0 = this.e;
        if(a0 != null) {
            a0.invoke();
        }
    }

    @Override  // android.view.View
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    @Override  // android.view.View
    public final void refreshDrawableState() {
    }

    private final void setRippleState(boolean z) {
        long v = AnimationUtils.currentAnimationTimeMillis();
        l l0 = this.d;
        if(l0 != null) {
            this.removeCallbacks(l0);
            l0.run();
        }
        if(z || v - (this.c == null ? 0L : ((long)this.c)) >= 5L) {
            int[] arr_v = z ? RippleHostView.f : RippleHostView.g;
            o o0 = this.a;
            if(o0 != null) {
                o0.setState(arr_v);
            }
        }
        else {
            l l1 = new l(this, 15);
            this.d = l1;
            this.postDelayed(l1, 50L);
        }
        this.c = v;
    }

    private static final void setRippleState$lambda$2(RippleHostView rippleHostView0) {
        o o0 = rippleHostView0.a;
        if(o0 != null) {
            o0.setState(RippleHostView.g);
        }
        rippleHostView0.d = null;
    }
}

