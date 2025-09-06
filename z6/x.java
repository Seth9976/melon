package z6;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public final class x {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public final ArrayList g;
    public final ArrayList h;

    public x() {
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f, float f1, float f2, float f3, float f4, float f5) {
        t t0 = new t(f, f1, f2, f3);
        t0.f = f4;
        t0.g = f5;
        this.g.add(t0);
        r r0 = new r(t0);
        float f6 = f4 + f5;
        if(f5 < 0.0f) {
            f4 = (f4 + 180.0f) % 360.0f;
        }
        this.b(f4);
        this.h.add(r0);
        this.e = f5 < 0.0f ? (f6 + 180.0f) % 360.0f : f6;
        this.c = (f2 - f) / 2.0f * ((float)Math.cos(Math.toRadians(f6))) + (f + f2) * 0.5f;
        this.d = (f3 - f1) / 2.0f * ((float)Math.sin(Math.toRadians(f6))) + (f1 + f3) * 0.5f;
    }

    public final void b(float f) {
        float f1 = this.e;
        if(f1 != f) {
            float f2 = (f - f1 + 360.0f) % 360.0f;
            if(f2 <= 180.0f) {
                t t0 = new t(this.c, this.d, this.c, this.d);
                t0.f = this.e;
                t0.g = f2;
                r r0 = new r(t0);
                this.h.add(r0);
                this.e = f;
            }
        }
    }

    public final void c(Matrix matrix0, Path path0) {
        ArrayList arrayList0 = this.g;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((v)arrayList0.get(v1)).a(matrix0, path0);
        }
    }

    public final void d(float f, float f1) {
        u u0 = new u();  // 初始化器: Lz6/v;-><init>()V
        u0.b = f;
        u0.c = f1;
        this.g.add(u0);
        s s0 = new s(u0, this.c, this.d);
        float f2 = s0.b();
        float f3 = s0.b();
        this.b(f2 + 270.0f);
        this.h.add(s0);
        this.e = f3 + 270.0f;
        this.c = f;
        this.d = f1;
    }

    public final void e(float f, float f1, float f2, float f3) {
        this.a = f;
        this.b = f1;
        this.c = f;
        this.d = f1;
        this.e = f2;
        this.f = (f2 + f3) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}

