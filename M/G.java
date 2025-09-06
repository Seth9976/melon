package M;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;
import r1.c;
import r1.m;
import we.n;

public final class g implements f, h {
    public final float a;
    public final boolean b;
    public final n c;
    public final float d;

    public g(float f, boolean z, n n0) {
        this.a = f;
        this.b = z;
        this.c = n0;
        this.d = f;
    }

    @Override  // M.f, M.h
    public final float a() {
        return this.d;
    }

    @Override  // M.h
    public final void c(c c0, int v, int[] arr_v, int[] arr_v1) {
        this.d(c0, v, arr_v, m.a, arr_v1);
    }

    @Override  // M.f
    public final void d(c c0, int v, int[] arr_v, m m0, int[] arr_v1) {
        int v5;
        int v4;
        if(arr_v.length != 0) {
            int v1 = c0.z(this.a);
            if(!this.b || m0 != m.b) {
                int v3 = 0;
                v4 = 0;
                v5 = 0;
                for(int v6 = 0; v3 < arr_v.length; ++v6) {
                    int v7 = arr_v[v3];
                    int v8 = Math.min(v4, v - v7);
                    arr_v1[v6] = v8;
                    int v9 = Math.min(v1, v - v8 - v7);
                    ++v3;
                    v5 = v9;
                    v4 = arr_v1[v6] + v7 + v9;
                }
            }
            else {
                int v10 = arr_v.length - 1;
                v4 = 0;
                v5 = 0;
                while(-1 < v10) {
                    int v11 = arr_v[v10];
                    int v12 = Math.min(v4, v - v11);
                    arr_v1[v10] = v12;
                    v5 = Math.min(v1, v - v12 - v11);
                    v4 = arr_v1[v10] + v11 + v5;
                    --v10;
                }
            }
            int v13 = v4 - v5;
            n n0 = this.c;
            if(n0 != null && v13 < v) {
                int v14 = ((Number)n0.invoke(((int)(v - v13)), m0)).intValue();
                for(int v2 = 0; v2 < arr_v1.length; ++v2) {
                    arr_v1[v2] += v14;
                }
            }
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g && r1.f.a(this.a, ((g)object0).a) && this.b == ((g)object0).b && q.b(this.c, ((g)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = d.e(Float.hashCode(this.a) * 0x1F, 0x1F, this.b);
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append((this.b ? "" : "Absolute"));
        stringBuilder0.append("Arrangement#spacedAligned(");
        o.v(this.a, stringBuilder0, ", ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

