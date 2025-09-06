package L5;

import O4.f;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.O0;
import e1.m;
import ie.j;
import kotlin.jvm.internal.q;
import x0.e;

public final class a implements Drawable.Callback {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void invalidateDrawable(Drawable drawable0) {
        Object object0 = this.b;
        if(this.a != 0) {
            ((f)object0).invalidateSelf();
            return;
        }
        q.g(drawable0, "d");
        Integer integer0 = (int)(((Number)((O0)((b)object0).b).getValue()).intValue() + 1);
        ((O0)((b)object0).b).setValue(integer0);
        Drawable drawable1 = ((b)object0).a;
        e e0 = new e((drawable1.getIntrinsicWidth() < 0 || drawable1.getIntrinsicHeight() < 0 ? 0x7FC000007FC00000L : m.i(drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight())));
        ((O0)((b)object0).c).setValue(e0);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void scheduleDrawable(Drawable drawable0, Runnable runnable0, long v) {
        if(this.a != 0) {
            ((f)this.b).scheduleSelf(runnable0, v);
            return;
        }
        q.g(drawable0, "d");
        q.g(runnable0, "what");
        ((Handler)((j)c.a).getValue()).postAtTime(runnable0, v);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
        if(this.a != 0) {
            ((f)this.b).unscheduleSelf(runnable0);
            return;
        }
        q.g(drawable0, "d");
        q.g(runnable0, "what");
        ((Handler)((j)c.a).getValue()).removeCallbacks(runnable0);
    }
}

