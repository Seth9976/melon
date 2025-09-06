package M;

import androidx.appcompat.app.o;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import kotlin.jvm.internal.q;
import r1.c;
import r1.m;

public final class v0 implements x0 {
    public final String a;
    public final b0 b;

    public v0(X x0, String s) {
        this.a = s;
        this.b = w.s(x0);
    }

    @Override  // M.x0
    public final int a(c c0, m m0) {
        return this.e().c;
    }

    @Override  // M.x0
    public final int b(c c0, m m0) {
        return this.e().a;
    }

    @Override  // M.x0
    public final int c(c c0) {
        return this.e().b;
    }

    @Override  // M.x0
    public final int d(c c0) {
        return this.e().d;
    }

    public final X e() {
        return (X)((O0)this.b).getValue();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof v0 ? q.b(this.e(), ((v0)object0).e()) : false;
    }

    public final void f(X x0) {
        ((O0)this.b).setValue(x0);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.a);
        stringBuilder0.append("(left=");
        stringBuilder0.append(this.e().a);
        stringBuilder0.append(", top=");
        stringBuilder0.append(this.e().b);
        stringBuilder0.append(", right=");
        stringBuilder0.append(this.e().c);
        stringBuilder0.append(", bottom=");
        return o.q(stringBuilder0, this.e().d, ')');
    }
}

