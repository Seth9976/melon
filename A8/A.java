package a8;

import java.util.Arrays;

public final class a implements Cloneable {
    public int[] a;
    public int b;

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    public final void a(boolean z) {
        this.c(this.b + 1);
        if(z) {
            this.a[this.b / 0x20] |= 1 << (this.b & 0x1F);
        }
        ++this.b;
    }

    public final void b(int v, int v1) {
        if(v1 < 0 || v1 > 0x20) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        this.c(this.b + v1);
        while(true) {
            boolean z = true;
            if(v1 <= 0) {
                break;
            }
            if((v >> v1 - 1 & 1) != 1) {
                z = false;
            }
            this.a(z);
            --v1;
        }
    }

    public final void c(int v) {
        int[] arr_v = this.a;
        if(v > arr_v.length << 5) {
            int[] arr_v1 = new int[(v + 0x1F) / 0x20];
            System.arraycopy(arr_v, 0, arr_v1, 0, arr_v.length);
            this.a = arr_v1;
        }
    }

    @Override
    public final Object clone() {
        int[] arr_v = (int[])this.a.clone();
        int v = this.b;
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = arr_v;
        a0.b = v;
        return a0;
    }

    public final boolean d(int v) {
        return (1 << (v & 0x1F) & this.a[v / 0x20]) != 0;
    }

    public final int e() {
        return (this.b + 7) / 8;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a ? this.b == ((a)object0).b && Arrays.equals(this.a, ((a)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.b * 0x1F;
        return Arrays.hashCode(this.a) + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(this.b / 8 + this.b + 1);
        for(int v = 0; v < this.b; ++v) {
            if((v & 7) == 0) {
                stringBuilder0.append(' ');
            }
            stringBuilder0.append(((char)(this.d(v) ? 88 : 46)));
        }
        return stringBuilder0.toString();
    }
}

