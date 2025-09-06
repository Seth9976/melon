package kd;

import androidx.compose.runtime.b0;
import ie.H;
import jd.a0;
import we.a;
import we.k;

public final class v implements a {
    public final boolean a;
    public final k b;
    public final a c;
    public final b0 d;
    public final b0 e;

    public v(boolean z, k k0, a a0, b0 b00, b0 b01) {
        this.a = z;
        this.b = k0;
        this.c = a0;
        this.d = b00;
        this.e = b01;
    }

    @Override  // we.a
    public final Object invoke() {
        b0 b00 = this.d;
        if(!((Boolean)b00.getValue()).booleanValue()) {
            if(!this.a) {
                b00.setValue(Boolean.TRUE);
            }
            a0 a00 = new a0(((String)this.e.getValue()));
            this.b.invoke(a00);
            this.e.setValue("");
            this.c.invoke();
        }
        return H.a;
    }
}

