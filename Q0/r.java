package Q0;

import android.os.SystemClock;
import android.view.MotionEvent;
import ie.H;
import we.a;

public final class r extends kotlin.jvm.internal.r implements a {
    public final int f;
    public final u g;

    public r(u u0, int v) {
        this.f = v;
        this.g = u0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            return this.g.get_viewTreeOwners();
        }
        u u0 = this.g;
        MotionEvent motionEvent0 = u0.N0;
        if(motionEvent0 != null) {
            switch(motionEvent0.getActionMasked()) {
                case 7: 
                case 9: {
                    u0.O0 = SystemClock.uptimeMillis();
                    u0.post(u0.R0);
                    break;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
    }
}

