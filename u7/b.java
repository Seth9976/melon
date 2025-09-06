package u7;

import java.io.OutputStream;

public final class b extends OutputStream {
    public long a;

    @Override
    public final void write(int v) {
        ++this.a;
    }

    @Override
    public final void write(byte[] arr_b) {
        this.a += (long)arr_b.length;
    }

    @Override
    public final void write(byte[] arr_b, int v, int v1) {
        if(v < 0 || v > arr_b.length || v1 < 0 || (v + v1 > arr_b.length || v + v1 < 0)) {
            throw new IndexOutOfBoundsException();
        }
        this.a += (long)v1;
    }
}

