package k5;

import e.k;
import java.io.Closeable;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import x5.g;

public final class p extends z {
    public final Path a;
    public final FileSystem b;
    public final String c;
    public final Closeable d;
    public boolean e;
    public BufferedSource f;

    public p(Path path0, FileSystem fileSystem0, String s, Closeable closeable0) {
        this.a = path0;
        this.b = fileSystem0;
        this.c = s;
        this.d = closeable0;
    }

    @Override
    public final void close() {
        synchronized(this) {
            this.e = true;
            BufferedSource bufferedSource0 = this.f;
            if(bufferedSource0 != null) {
                g.a(bufferedSource0);
            }
            Closeable closeable0 = this.d;
            if(closeable0 != null) {
                g.a(closeable0);
            }
        }
    }

    @Override  // k5.z
    public final Path h() {
        synchronized(this) {
            if(!this.e) {
                return this.a;
            }
        }
        throw new IllegalStateException("closed");
    }

    @Override  // k5.z
    public final Path m() {
        return this.h();
    }

    @Override  // k5.z
    public final k o() {
        return null;
    }

    @Override  // k5.z
    public final BufferedSource p() {
        synchronized(this) {
            if(!this.e) {
                BufferedSource bufferedSource0 = this.f;
                if(bufferedSource0 != null) {
                    return bufferedSource0;
                }
                BufferedSource bufferedSource1 = Okio.buffer(this.b.source(this.a));
                this.f = bufferedSource1;
                return bufferedSource1;
            }
        }
        throw new IllegalStateException("closed");
    }
}

