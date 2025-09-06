package pc;

import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oe.c;

public final class t1 extends c {
    public String B;
    public StatsElementsBase D;
    public StatsElementsBase E;
    public StatsElementsBase G;
    public ArrayList I;
    public ArrayList M;
    public ArrayList N;
    public ArrayList S;
    public List T;
    public Object V;
    public Iterator W;
    public int X;
    public int Y;
    public Object Z;
    public final w1 b0;
    public int c0;
    public String r;
    public String w;

    public t1(w1 w10, c c0) {
        this.b0 = w10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Z = object0;
        this.c0 |= 0x80000000;
        return this.b0.g(null, null, null, null, null, null, null, null, this);
    }
}

