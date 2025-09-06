package c9;

import android.content.Context;

public final class c extends oe.c {
    public int B;
    public Context r;
    public Object w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.B |= 0x80000000;
        return i.a(null, this);
    }
}

