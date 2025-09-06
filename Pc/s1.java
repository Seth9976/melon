package pc;

import Bd.v;
import com.iloen.melon.net.mcp.response.MixUpPlayBase.PlaylistBase;
import com.iloen.melon.net.mcp.response.PlayDjMalrangBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.ArrayList;
import oe.c;

public final class s1 extends c {
    public v B;
    public StatsElementsBase D;
    public PlaylistBase E;
    public PlaylistBase G;
    public ArrayList I;
    public ArrayList M;
    public ArrayList N;
    public ArrayList S;
    public Object T;
    public ArrayList V;
    public Object W;
    public ArrayList X;
    public int Y;
    public int Z;
    public Object b0;
    public final w1 c0;
    public int d0;
    public String r;
    public PlayDjMalrangBase w;

    public s1(w1 w10, c c0) {
        this.c0 = w10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.b0 = object0;
        this.d0 |= 0x80000000;
        return this.c0.c(null, null, null, this);
    }
}

