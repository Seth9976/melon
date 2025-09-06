package Ac;

import com.iloen.melon.custom.L0;
import com.melon.net.res.v3.MediaAttachHelper.AttachImageData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import oe.c;

public final class p4 extends c {
    public String B;
    public Collection D;
    public Iterator E;
    public AttachImageData G;
    public int I;
    public int M;
    public int N;
    public int S;
    public int T;
    public int V;
    public int W;
    public Object X;
    public final r4 Y;
    public int Z;
    public List r;
    public L0 w;

    public p4(r4 r40, c c0) {
        this.Y = r40;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.i(this);
    }
}

