package m4;

public final class a {
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final b j;

    public a(b b0, int v, int v1) {
        this.j = b0;
        this.a = v;
        this.b = v1;
        this.a();
    }

    public final void a() {
        int[] arr_v = this.j.a;
        int[] arr_v1 = this.j.b;
        int v = 0x7FFFFFFF;
        int v1 = 0x80000000;
        int v2 = 0x80000000;
        int v3 = 0;
        int v4 = this.a;
        int v5 = 0x7FFFFFFF;
        int v6 = 0x7FFFFFFF;
        int v7 = 0x80000000;
        while(v4 <= this.b) {
            int v8 = arr_v[v4];
            v3 += arr_v1[v8];
            int v9 = v8 >> 10 & 0x1F;
            int v10 = v8 >> 5 & 0x1F;
            int v11 = v8 & 0x1F;
            if(v9 > v7) {
                v7 = v9;
            }
            if(v9 < v) {
                v = v9;
            }
            if(v10 > v1) {
                v1 = v10;
            }
            if(v10 < v5) {
                v5 = v10;
            }
            if(v11 > v2) {
                v2 = v11;
            }
            if(v11 < v6) {
                v6 = v11;
            }
            ++v4;
        }
        this.d = v;
        this.e = v7;
        this.f = v5;
        this.g = v1;
        this.h = v6;
        this.i = v2;
        this.c = v3;
    }

    public final int b() {
        return (this.i - this.h + 1) * ((this.g - this.f + 1) * (this.e - this.d + 1));
    }
}

