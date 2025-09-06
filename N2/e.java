package n2;

import ie.H;
import k2.b;
import kotlin.jvm.internal.r;
import okio.Path;
import we.a;

public final class e extends r implements a {
    public final int f;
    public final f g;

    public e(f f0, int v) {
        this.f = v;
        this.g = f0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            synchronized(f.g) {
                String s = ((Path)this.g.e.getValue()).toString();
                f.f.remove(s);
                return H.a;
            }
        }
        b b0 = this.g.d;
        Path path0 = (Path)b0.invoke();
        if(!path0.isAbsolute()) {
            throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + b0 + ", instead got " + path0).toString());
        }
        return path0.normalized();
    }
}

