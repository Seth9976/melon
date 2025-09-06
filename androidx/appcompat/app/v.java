package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;
import b.p;
import u6.b;
import we.a;

public final class v implements OnBackInvokedCallback {
    public final int a;
    public final Object b;

    public v(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch(this.a) {
            case 0: {
                ((D)this.b).E();
                return;
            }
            case 1: {
                ((Runnable)this.b).run();
                return;
            }
            case 2: {
                ((p)this.b).invoke();
                return;
            }
            case 3: {
                ((b)this.b).d();
                return;
            }
            default: {
                a a0 = (a)this.b;
                if(a0 != null) {
                    a0.invoke();
                }
            }
        }
    }
}

