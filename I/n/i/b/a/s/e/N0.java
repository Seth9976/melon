package i.n.i.b.a.s.e;

import B3.v;
import java.io.EOFException;
import java.util.Arrays;

public final class n0 implements q4 {
    public final byte[] a;
    public boolean b;
    public long c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public long h;
    public U5 i;
    public ie j;
    public K8 k;
    public boolean l;
    public static final p m;
    public static final int[] n;
    public static final int[] o;
    public static final byte[] p;
    public static final byte[] q;
    public static final int r;

    static {
        n0.m = new p(1);
        n0.n = new int[]{13, 14, 16, 18, 20, 21, 27, 0x20, 6, 7, 6, 6, 1, 1, 1, 1};
        n0.o = new int[]{18, 24, 33, 37, 41, 0x2F, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        n0.p = new byte[]{35, 33, 65, 77, 82, 10};
        n0.q = new byte[]{35, 33, 65, 77, 82, 45, 87, 66, 10};
        n0.r = 61;
    }

    public n0() {
        this.a = new byte[1];
        this.g = -1;
    }

    public final int a(i5 i50) {
        i50.b();
        i50.s(this.a, 0, 1);
        int v = this.a[0];
        if((v & 0x83) > 0) {
            throw new H4("Invalid padding bits for frame header " + v);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v1 = v >> 3 & 15;
        boolean z = this.b;
        if((!z || v1 >= 10 && v1 <= 13) && (z || v1 >= 12 && v1 <= 14)) {
            throw new H4("Illegal AMR " + (this.b ? "WB" : "NB") + " frame type " + v1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return z ? n0.o[v1] : n0.n[v1];
    }

    public final boolean b(i5 i50) {
        i50.b();
        byte[] arr_b = n0.p;
        byte[] arr_b1 = new byte[arr_b.length];
        i50.s(arr_b1, 0, arr_b.length);
        if(Arrays.equals(arr_b1, arr_b)) {
            this.b = false;
            i50.a(arr_b.length);
            return true;
        }
        i50.b();
        byte[] arr_b2 = n0.q;
        byte[] arr_b3 = new byte[arr_b2.length];
        i50.s(arr_b3, 0, arr_b2.length);
        if(Arrays.equals(arr_b3, arr_b2)) {
            this.b = true;
            i50.a(arr_b2.length);
            return true;
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.h = 0L;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        return this.b(i50);
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        int v2;
        M7.G(this.j);
        if(((D2)i50).d == 0L && !this.b(i50)) {
            throw new H4("Could not find AMR header.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        if(!this.l) {
            this.l = true;
            boolean z = this.b;
            ie ie0 = this.j;
            ob ob0 = new ob();
            ob0.k = z ? "audio/amr-wb" : "audio/3gpp";
            ob0.l = n0.r;
            ob0.x = 1;
            ob0.y = z ? 16000 : 8000;
            ie0.a(new u(ob0));
        }
        int v1 = -1;
        if(this.e == 0) {
            try {
                v2 = this.a(i50);
                this.d = v2;
                this.e = v2;
                if(this.g == -1) {
                    goto label_19;
                }
                goto label_20;
            }
            catch(EOFException unused_ex) {
                goto label_28;
            }
        label_19:
            this.g = v2;
        }
    label_20:
        int v3 = this.j.e(i50, this.e, true);
        if(v3 != -1) {
            int v4 = this.e - v3;
            this.e = v4;
            v1 = 0;
            if(v4 <= 0) {
                this.j.f(this.c + this.h, 1, this.d, 0, null);
                this.c += 20000L;
            }
        }
    label_28:
        if(!this.f) {
            K8 k80 = new K8(0x8000000000000001L);
            this.k = k80;
            this.i.t(k80);
            this.f = true;
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.i = u50;
        this.j = u50.i(0, 1);
        u50.b();
    }
}

