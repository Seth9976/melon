package rd;

import com.melon.ui.K4;
import oe.c;

public final class k1 extends c {
    public final K1 B;
    public int D;
    public K4 r;
    public Object w;

    public k1(K1 k10, c c0) {
        this.B = k10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return K1.b(this.B, null, null, this);
    }
}

