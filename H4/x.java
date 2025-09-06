package h4;

import androidx.media3.exoplayer.b0;
import e3.b;
import i.n.i.b.a.s.e.M7;
import java.util.Arrays;

public final class x {
    public int a;
    public boolean b;
    public boolean c;
    public Object d;
    public int e;

    public x(int v, int v1) {
        if(v1 != 1) {
            super();
            this.a = v;
            byte[] arr_b = new byte[0x83];
            this.d = arr_b;
            arr_b[2] = 1;
            return;
        }
        super();
        this.a = v;
        byte[] arr_b1 = new byte[0x83];
        this.d = arr_b1;
        arr_b1[2] = 1;
    }

    public x(b0 b00) {
        this.d = b00;
    }

    public void a(byte[] arr_b, int v, int v1) {
        if(!this.b) {
            return;
        }
        int v2 = v1 - v;
        byte[] arr_b1 = (byte[])this.d;
        int v3 = this.e + v2;
        if(arr_b1.length < v3) {
            this.d = Arrays.copyOf(arr_b1, v3 * 2);
        }
        System.arraycopy(arr_b, v, ((byte[])this.d), this.e, v2);
        this.e += v2;
    }

    public boolean b(int v) {
        if(!this.b) {
            return false;
        }
        this.e -= v;
        this.b = false;
        this.c = true;
        return true;
    }

    public void c(byte[] arr_b, int v, int v1) {
        if(!this.b) {
            return;
        }
        int v2 = v1 - v;
        byte[] arr_b1 = (byte[])this.d;
        int v3 = this.e;
        if(arr_b1.length < v3 + v2) {
            this.d = Arrays.copyOf(arr_b1, (v3 + v2) * 2);
        }
        System.arraycopy(arr_b, v, ((byte[])this.d), this.e, v2);
        this.e += v2;
    }

    public void d() {
        this.b = false;
        this.c = false;
    }

    public void e(int v) {
        boolean z = true;
        M7.J(!this.b);
        if(v != this.a) {
            z = false;
        }
        this.b = z;
        if(z) {
            this.e = 3;
            this.c = false;
        }
    }

    public boolean f(int v) {
        if(!this.b) {
            return false;
        }
        this.e -= v;
        this.b = false;
        this.c = true;
        return true;
    }

    public void g(int v) {
        this.b |= v > 0;
        this.a += v;
    }

    public void h() {
        this.b = false;
        this.c = false;
    }

    public void i(int v) {
        boolean z = true;
        b.j(!this.b);
        if(v != this.a) {
            z = false;
        }
        this.b = z;
        if(z) {
            this.e = 3;
            this.c = false;
        }
    }
}

