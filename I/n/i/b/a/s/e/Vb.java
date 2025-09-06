package i.n.i.b.a.s.e;

public final class vb {
    public final int a;
    public final int b;

    public vb(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof vb) {
                ((vb)object0).getClass();
                return this.a == ((vb)object0).a && this.b == ((vb)object0).b;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (this.a + 0x3FD1) * 0x1F + this.b;
    }
}

