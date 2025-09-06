package v6;

import O4.p;
import Q0.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings.Global;
import java.util.ArrayList;

public final class o extends l {
    public final n l;
    public a m;
    public p n;

    public o(Context context0, e e0, n n0, a a0) {
        super(context0, e0);
        this.l = n0;
        this.m = a0;
        a0.a = this;
    }

    @Override  // v6.l
    public final boolean d(boolean z, boolean z1, boolean z2) {
        boolean z3 = super.d(z, z1, z2);
        if(this.c != null && Settings.Global.getFloat(this.a.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
            p p0 = this.n;
            if(p0 != null) {
                return p0.setVisible(z, z1);
            }
        }
        if(!this.isRunning()) {
            this.m.c();
        }
        if(z && z2) {
            this.m.w();
        }
        return z3;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        int v3;
        Rect rect0 = new Rect();
        if(!this.getBounds().isEmpty() && this.isVisible() && canvas0.getClipBounds(rect0)) {
            e e0 = this.b;
            if(this.c != null && Settings.Global.getFloat(this.a.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
                p p0 = this.n;
                if(p0 != null) {
                    p0.setBounds(this.getBounds());
                    this.n.setTint(e0.c[0]);
                    this.n.draw(canvas0);
                    return;
                }
            }
            canvas0.save();
            Rect rect1 = this.getBounds();
            float f = this.b();
            boolean z = this.d != null && this.d.isRunning();
            boolean z1 = this.e != null && this.e.isRunning();
            this.l.a.a();
            this.l.a(canvas0, rect1, f, z, z1);
            int v1 = e0.g;
            int v2 = this.j;
            Paint paint0 = this.i;
            if(v1 == 0) {
                this.l.d(canvas0, paint0, 0.0f, 1.0f, e0.d, v2, 0);
                v3 = 0;
            }
            else {
                m m0 = (m)((ArrayList)this.m.b).get(0);
                Object object0 = com.iloen.melon.utils.a.i(1, ((ArrayList)this.m.b));
                n n0 = this.l;
                if(n0 instanceof v6.p) {
                    v3 = v1;
                    n0.d(canvas0, paint0, 0.0f, m0.a, e0.d, v2, v3);
                    this.l.d(canvas0, paint0, ((m)object0).b, 1.0f, e0.d, v2, v3);
                }
                else {
                    v3 = v1;
                    v2 = 0;
                    n0.d(canvas0, paint0, ((m)object0).b, m0.a + 1.0f, e0.d, 0, v3);
                }
            }
            for(int v = 0; v < ((ArrayList)this.m.b).size(); ++v) {
                m m1 = (m)((ArrayList)this.m.b).get(v);
                this.l.c(canvas0, paint0, m1, this.j);
                if(v > 0 && v3 > 0) {
                    float f1 = ((m)((ArrayList)this.m.b).get(v - 1)).b;
                    this.l.d(canvas0, paint0, f1, m1.a, e0.d, v2, v3);
                }
            }
            canvas0.restore();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.l.e();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.l.f();
    }
}

