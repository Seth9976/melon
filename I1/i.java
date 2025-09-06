package i1;

import A0.e;
import a1.A;
import a1.y;
import android.text.TextPaint;
import java.util.ArrayList;
import l1.l;
import y0.P;
import y0.o;
import y0.q;

public abstract class i {
    public static final j a;

    static {
        i.a = new j(false);
    }

    public static final void a(y y0, q q0, o o0, float f, P p0, l l0, e e0) {
        ArrayList arrayList0 = y0.h;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            A a0 = (A)arrayList0.get(v1);
            a0.a.g(q0, o0, f, p0, l0, e0);
            q0.i(0.0f, a0.a.b());
        }
    }

    public static final void b(TextPaint textPaint0, float f) {
        if(!Float.isNaN(f)) {
            if(f < 0.0f) {
                f = 0.0f;
            }
            if(f > 1.0f) {
                f = 1.0f;
            }
            textPaint0.setAlpha(Math.round(f * 255.0f));
        }
    }
}

