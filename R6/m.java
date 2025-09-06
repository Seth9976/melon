package r6;

public final class m extends n {
    public final int e;
    public final q f;

    public m(q q0, int v) {
        this.e = v;
        this.f = q0;
        super(q0);
    }

    @Override  // r6.n
    public final float a() {
        switch(this.e) {
            case 0: {
                return this.f.h + this.f.i;
            }
            case 1: {
                return this.f.h + this.f.j;
            }
            default: {
                return this.f.h;
            }
        }
    }
}

