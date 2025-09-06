package t5;

import A7.d;
import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache.Key;
import k5.g;
import kotlin.jvm.internal.q;

public final class s extends k {
    public final Drawable a;
    public final j b;
    public final g c;
    public final MemoryCache.Key d;
    public final String e;
    public final boolean f;
    public final boolean g;

    public s(Drawable drawable0, j j0, g g0, MemoryCache.Key memoryCache$Key0, String s, boolean z, boolean z1) {
        this.a = drawable0;
        this.b = j0;
        this.c = g0;
        this.d = memoryCache$Key0;
        this.e = s;
        this.f = z;
        this.g = z1;
    }

    @Override  // t5.k
    public final Drawable a() {
        return this.a;
    }

    @Override  // t5.k
    public final j b() {
        return this.b;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof s && q.b(this.a, ((s)object0).a) && q.b(this.b, ((s)object0).b) && this.c == ((s)object0).c && q.b(this.d, ((s)object0).d) && q.b(this.e, ((s)object0).e) && this.f == ((s)object0).f && this.g == ((s)object0).g;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.b.hashCode();
        int v2 = this.c.hashCode();
        int v3 = 0;
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v3 = s.hashCode();
        }
        return Boolean.hashCode(this.g) + d.e((((v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F + v4) * 0x1F + v3) * 0x1F, 0x1F, this.f);
    }
}

