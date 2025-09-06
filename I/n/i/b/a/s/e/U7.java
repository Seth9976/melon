package i.n.i.b.a.s.e;

public final class u7 extends Exception {
    public final int a;
    public final boolean b;
    public final u c;

    public u7(int v, u u0, boolean z) {
        super("AudioTrack write failed: " + v);
        this.b = z;
        this.a = v;
        this.c = u0;
    }
}

