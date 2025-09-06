package N0;

public final class j0 {
    public final m0 a;
    public I b;
    public final i0 c;
    public final i0 d;
    public final i0 e;

    public j0(m0 m00) {
        this.a = m00;
        this.c = new i0(this, 2);
        this.d = new i0(this, 0);
        this.e = new i0(this, 1);
    }

    public final I a() {
        I i0 = this.b;
        if(i0 == null) {
            throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
        }
        return i0;
    }
}

