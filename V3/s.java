package v3;

import androidx.media3.exoplayer.h0;
import b3.w0;
import e3.b;
import java.util.Objects;

public final class s {
    public final int a;
    public final h0[] b;
    public final o[] c;
    public final w0 d;
    public final Object e;

    public s(h0[] arr_h0, o[] arr_o, w0 w00, Object object0) {
        b.c(arr_h0.length == arr_o.length);
        this.b = arr_h0;
        this.c = (o[])arr_o.clone();
        this.d = w00;
        this.e = object0;
        this.a = arr_h0.length;
    }

    // 去混淆评级： 低(30)
    public final boolean a(s s0, int v) {
        return s0 == null ? false : Objects.equals(this.b[v], s0.b[v]) && Objects.equals(this.c[v], s0.c[v]);
    }

    public final boolean b(int v) {
        return this.b[v] != null;
    }
}

