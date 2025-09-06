package g7;

import java.io.InputStream;

public final class j extends InputStream {
    public int a;
    public int b;
    public final l c;

    public j(l l0, i i0) {
        this.c = l0;
        super();
        this.a = l0.q(i0.a + 4);
        this.b = i0.b;
    }

    @Override
    public final int read() {
        if(this.b == 0) {
            return -1;
        }
        this.c.a.seek(((long)this.a));
        int v = this.c.a.read();
        this.a = this.c.q(this.a + 1);
        --this.b;
        return v;
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        if(arr_b == null) {
            throw new NullPointerException("buffer");
        }
        if((v | v1) < 0 || v1 > arr_b.length - v) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int v2 = this.b;
        if(v2 > 0) {
            if(v1 > v2) {
                v1 = v2;
            }
            this.c.n(this.a, v, v1, arr_b);
            this.a = this.c.q(this.a + v1);
            this.b -= v1;
            return v1;
        }
        return -1;
    }
}

