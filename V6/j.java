package v6;

import E9.h;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings.Global;
import u2.e;
import u2.f;

public final class j extends l {
    public final n l;
    public final f m;
    public final e n;
    public final m o;
    public boolean r;
    public static final i w;

    static {
        j.w = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public j(Context context0, v6.e e0, n n0) {
        super(context0, e0);
        this.r = false;
        this.l = n0;
        this.o = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        f f0 = new f();
        this.m = f0;
        f0.b = 1.0;
        f0.c = false;
        f0.a(50.0f);
        e e1 = new e(this);
        this.n = e1;
        e1.m = f0;
        if(this.h != 1.0f) {
            this.h = 1.0f;
            this.invalidateSelf();
        }
    }

    @Override  // v6.l
    public final boolean d(boolean z, boolean z1, boolean z2) {
        boolean z3 = super.d(z, z1, z2);
        a a0 = this.c;
        ContentResolver contentResolver0 = this.a.getContentResolver();
        a0.getClass();
        float f = Settings.Global.getFloat(contentResolver0, "animator_duration_scale", 1.0f);
        if(f == 0.0f) {
            this.r = true;
            return z3;
        }
        this.r = false;
        this.m.a(50.0f / f);
        return z3;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        Rect rect0 = new Rect();
        if(!this.getBounds().isEmpty() && this.isVisible() && canvas0.getClipBounds(rect0)) {
            canvas0.save();
            Rect rect1 = this.getBounds();
            float f = this.b();
            boolean z = this.d != null && this.d.isRunning();
            boolean z1 = this.e != null && this.e.isRunning();
            this.l.a.a();
            this.l.a(canvas0, rect1, f, z, z1);
            Paint paint0 = this.i;
            paint0.setStyle(Paint.Style.FILL);
            paint0.setAntiAlias(true);
            v6.e e0 = this.b;
            m m0 = this.o;
            m0.c = e0.c[0];
            int v = e0.g;
            if(v > 0) {
                if(!(this.l instanceof p)) {
                    v = (int)(h.q(m0.b, 0.0f, 0.01f) * ((float)v) / 0.01f);
                }
                this.l.d(canvas0, paint0, m0.b, 1.0f, e0.d, this.j, v);
            }
            else {
                this.l.d(canvas0, paint0, 0.0f, 1.0f, e0.d, this.j, 0);
            }
            this.l.c(canvas0, paint0, m0, this.j);
            this.l.b(canvas0, paint0, e0.c[0], this.j);
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

    @Override  // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.n.c();
        this.o.b = ((float)this.getLevel()) / 10000.0f;
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int v) {
        m m0 = this.o;
        e e0 = this.n;
        if(this.r) {
            e0.c();
            m0.b = ((float)v) / 10000.0f;
            this.invalidateSelf();
            return true;
        }
        e0.b = m0.b * 10000.0f;
        e0.c = true;
        e0.a(((float)v));
        return true;
    }
}

