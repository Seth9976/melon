package c9;

import oe.c;
import org.json.JSONArray;

public final class e extends c {
    public final i B;
    public int D;
    public JSONArray r;
    public Object w;

    public e(i i0, c c0) {
        this.B = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(this);
    }
}

