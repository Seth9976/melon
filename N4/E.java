package N4;

import android.view.ViewGroup;
import androidx.transition.Transition;

public final class e extends U {
    public boolean a;
    public final ViewGroup b;

    public e(ViewGroup viewGroup0) {
        this.a = false;
        this.b = viewGroup0;
    }

    @Override  // N4.U
    public final void a() {
        L.l(this.b, false);
    }

    @Override  // N4.U
    public final void d() {
        L.l(this.b, true);
    }

    @Override  // N4.U
    public final void f(Transition transition0) {
        if(!this.a) {
            L.l(this.b, false);
        }
        transition0.A(this);
    }

    @Override  // N4.U
    public final void g(Transition transition0) {
        L.l(this.b, false);
        this.a = true;
    }
}

