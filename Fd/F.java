package Fd;

import H0.e;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class f implements a {
    public final int a;
    public final D b;

    public f(D d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                Context context0 = this.b.getContext();
                Object object0 = context0 == null ? null : context0.getSystemService("input_method");
                q.e(object0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager)object0;
            }
            case 1: {
                e.w(this.b);
                return H.a;
            }
            case 2: {
                e.w(this.b);
                return H.a;
            }
            case 3: {
                e.w(this.b);
                return H.a;
            }
            default: {
                this.b.sendUserEvent(Fd.H.a);
                return H.a;
            }
        }
    }
}

