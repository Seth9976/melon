package k5;

import java.io.InputStream;

public final class l extends InputStream {
    public final InputStream a;
    public int b;

    public l(InputStream inputStream0) {
        this.a = inputStream0;
        this.b = 0x40000000;
    }

    @Override
    public final int available() {
        return this.b;
    }

    @Override
    public final void close() {
        this.a.close();
    }

    @Override
    public final int read() {
        int v = this.a.read();
        if(v == -1) {
            this.b = 0;
        }
        return v;
    }

    @Override
    public final int read(byte[] arr_b) {
        int v = this.a.read(arr_b);
        if(v == -1) {
            this.b = 0;
        }
        return v;
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        int v2 = this.a.read(arr_b, v, v1);
        if(v2 == -1) {
            this.b = 0;
        }
        return v2;
    }

    @Override
    public final long skip(long v) {
        return this.a.skip(v);
    }
}

