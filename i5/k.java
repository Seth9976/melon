package i5;

import android.graphics.Bitmap;
import oe.c;
import t5.j;
import t5.r;

public final class k extends c {
    public j B;
    public i5.c D;
    public Bitmap E;
    public Object G;
    public final n I;
    public int M;
    public n r;
    public r w;

    public k(n n0, c c0) {
        this.I = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return n.a(this.I, null, 0, this);
    }
}

