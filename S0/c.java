package s0;

import Q0.u;
import X0.q;
import Y0.a;
import android.graphics.Rect;
import android.view.autofill.AutofillId;
import androidx.collection.A;
import k8.Y;
import pc.t;

public final class c extends i {
    public final t a;
    public final q b;
    public final u c;
    public final a d;
    public final String e;
    public final Rect f;
    public final AutofillId g;
    public final A h;
    public boolean i;

    public c(t t0, q q0, u u0, a a0, String s) {
        this.a = t0;
        this.b = q0;
        this.c = u0;
        this.d = a0;
        this.e = s;
        this.f = new Rect();
        u0.setImportantForAutofill(1);
        AutofillId autofillId0 = u0.getAutofillId();
        if(autofillId0 == null) {
            throw Y.d("Required value was null.");
        }
        this.g = autofillId0;
        this.h = new A();
    }
}

