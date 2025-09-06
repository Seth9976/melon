package n2;

import oe.c;
import okio.BufferedSink;
import okio.FileHandle;

public final class j extends c {
    public BufferedSink B;
    public Object D;
    public final k E;
    public int G;
    public FileHandle r;
    public FileHandle w;

    public j(k k0, c c0) {
        this.E = k0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.e(null, this);
    }
}

