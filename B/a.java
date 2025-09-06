package b;

import android.window.BackEvent;
import androidx.appcompat.app.o;
import androidx.core.widget.l;
import kotlin.jvm.internal.q;

public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final int d;

    public a(BackEvent backEvent0) {
        q.g(backEvent0, "backEvent");
        float f = l.s(backEvent0);
        float f1 = l.t(backEvent0);
        float f2 = l.k(backEvent0);
        int v = l.q(backEvent0);
        super();
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BackEventCompat{touchX=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", touchY=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", progress=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", swipeEdge=");
        return o.q(stringBuilder0, this.d, '}');
    }
}

