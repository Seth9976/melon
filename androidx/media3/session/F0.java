package androidx.media3.session;

import B9.g;
import I6.V;
import android.text.TextUtils;
import java.util.ArrayList;

public final class f0 extends y0 {
    public final void c(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException();
        }
        n0 n00 = this.a;
        ArrayList arrayList0 = n00.E.a.e();
        int v = 0;
        while(v < arrayList0.size()) {
            w0 w00 = (w0)arrayList0.get(v);
            if(!n00.A || !n00.k(w00)) {
                n00.c(w00, new g(28, n00, s));
            }
            else {
                V v1 = n00.h.f.k();
                int v2 = 0;
                while(true) {
                    w00 = null;
                    if(v2 < v1.size()) {
                        w0 w01 = (w0)v1.get(v2);
                        if(n0.m(w01)) {
                            w00 = w01;
                        }
                        else {
                            ++v2;
                            continue;
                        }
                    }
                    break;
                }
                if(w00 != null) {
                    n00.c(w00, new g(28, n00, s));
                }
            }
            ++v;
        }
    }
}

