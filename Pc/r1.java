package pc;

import com.iloen.melon.net.mcp.response.MixUpPlayBase.PlaylistBase;
import com.iloen.melon.net.mcp.response.PlayDjMalrangBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.ArrayList;
import oe.c;

public final class r1 extends c {
    public StatsElementsBase B;
    public PlaylistBase D;
    public PlaylistBase E;
    public ArrayList G;
    public ArrayList I;
    public ArrayList M;
    public ArrayList N;
    public Object S;
    public ArrayList T;
    public Object V;
    public ArrayList W;
    public int X;
    public int Y;
    public Object Z;
    public final w1 b0;
    public int c0;
    public String r;
    public PlayDjMalrangBase w;

    public r1(w1 w10, c c0) {
        this.b0 = w10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Z = object0;
        this.c0 |= 0x80000000;
        return this.b0.b(null, null, null, this);
    }
}

