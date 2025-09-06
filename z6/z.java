package z6;

import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;

public abstract class z {
    public boolean a;
    public boolean b;
    public o c;
    public RectF d;
    public final Path e;

    public z() {
        this.a = false;
        this.b = false;
        this.d = new RectF();
        this.e = new Path();
    }

    public abstract void a(FrameLayout arg1);

    public abstract boolean b();

    public final void c() {
        RectF rectF0 = this.d;
        if(rectF0.left <= rectF0.right && rectF0.top <= rectF0.bottom) {
            o o0 = this.c;
            if(o0 != null) {
                p.a.b(o0, 1.0f, rectF0, null, this.e);
            }
        }
    }
}

