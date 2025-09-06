package k5;

import android.graphics.drawable.Drawable;
import oe.c;

public final class w extends c {
    public Object B;
    public final y D;
    public int E;
    public y r;
    public Drawable w;

    public w(y y0, c c0) {
        this.D = y0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(null, this);
    }
}

