package s3;

import de.c;
import g3.f;
import g3.j;
import g3.w;
import java.util.Arrays;
import w3.h;

public final class b0 implements h {
    public final j a;
    public final w b;
    public byte[] c;

    public b0(f f0, j j0) {
        q.c.getAndIncrement();
        this.a = j0;
        this.b = new w(f0);
    }

    @Override  // w3.h
    public final void cancelLoad() {
    }

    @Override  // w3.h
    public final void load() {
        w w0;
        try {
            w0 = this.b;
            w0.b = 0L;
            w0.p(this.a);
            for(int v1 = 0; v1 != -1; v1 = w0.read(this.c, v2, this.c.length - v2)) {
                int v2 = (int)w0.b;
                byte[] arr_b = this.c;
                if(arr_b == null) {
                    this.c = new byte[0x400];
                }
                else if(v2 == arr_b.length) {
                    this.c = Arrays.copyOf(arr_b, arr_b.length * 2);
                }
            }
        }
        finally {
            c.n(w0);
        }
    }
}

