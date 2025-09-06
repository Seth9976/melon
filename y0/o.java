package y0;

import A1.k;
import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.jvm.internal.q;
import x0.e;

public abstract class O extends o {
    public Shader a;
    public long b;

    public O() {
        this.b = 0x7FC000007FC00000L;
    }

    @Override  // y0.o
    public final void a(float f, long v, J j0) {
        Shader shader0 = this.a;
        if(shader0 == null || !e.a(this.b, v)) {
            if(e.e(v)) {
                shader0 = null;
                this.a = null;
                this.b = 0x7FC000007FC00000L;
            }
            else {
                shader0 = this.b(v);
                this.a = shader0;
                this.b = v;
            }
        }
        long v1 = M.c(((Paint)((k)j0).c).getColor());
        long v2 = s.b;
        if(!s.d(v1, v2)) {
            ((k)j0).m(v2);
        }
        if(!q.b(((Shader)((k)j0).d), shader0)) {
            ((k)j0).q(shader0);
        }
        if(((float)((Paint)((k)j0).c).getAlpha()) / 255.0f == f) {
            return;
        }
        ((k)j0).k(f);
    }

    public abstract Shader b(long arg1);
}

