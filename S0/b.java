package s0;

import android.graphics.Rect;
import android.view.autofill.AutofillManager;
import ie.H;
import kotlin.jvm.internal.r;
import we.p;

public final class b extends r implements p {
    public final c f;
    public final int g;

    public b(c c0, int v) {
        this.f = c0;
        this.g = v;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        Rect rect0 = new Rect(((Number)object0).intValue(), ((Number)object1).intValue(), ((Number)object2).intValue(), ((Number)object3).intValue());
        ((AutofillManager)this.f.a.b).notifyViewEntered(this.f.c, this.g, rect0);
        return H.a;
    }
}

