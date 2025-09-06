package Z;

import androidx.appcompat.app.o;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import y0.s;

public final class e {
    public final b0 a;
    public final b0 b;
    public final b0 c;
    public final b0 d;
    public final b0 e;
    public final b0 f;
    public final b0 g;
    public final b0 h;
    public final b0 i;
    public final b0 j;
    public final b0 k;
    public final b0 l;
    public final b0 m;

    public e(long v, long v1, long v2, long v3, long v4, long v5, long v6, long v7, long v8, long v9, long v10, long v11) {
        this.a = w.r(new s(v), V.f);
        this.b = w.r(new s(v1), V.f);
        this.c = w.r(new s(v2), V.f);
        this.d = w.r(new s(v3), V.f);
        this.e = w.r(new s(v4), V.f);
        this.f = w.r(new s(v5), V.f);
        this.g = w.r(new s(v6), V.f);
        this.h = w.r(new s(v7), V.f);
        this.i = w.r(new s(v8), V.f);
        this.j = w.r(new s(v9), V.f);
        this.k = w.r(new s(v10), V.f);
        this.l = w.r(new s(v11), V.f);
        this.m = w.r(Boolean.TRUE, V.f);
    }

    public final long a() {
        return ((s)((O0)this.k).getValue()).a;
    }

    public final long b() {
        return ((s)((O0)this.a).getValue()).a;
    }

    public final long c() {
        return ((s)((O0)this.f).getValue()).a;
    }

    public final boolean d() {
        return ((Boolean)((O0)this.m).getValue()).booleanValue();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Colors(primary=");
        stringBuilder0.append(s.j(this.b()));
        stringBuilder0.append(", primaryVariant=");
        o.x(((s)((O0)this.b).getValue()).a, ", secondary=", stringBuilder0);
        o.x(((s)((O0)this.c).getValue()).a, ", secondaryVariant=", stringBuilder0);
        o.x(((s)((O0)this.d).getValue()).a, ", background=", stringBuilder0);
        stringBuilder0.append(s.j(((s)((O0)this.e).getValue()).a));
        stringBuilder0.append(", surface=");
        stringBuilder0.append(s.j(this.c()));
        stringBuilder0.append(", error=");
        o.x(((s)((O0)this.g).getValue()).a, ", onPrimary=", stringBuilder0);
        o.x(((s)((O0)this.h).getValue()).a, ", onSecondary=", stringBuilder0);
        o.x(((s)((O0)this.i).getValue()).a, ", onBackground=", stringBuilder0);
        stringBuilder0.append(s.j(((s)((O0)this.j).getValue()).a));
        stringBuilder0.append(", onSurface=");
        stringBuilder0.append(s.j(this.a()));
        stringBuilder0.append(", onError=");
        stringBuilder0.append(s.j(((s)((O0)this.l).getValue()).a));
        stringBuilder0.append(", isLight=");
        stringBuilder0.append(this.d());
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

