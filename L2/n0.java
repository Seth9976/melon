package l2;

import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.q;

public final class n0 extends OutputStream {
    public final FileOutputStream a;

    public n0(FileOutputStream fileOutputStream0) {
        this.a = fileOutputStream0;
    }

    @Override
    public final void close() {
    }

    @Override
    public final void flush() {
        this.a.flush();
    }

    @Override
    public final void write(int v) {
        this.a.write(v);
    }

    @Override
    public final void write(byte[] arr_b) {
        q.g(arr_b, "b");
        this.a.write(arr_b);
    }

    @Override
    public final void write(byte[] arr_b, int v, int v1) {
        q.g(arr_b, "bytes");
        this.a.write(arr_b, v, v1);
    }
}

