package Ke;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;
import qf.c;
import qf.e;

public abstract class k {
    public final c a;
    public final String b;

    public k(String s, c c0) {
        q.g(c0, "packageFqName");
        super();
        this.a = c0;
        this.b = s;
    }

    public final e a(int v) {
        return e.e((this.b + v));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.a);
        stringBuilder0.append('.');
        return o.r(stringBuilder0, this.b, 'N');
    }
}

