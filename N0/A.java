package n0;

import androidx.compose.runtime.b0;
import androidx.lifecycle.M;
import d9.h;
import java.util.List;
import kotlin.jvm.internal.q;
import rd.K1;
import td.t1;

public final class a implements M {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                ((b0)object1).setValue(object0);
                return;
            }
            case 1: {
                q.g(((List)object0), "it");
                Boolean boolean1 = Boolean.valueOf(q.b(((h)((K1)object1).w.getValue()).m, ((K1)object1).getCurrentPlayable()));
                ((K1)object1).y.setValue(boolean1);
                return;
            }
            default: {
                q.g(((List)object0), "it");
                Boolean boolean0 = Boolean.valueOf(q.b(((h)((t1)object1).v.getValue()).m, ((t1)object1).getCurrentPlayable()));
                ((t1)object1).x.setValue(boolean0);
            }
        }
    }
}

