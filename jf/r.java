package jf;

public final class r {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final r f;
    public final boolean g;
    public final r h;
    public final r i;
    public final boolean j;
    public static final r k;

    static {
        r.k = new r(false, false, false, false, false, new r(false, false, false, false, false, null, false, null, null, 0x3FF), false, null, null, 988);
    }

    public r(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, r r0, boolean z5, r r1, r r2, int v) {
        boolean z6 = true;
        if((v & 1) != 0) {
            z = true;
        }
        if((v & 2) != 0) {
            z1 = true;
        }
        if((v & 4) != 0) {
            z2 = false;
        }
        if((v & 8) != 0) {
            z3 = false;
        }
        if((v & 16) != 0) {
            z4 = false;
        }
        if((v & 0x20) != 0) {
            r0 = null;
        }
        if((v & 0x40) != 0) {
            z5 = true;
        }
        if((v & 0x80) != 0) {
            r1 = r0;
        }
        if((v & 0x100) != 0) {
            r2 = r0;
        }
        if((v & 0x200) != 0) {
            z6 = false;
        }
        super();
        this.a = z;
        this.b = z1;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = r0;
        this.g = z5;
        this.h = r1;
        this.i = r2;
        this.j = z6;
    }
}

