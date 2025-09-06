package rf;

import java.io.OutputStream;
import java.util.ArrayList;

public final class c extends OutputStream {
    public final int a;
    public final ArrayList b;
    public int c;
    public byte[] d;
    public int e;
    public static final byte[] f;

    static {
        c.f = new byte[0];
    }

    public c() {
        this.a = 0x80;
        this.b = new ArrayList();
        this.d = new byte[0x80];
    }

    public final void c(int v) {
        s s0 = new s(this.d);
        this.b.add(s0);
        int v1 = this.c + this.d.length;
        this.c = v1;
        this.d = new byte[Math.max(this.a, Math.max(v, v1 >>> 1))];
        this.e = 0;
    }

    public final void h() {
        int v = this.e;
        byte[] arr_b = this.d;
        ArrayList arrayList0 = this.b;
        if(v >= arr_b.length) {
            arrayList0.add(new s(this.d));
            this.d = c.f;
        }
        else if(v > 0) {
            byte[] arr_b1 = new byte[v];
            System.arraycopy(arr_b, 0, arr_b1, 0, Math.min(arr_b.length, v));
            arrayList0.add(new s(arr_b1));
        }
        this.c += this.e;
        this.e = 0;
    }

    public final d m() {
        synchronized(this) {
            this.h();
            ArrayList arrayList0 = this.b;
            if(arrayList0 == null) {
                new ArrayList();
                throw new NullPointerException();
            }
            return arrayList0.isEmpty() ? d.a : d.a(arrayList0.iterator(), arrayList0.size());
        }
    }

    @Override
    public final String toString() {
        synchronized(this) {
        }
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), ((int)(this.c + this.e)));
    }

    @Override
    public final void write(int v) {
        synchronized(this) {
            if(this.e == this.d.length) {
                this.c(1);
            }
            int v2 = this.e;
            this.e = v2 + 1;
            this.d[v2] = (byte)v;
        }
    }

    @Override
    public final void write(byte[] arr_b, int v, int v1) {
        synchronized(this) {
            byte[] arr_b1 = this.d;
            int v3 = this.e;
            if(v1 <= arr_b1.length - v3) {
                System.arraycopy(arr_b, v, arr_b1, v3, v1);
                this.e += v1;
            }
            else {
                int v4 = arr_b1.length - v3;
                System.arraycopy(arr_b, v, arr_b1, v3, v4);
                int v5 = v1 - v4;
                this.c(v5);
                System.arraycopy(arr_b, v + v4, this.d, 0, v5);
                this.e = v5;
            }
        }
    }
}

