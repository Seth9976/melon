package B2;

public final class j implements i {
    public n a;
    public t b;
    public int c;

    public j() {
        this.a = l.a;
        this.c = 1;
    }

    @Override  // B2.i
    public final void a(n n0) {
        this.a = n0;
    }

    @Override  // B2.i
    public final n b() {
        return this.a;
    }

    @Override  // B2.i
    public final i copy() {
        i i0 = new j();
        i0.a = this.a;
        i0.b = this.b;
        i0.c = this.c;
        return i0;
    }

    @Override
    public final String toString() {
        return "EmittableImage(modifier=" + this.a + ", provider=" + this.b + ", colorFilterParams=null, contentScale=" + J2.j.a(this.c) + ')';
    }
}

