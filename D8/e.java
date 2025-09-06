package d8;

public class e {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public static final e[] i;

    static {
        e.i = new e[]{new e(false, 3, 5, 8, 8, 1, 3, 5), new e(false, 5, 7, 10, 10, 1, 5, 7), new e(true, 5, 7, 16, 6, 1, 5, 7), new e(false, 8, 10, 12, 12, 1, 8, 10), new e(true, 10, 11, 14, 6, 2, 10, 11), new e(false, 12, 12, 14, 14, 1, 12, 12), new e(true, 16, 14, 24, 10, 1, 16, 14), new e(false, 18, 14, 16, 16, 1, 18, 14), new e(false, 22, 18, 18, 18, 1, 22, 18), new e(true, 22, 18, 16, 10, 2, 22, 18), new e(false, 30, 20, 20, 20, 1, 30, 20), new e(true, 0x20, 24, 16, 14, 2, 0x20, 24), new e(false, 36, 24, 22, 22, 1, 36, 24), new e(false, 44, 28, 24, 24, 1, 44, 28), new e(true, 49, 28, 22, 14, 2, 49, 28), new e(false, 62, 36, 14, 14, 4, 62, 36), new e(false, 86, 42, 16, 16, 4, 86, 42), new e(false, 0x72, 0x30, 18, 18, 4, 0x72, 0x30), new e(false, 0x90, 56, 20, 20, 4, 0x90, 56), new e(false, 0xAE, 68, 22, 22, 4, 0xAE, 68), new e(false, 204, 84, 24, 24, 4, 102, 42), new e(false, 280, 0x70, 14, 14, 16, 140, 56), new e(false, 0x170, 0x90, 16, 16, 16, 92, 36), new e(false, 456, 0xC0, 18, 18, 16, 0x72, 0x30), new e(false, 0x240, 0xE0, 20, 20, 16, 0x90, 56), new e(false, 696, 0x110, 22, 22, 16, 0xAE, 68), new e(false, 0x330, 0x150, 24, 24, 16, 0x88, 56), new e(false, 1050, 408, 18, 18, 36, 0xAF, 68), new e(false, 1304, 0x1F0, 20, 20, 36, 0xA3, 62), new a(false, 0x616, 620, 22, 22, 36, -1, 62)};  // 初始化器: Ld8/e;-><init>(ZIIIIIII)V
    }

    public e(boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6) {
        this.a = z;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
        this.f = v4;
        this.g = v5;
        this.h = v6;
    }

    public int a(int v) {
        return this.g;
    }

    public final int b() {
        switch(this.f) {
            case 1: 
            case 2: 
            case 4: {
                return 1;
            }
            case 16: {
                return 4;
            }
            case 36: {
                return 6;
            }
            default: {
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
    }

    public int c() {
        return this.b / this.g;
    }

    public final int d() {
        switch(this.f) {
            case 1: 
            case 2: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 16: {
                return 4;
            }
            case 36: {
                return 6;
            }
            default: {
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
    }

    public static e e(int v, f f0) {
        for(int v1 = 0; v1 < 30; ++v1) {
            e e0 = e.i[v1];
            if((f0 != f.b || !e0.a) && (f0 != f.c || e0.a) && v <= e0.b) {
                return e0;
            }
        }
        throw new IllegalArgumentException("Can\'t find a symbol arrangement that matches the message. Data codewords: " + v);
    }

    @Override
    public final String toString() {
        int v = this.b();
        int v1 = this.b();
        int v2 = this.d();
        int v3 = this.d();
        return (this.a ? "Rectangular Symbol:" : "Square Symbol:") + " data region " + this.d + 'x' + this.e + ", symbol size " + (v * this.d + (v1 << 1)) + 'x' + (v2 * this.e + (v3 << 1)) + ", symbol data size " + this.b() * this.d + 'x' + this.d() * this.e + ", codewords " + this.b + '+' + this.c;
    }
}

