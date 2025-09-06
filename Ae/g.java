package Ae;

import java.io.Serializable;

public final class g extends f implements Serializable {
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    private static final long serialVersionUID;

    @Override  // Ae.f
    public final int a(int v) {
        return -v >> 0x1F & this.b() >>> 0x20 - v;
    }

    @Override  // Ae.f
    public final int b() {
        int v = this.c ^ this.c >>> 2;
        this.c = this.d;
        this.d = this.e;
        this.e = this.f;
        this.f = this.g;
        int v1 = v ^ v << 1 ^ this.g ^ this.g << 4;
        this.g = v1;
        int v2 = this.h + 0x587C5;
        this.h = v2;
        return v1 + v2;
    }
}

