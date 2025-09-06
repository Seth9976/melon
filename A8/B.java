package a8;

import java.util.Arrays;

public final class b implements Cloneable {
    public final int a;
    public final int b;
    public final int c;
    public final int[] d;

    public b(int v, int v1) {
        if(v <= 0 || v1 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = v;
        this.b = v1;
        int v2 = (v + 0x1F) / 0x20;
        this.c = v2;
        this.d = new int[v2 * v1];
    }

    public b(int v, int[] arr_v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = arr_v;
    }

    public final boolean a(int v, int v1) {
        return (this.d[v / 0x20 + v1 * this.c] >>> (v & 0x1F) & 1) != 0;
    }

    public final void b(int v, int v1) {
        int v2 = v / 0x20 + v1 * this.c;
        this.d[v2] |= 1 << (v & 0x1F);
    }

    public final void c(int v, int v1, int v2, int v3) {
        if(v1 < 0 || v < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if(v3 <= 0 || v2 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int v4 = v2 + v;
        int v5 = v3 + v1;
        if(v5 > this.b || v4 > this.a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while(v1 < v5) {
            int v6 = this.c * v1;
            for(int v7 = v; v7 < v4; ++v7) {
                int v8 = v7 / 0x20 + v6;
                this.d[v8] |= 1 << (v7 & 0x1F);
            }
            ++v1;
        }
    }

    @Override
    public final Object clone() {
        int[] arr_v = (int[])this.d.clone();
        return new b(this.a, arr_v, this.b, this.c);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b ? this.a == ((b)object0).a && this.b == ((b)object0).b && this.c == ((b)object0).c && Arrays.equals(this.d, ((b)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.d) + (((this.a * 0x1F + this.a) * 0x1F + this.b) * 0x1F + this.c) * 0x1F;
    }

    @Override
    public final String toString() {
        int v = this.a;
        int v1 = this.b;
        StringBuilder stringBuilder0 = new StringBuilder((v + 1) * v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            for(int v3 = 0; v3 < v; ++v3) {
                stringBuilder0.append((this.a(v3, v2) ? "X " : "  "));
            }
            stringBuilder0.append("\n");
        }
        return stringBuilder0.toString();
    }
}

