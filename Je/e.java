package je;

import java.util.List;
import java.util.RandomAccess;

public final class e extends f implements RandomAccess {
    public final f a;
    public final int b;
    public final int c;

    public e(f f0, int v, int v1) {
        this.a = f0;
        this.b = v;
        f.Companion.getClass();
        c.d(v, v1, f0.size());
        this.c = v1 - v;
    }

    @Override
    public final Object get(int v) {
        f.Companion.getClass();
        c.b(v, this.c);
        return this.a.get(this.b + v);
    }

    @Override  // je.a
    public final int getSize() {
        return this.c;
    }

    @Override  // je.f
    public final List subList(int v, int v1) {
        f.Companion.getClass();
        c.d(v, v1, this.c);
        return new e(this.a, v + this.b, this.b + v1);
    }
}

