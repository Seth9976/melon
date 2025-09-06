package y2;

import android.media.MediaDataSource;
import java.io.IOException;

public final class a extends MediaDataSource {
    public long a;
    public final f b;

    public a(f f0) {
        this.b = f0;
        super();
    }

    @Override
    public final void close() {
    }

    @Override  // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override  // android.media.MediaDataSource
    public final int readAt(long v, byte[] arr_b, int v1, int v2) {
        if(v2 == 0) {
            return 0;
        }
        if(Long.compare(v, 0L) < 0) {
            return -1;
        }
        try {
            long v3 = this.a;
            f f0 = this.b;
            if(Long.compare(v3, v) != 0) {
                if(v3 >= 0L && v >= v3 + ((long)f0.a.available())) {
                    return -1;
                }
                f0.f(v);
                this.a = v;
            }
            if(v2 > f0.a.available()) {
                v2 = f0.a.available();
            }
            int v4 = f0.read(arr_b, v1, v2);
            if(v4 >= 0) {
                this.a += (long)v4;
                return v4;
            }
        }
        catch(IOException unused_ex) {
        }
        this.a = -1L;
        return -1;
    }
}

