package u0;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View.DragShadowBuilder;
import r1.c;
import r1.d;
import r1.m;
import we.k;
import y0.q;

public final class b extends View.DragShadowBuilder {
    public final d a;
    public final long b;
    public final k c;

    public b(d d0, long v, k k0) {
        this.a = d0;
        this.b = v;
        this.c = k0;
    }

    @Override  // android.view.View$DragShadowBuilder
    public final void onDrawShadow(Canvas canvas0) {
        A0.b b0 = new A0.b();
        y0.b b1 = new y0.b();
        b1.a = canvas0;
        c c0 = b0.a.a;
        m m0 = b0.a.b;
        q q0 = b0.a.c;
        long v = b0.a.d;
        b0.a.a = this.a;
        b0.a.b = m.a;
        b0.a.c = b1;
        b0.a.d = this.b;
        b1.q();
        this.c.invoke(b0);
        b1.j();
        b0.a.a = c0;
        b0.a.b = m0;
        b0.a.c = q0;
        b0.a.d = v;
    }

    @Override  // android.view.View$DragShadowBuilder
    public final void onProvideShadowMetrics(Point point0, Point point1) {
        point0.set(this.a.z(Float.intBitsToFloat(((int)(this.b >> 0x20))) / this.a.b()), this.a.z(Float.intBitsToFloat(((int)(this.b & 0xFFFFFFFFL))) / this.a.b()));
        point1.set(point0.x / 2, point0.y / 2);
    }
}

